package imis.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Echange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEchange;
    private LocalDateTime dateEchange;
    private String compteRendu;
    @ManyToOne
    private Entreprise entreprise;
    @ManyToMany
    private List<Contact> contacts;

    public int getIdEchange() {
        return idEchange;
    }

    public LocalDateTime getDateEchange() {
        return dateEchange;
    }

    public void setDateEchange(LocalDateTime dateEchange) {
        this.dateEchange = dateEchange;
    }

    public String getCompteRendu() {
        return compteRendu;
    }

    public void setCompteRendu(String compteRendu) {
        this.compteRendu = compteRendu;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
