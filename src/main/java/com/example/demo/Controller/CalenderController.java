package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import com.example.demo.Services.AccountService;
import com.example.demo.Services.LivraisonService;
import com.example.demo.Services.ScriptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/event")
public class CalenderController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private ScriptsRepository scriptsRepo;
    @Autowired
    EventRepository eventRepositoryent;
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    LivraisonRepository livraisonRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping("/GetAllEvent")
    public List<Event> GetAlleEvent(){

        return eventRepositoryent.findAll();

    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id){
        try {
            accountService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/deleteEvent/{id}")
    public void deleteCalender(@PathVariable Long id){
         eventRepositoryent.deleteById(id);
    }



    @PostMapping("/addEvent")
    public Event saveUser(@RequestBody Event event) throws ParseException {

       Event ev= eventRepositoryent.findByTitle(event.getTitle());

       if(ev==null)
       {
           eventRepositoryent.save(event);
           TestEvent(event);
           Scripts scripts= new Scripts(event.getTitle(),event.getStart(),"En cours","A",true,new Date(),event.getUsername());
           scriptsRepo.save(scripts);
       }


        return event;
    }


    public void TestEvent(Event event) throws ParseException {
        List<Event> list =eventRepositoryent.findAll();

        for (Event x : list)
        {	//System.out.println(x.getBloc());
             Date firstDate = x.getStart();
             Date secondDate = new Date();
             long days = ChronoUnit.DAYS.between(secondDate.toInstant(),firstDate.toInstant());

            List<Notification> kk=notificationRepository.findByIdevent(x.getId());
             System.out.println (kk.size());


            if(Math.abs(days)<=3)
            {
                //Notification notification=notificationRepository.find()
               if(kk.size()<1)
               {
                   Notification notif=new Notification(x.getTitle(), x.getStart(),x.getEnd(),x.getId());
                   notificationRepository.save(notif);
               }

            }
        }
    }
}
