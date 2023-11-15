package imis.dto;

import imis.entities.Echange;
import imis.entities.Entreprise;
import imis.entities.Fonction;

public class CreerContactDTO {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private int entreprise;
    private int fonction;
    private int echange;
    public int getEchange() {
        return echange;
    }

    public void setEchange(int echange) {
        this.echange = echange;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(int entreprise) {
        this.entreprise = entreprise;
    }

    public int getFonction() {
        return fonction;
    }

    public void setFonction(int fonction) {
        this.fonction = fonction;
    }
}
