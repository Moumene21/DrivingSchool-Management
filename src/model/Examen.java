package model ;
public class Examen {
    private Integer id;
    private String typeExamen;
    private String dateExamen;
    private String heure;

    // Constructeur
    public Examen(Integer id, String typeExamen, String dateExamen, String heure) {
        this.id = id;
        this.typeExamen = typeExamen;
        this.dateExamen = dateExamen;
        this.heure = heure;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getTypeExamen() {
        return typeExamen;
    }

    public String getDateExamen() {
        return dateExamen;
    }

    public String getHeure() {
        return heure;
    }

    // Setters
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTypeExamen(String typeExamen) {
        this.typeExamen = typeExamen;
    }

    public void setDateExamen(String dateExamen) {
        this.dateExamen = dateExamen;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    // Constructeur par défaut (nécessaire pour JavaFX)
    public Examen() {
    }
}