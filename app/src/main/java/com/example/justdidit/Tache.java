package com.example.justdidit;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Tache {
    private String title;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Boolean retard;
    private int nombreJourRestant;
    private long nbJourRetard;

    public Tache(String title, String description, Date dateDeDebut, Date dateFin) {
        this.title = title;
        this.description = description;
        this.dateDebut = dateDeDebut;
        this.dateFin = dateFin;
        this.retard = false;

        long diffInMillis = Math.abs(dateFin.getTime() - dateDebut.getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        this.nbJourRetard = diffInDays;
        this.nombreJourRestant = (int) diffInDays;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateDeDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public Boolean getRetard() {
        return retard;
    }

    public long getNbJourRetard() {
        return nbJourRetard;
    }

    public int getNombreJourRestant() {return  nombreJourRestant; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateDeDebut(Date dateDeDebut) {
        this.dateDebut = dateDeDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setRetard(Boolean retard) {
        this.retard = retard;
    }

    public void setNbJourRetard(int nbJourReatrd) {
        this.nbJourRetard = nbJourReatrd;
    }
}
