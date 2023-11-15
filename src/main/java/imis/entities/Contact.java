package imis.entities;

import imis.dto.CreerContactDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("CONTACT")
public class Contact extends Personne {

    private String numTel;
    @ManyToOne
    private Entreprise entreprise;
    @ManyToMany
    private List<Echange> echanges;
    @ManyToOne
    private Fonction fonction;

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<Echange> getEchanges() {
        return echanges;
    }

    public void setEchanges(List<Echange> echanges) {
        this.echanges = echanges;
    }

    public Fonction getFonction() {
        return fonction;
    }

    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
    }

    public static Contact fromDTO (CreerContactDTO dto, Entreprise entreprise, Fonction fonction){
        Contact contact = new Contact();
        contact.setNom(dto.getNom());
        contact.setPrenom(dto.getPrenom());
        contact.setEmail(dto.getEmail());
        contact.setNumTel(dto.getTelephone());

        contact.setEntreprise(entreprise);
        contact.setFonction(fonction);
        return contact;
    }
}
