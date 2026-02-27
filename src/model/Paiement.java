package model;

public class Paiement {
    private int id;
    private String nom;
    private String date;
    private double montant;
    private double reste;
    private int tranche; // Nouvelle colonne

    public Paiement(int id, String nom, String date, double montant, double reste, int tranche) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.montant = montant;
        this.reste = reste;
        this.tranche = tranche;
    }

    // Getters et Setters pour tranche
    public double getTranche() {
        return tranche;
    }

    public void setTranche(double tranche) {
        this.tranche = (int) tranche;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getRest() {
        return reste;
    }

    public void setRest(double rest) {
        this.reste= reste;
    }
}
