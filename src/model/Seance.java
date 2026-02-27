package model;

public class Seance {
    private int id;
    private String candidat;
    private String moniteur;
    private String date;
    private String heure;
    private String vehicule;

    // Constructeur
    public Seance(int id, String candidat, String moniteur, String date, String heure, String vehicule) {
        this.id = id;
        this.candidat = candidat;
        this.moniteur = moniteur;
        this.date = date;
        this.heure = heure;
        this.vehicule = vehicule;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCandidat() {
        return candidat;
    }

    public void setCandidat(String candidat) {
        this.candidat = candidat;
    }

    public String getMoniteur() {
        return moniteur;
    }

    public void setMoniteur(String moniteur) {
        this.moniteur = moniteur;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getVehicule() {
        return vehicule;
    }

    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public String toString() {
        return "Séance ID: " + id + ", Candidat: " + candidat + ", Moniteur: " + moniteur +
               ", Date: " + date + ", Heure: " + heure + ", Véhicule: " + vehicule;
    }
}