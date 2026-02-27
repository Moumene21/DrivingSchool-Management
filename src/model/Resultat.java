package model ;
public class Resultat {
    private Integer id;
    private String nomCandidat;
    private String nomExamen;
    private String resultat;

    public Resultat(Integer id, String nomCandidat, String nomExamen, String resultat) {
        this.id = id;
        this.nomCandidat = nomCandidat;
        this.nomExamen = nomExamen;
        this.resultat = resultat;
    }

    public Integer getId() {
        return id;
    }

    public String getNomCandidat() {
        return nomCandidat;
    }

    public String getNomExamen() {
        return nomExamen;
    }

    public String getResultat() {
        return resultat;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNomCandidat(String nomCandidat) {
        this.nomCandidat = nomCandidat;
    }

    public void setNomExamen(String nomExamen) {
        this.nomExamen = nomExamen;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
}
