package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.Entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Notification;
import com.example.demo.Repository.NotificationRepository;



    @CrossOrigin(origins = "*", maxAge = 3600)
	@RestController
    @RequestMapping("/api")
	public class NotificationRestController { @Autowired NotificationRepository notifRepo;
	@PostMapping("/addNotification")
	public Notification addNotification(@RequestBody Notification notification){
	return notifRepo.save(notification);
	}
	@GetMapping("/LastNotifications")
	public List<Notification> getLast5Notifications() {



		return notifRepo.findAll();



	}
	}