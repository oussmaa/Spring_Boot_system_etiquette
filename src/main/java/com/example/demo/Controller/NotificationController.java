package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.demo.Entity.Notification;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class NotificationController {
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	@Autowired
	private NotificationRestController notifController;

	@MessageMapping("/sendmsges")
	public void notif ( @Payload String username) throws Exception {
	Thread.sleep(1000); // simulated delay
	String message = "Hello from " ;
	messagingTemplate.convertAndSend("/queue/reply", message);
	Notification notif= new Notification();
	//notif.setUsername(username);
	notifController.addNotification(notif);



	}
}
