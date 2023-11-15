package imis.dto;


import java.util.List;

public class EntrepriseDTO {
    private String nom;
    private String siret;
    private String adresse;
    private int id;
    private List<String> motCles;
    public List<String> getMotcles() {
        return motCles;
    }
    public void setMotcles(List<String> motcles) {
        this.motCles = motcles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
