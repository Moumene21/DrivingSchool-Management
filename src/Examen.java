public class Examen {
    private int id;
    private String typeExamen;
    private String dateExamen;
    private String heure;

    public Examen(int id, String typeExamen, String dateExamen, String heure) {
        this.id = id;
        this.typeExamen = typeExamen;
        this.dateExamen = dateExamen;
        this.heure = heure;
    }

    public int getId() {
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
}
