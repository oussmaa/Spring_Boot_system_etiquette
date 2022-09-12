package com.example.demo.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Event")
public class Event {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date start;
    public  Date end;
    public  Date Genrate;
    private String title;
    private String color;

    public Date getDateDebutScript() {
        return dateDebutScript;
    }

    public void setDateDebutScript(Date dateDebutScript) {
        this.dateDebutScript = dateDebutScript;
    }

    public Date getDatefinScript() {
        return datefinScript;
    }

    public void setDatefinScript(Date datefinScript) {
        this.datefinScript = datefinScript;
    }

    private Date dateDebutScript;
    private Date datefinScript;
    public Date getGenrate() {
        return Genrate;
    }

    public void setGenrate(Date genrate) {
        Genrate = genrate;
    }

    private String username;
    public Event(String title ,Date start, Date end, String color, String username,Date dateDebutScript,Date datefinScript,Date genrate) {

        this.start = start;
        this.end = end;
        this.color = color;
        this.title=title;
        this.username=username;
        this.Genrate=genrate;
        this.datefinScript=datefinScript;
        this.dateDebutScript=dateDebutScript;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Event() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
