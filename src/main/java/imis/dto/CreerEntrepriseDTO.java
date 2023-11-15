package imis.dto;

import java.util.List;

public class CreerEntrepriseDTO {
    private String nom;
    private String siret;
    private String adresse;
    private List<String> motCle;
    public List<String> getMotCle() {
        return motCle;
    }
    public void setMotCle(List<String> motCle) {
        this.motCle = motCle;
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
}
