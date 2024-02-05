package com.example.justdidit;

import java.util.Date;

public class Tache {
    private String title;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private Boolean retard;

    private int nbJourReatrd;

    public Tache(String title, String description, Date dateDeDebut, Date dateFin) {
        this.title = title;
        this.description = description;
        this.dateDebut = dateDeDebut;
        this.dateFin = dateFin;
        this.retard = false;
        this.nbJourReatrd = Integer.parseInt(dateDebut.toString()) - Integer.parseInt(this.dateFin.toString());
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

    public int getNbJourReatrd() {
        return nbJourReatrd;
    }

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

    public void setNbJourReatrd(int nbJourReatrd) {
        this.nbJourReatrd = nbJourReatrd;
    }
}
