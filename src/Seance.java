public class Seance{

    private int id;                // Identifiant unique de la séance
    private String candidat;       // Nom du candidat
    private String moniteur;       // Nom du moniteur
    private String vehicule;       // Nom ou plaque du véhicule
    private String heure;          // Heure de la séance (format HH:mm)
    private String date;           // Date de la séance (format yyyy-MM-dd)

    // Constructeur
    public Seance(int id, String candidat, String moniteur, String vehicule, String heure, String date) {
        this.id = id;
        this.candidat = candidat;
        this.moniteur = moniteur;
        this.vehicule = vehicule;
        this.heure = heure;
        this.date = date;
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

    public String getVehicule() {
        return vehicule;
    }

    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // Méthode pour afficher les informations de la séance (facultatif)
    @Override
    public String toString() {
        return "Seance{" +
                "id=" + id +
                ", candidat='" + candidat + '\'' +
                ", moniteur='" + moniteur + '\'' +
                ", vehicule='" + vehicule + '\'' +
                ", heure='" + heure + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

