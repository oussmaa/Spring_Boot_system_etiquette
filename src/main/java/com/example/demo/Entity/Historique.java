package com.example.demo.Entity;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="Historique")
public class Historique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String version;
    private Boolean Tested;
    private Date Generated;
    private String username;
    public Boolean getTested() {
        return Tested;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTested(Boolean tested) {
        Tested = tested;
    }

    public Date getGenerated() {
        return Generated;
    }

    public void setGenerated(Date generated) {
        Generated = generated;
    }

    public String Bloc;

    public String getBloc() {
        return Bloc;
    }

    public void setBloc(String bloc) {
        Bloc = bloc;
    }

    private Date date_livraison;
    private String Etat;

    public Historique(String version, Date date_livraison, String etat, String bloc,Boolean tested,Date generated,String username) {
        super();
        this.version = version;
        this.date_livraison = date_livraison;
        this.Etat = etat;
        this.Bloc=bloc;
        this.Tested=tested;
        this.Generated=generated;
        this.username=username;
    }

    public Historique() {

    }

    public String getEtat() {
        return Etat;
    }

    public void setEtat(String etat) {
        Etat = etat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getDate_livraison() {
        return date_livraison;
    }

    public void setDate_livraison(Date date_livraison) {
        this.date_livraison = date_livraison;
    }
}

