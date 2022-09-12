package com.example.demo.Controller;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import com.example.demo.Repository.Historique;
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
import java.util.*;
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
    Historique historique;
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
    @GetMapping("/GetAllTiketTerminer")
    public  List<Integer>  GetAllTiketTerminer(){
        List<Livraison> list1= new ArrayList<>();
        List<Livraison> list2= new ArrayList<>();
        List<Livraison> list3= new ArrayList<>();


    List<Livraison> list=livraisonRepository.findAll();
        for (int i=0;i<list.size();i++)
        {
            if(list.get(i).getEtat().equals("Terminer"))
        {
            list1.add(list.get(i));
        }
         else   if(list.get(i).getEtat().equals("En cours"))
            {
                list2.add(list.get(i));
            }
          else
            {
                list3.add(list.get(i));
            }

        }


        List<Integer> listreturn=new ArrayList<>();
        listreturn.add(list1.size());
        listreturn.add(list2.size());
        listreturn.add(list3.size());


        return  listreturn;

    }
    @GetMapping("/findEventByusername/{Username}")
    public List<Integer> findEventByusername(@PathVariable String Username){
        List<Integer> Listretern=new ArrayList<>();
        List<User> list1=userRepository.findAll();
            for (int i=0;i<list1.size();i++)
            {
                List<Scripts> list=scriptsRepo.findByUsername(list1.get(i).getUsername());
                Listretern.add(list.size());
                System.out.println(list1.get(i).getUsername()+list.size());

            }
         return Listretern;
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
           Scripts scripts= new Scripts(event.getTitle(),event.getEnd(),"En cours","A",true,event.getEnd(),event.getUsername(),event.getStart(),event.getDateDebutScript(),event.getDatefinScript());
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
