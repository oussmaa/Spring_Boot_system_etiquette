package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Notification {
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Id
private Long id;
private String text;
private Date username;
private Long idevent;
private Date avatar;



public Notification(){

}



public Notification(String text ,Date username, Date avatar,Long idev) {
this.text = text;
this.username = username;
this.avatar = avatar;
this.idevent=idev;
}




public String getText() {
return text;
}



public void setText(String text) {
this.text = text;
}




public Date getUsername() {
return username;
}



public void setUsername(Date username) {
this.username = username;
}



public Date getAvatar() {
return avatar;
}}