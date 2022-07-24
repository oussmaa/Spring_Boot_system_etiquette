package com.example.demo.Entity;

import javax.persistence.*;
import java.nio.file.SecureDirectoryStream;
import java.util.Date;

@Entity
@Table(name="Problem")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name="TEXT", length=512)
    private String text;

    private String object;
    private String usernameuser;
    private String version;
private Date date;

    public Problem(String text, String object, String usernameuser, String version, Date date) {
        this.text = text;
        this.object = object;
        this.usernameuser = usernameuser;
        this.version = version;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Problem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String getUsernameuser() {
        return usernameuser;
    }

    public void setUsernameuser(String usernameuser) {
        this.usernameuser = usernameuser;
    }
}
