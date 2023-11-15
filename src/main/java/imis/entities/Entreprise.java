package imis.entities;

import imis.dto.CreerEntrepriseDTO;
import imis.dto.EntrepriseDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String siret;
    private String adresse;
    @OneToMany(mappedBy = "entreprise")
    private List<Vente> ventes;
    @OneToMany(mappedBy = "entreprise")
    private List<Contact> contacts;
    @OneToMany(mappedBy = "entreprise")
    private List<Echange> echanges;
    @ElementCollection
    private List<String> motcles;

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

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<Vente> getVentes() {
        return ventes;
    }

    public void setVentes(List<Vente> ventes) {
        this.ventes = ventes;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public List<Echange> getEchanges() {
        return echanges;
    }

    public void setEchanges(List<Echange> echanges) {
        this.echanges = echanges;
    }

    public List<String> getMotcles() {
        return motcles;
    }

    public void setMotcles(List<String> motcles) {
        this.motcles = motcles;
    }
    public static Entreprise fromDTO(CreerEntrepriseDTO dto){
        Entreprise entreprise = new Entreprise();
        entreprise.setNom(dto.getNom());
        entreprise.setSiret(dto.getSiret());
        entreprise.setAdresse(dto.getAdresse());
        entreprise.setMotcles(dto.getMotCle());
        return entreprise;
    }

    public static EntrepriseDTO toDTO(Entreprise entreprise){
        EntrepriseDTO entrepriseDTO = new EntrepriseDTO();
        entrepriseDTO.setId(entreprise.getId());
        entrepriseDTO.setSiret(entreprise.getSiret());
        entrepriseDTO.setNom(entreprise.getNom());
        entrepriseDTO.setAdresse(entreprise.getAdresse());
        entrepriseDTO.setMotcles(entreprise.getMotcles());
        return entrepriseDTO;
    }
}
