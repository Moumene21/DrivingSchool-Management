package model;

import javafx.beans.property.*;

public class Historique_de_paiement {
    private IntegerProperty id;
    private StringProperty candidat;
    private DoubleProperty montantTotal;
    private DoubleProperty montantPaye;
    private DoubleProperty montantRestant;
    private StringProperty datePaiement;
    private IntegerProperty numeroTranche;
    private StringProperty statutPaiement;

    public Historique_de_paiement() {
        this.id = new SimpleIntegerProperty();
        this.candidat = new SimpleStringProperty();
        this.montantTotal = new SimpleDoubleProperty();
        this.montantPaye = new SimpleDoubleProperty();
        this.montantRestant = new SimpleDoubleProperty();
        this.datePaiement = new SimpleStringProperty();
        this.numeroTranche = new SimpleIntegerProperty();
        this.statutPaiement = new SimpleStringProperty();
    }

    // Getters et Setters pour id
    public int getId() { return id.get(); }
    public void setId(int id) { this.id.set(id); }
    public IntegerProperty idProperty() { return id; }

    // Getters et Setters pour candidat
    public String getCandidat() { return candidat.get(); }
    public void setCandidat(String candidat) { this.candidat.set(candidat); }
    public StringProperty candidatProperty() { return candidat; }

    // Getters et Setters pour montantTotal
    public double getMontantTotal() { return montantTotal.get(); }
    public void setMontantTotal(double montantTotal) { this.montantTotal.set(montantTotal); }
    public DoubleProperty montantTotalProperty() { return montantTotal; }

    // Getters et Setters pour montantPaye
    public double getMontantPaye() { return montantPaye.get(); }
    public void setMontantPaye(double montantPaye) { this.montantPaye.set(montantPaye); }
    public DoubleProperty montantPayeProperty() { return montantPaye; }

    // Getters et Setters pour montantRestant
    public double getMontantRestant() { return montantRestant.get(); }
    public void setMontantRestant(double montantRestant) { this.montantRestant.set(montantRestant); }
    public DoubleProperty montantRestantProperty() { return montantRestant; }

    // Getters et Setters pour datePaiement
    public String getDatePaiement() { return datePaiement.get(); }
    public void setDatePaiement(String datePaiement) { this.datePaiement.set(datePaiement); }
    public StringProperty datePaiementProperty() { return datePaiement; }

    // Getters et Setters pour numeroTranche
    public int getNumeroTranche() { return numeroTranche.get(); }
    public void setNumeroTranche(int numeroTranche) { this.numeroTranche.set(numeroTranche); }
    public IntegerProperty numeroTrancheProperty() { return numeroTranche; }

    // Getters et Setters pour statutPaiement
    public String getStatutPaiement() { return statutPaiement.get(); }
    public void setStatutPaiement(String statutPaiement) { this.statutPaiement.set(statutPaiement); }
    public StringProperty statutPaiementProperty() { return statutPaiement; }
}