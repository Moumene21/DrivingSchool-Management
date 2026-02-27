package model;

public class Vehicule {
    private int id;
    private String marque;
    private String type;

    public Vehicule(int id, String marque, String type) {
        this.id = id;
        this.marque = marque;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
