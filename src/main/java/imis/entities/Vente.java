package imis.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVente;
    private LocalDateTime dateVente;
    private float montant;
    private String nature;
    @ManyToOne
    private Entreprise entreprise;

    public int getIdVente() {
        return idVente;
    }

    public LocalDateTime getDateVente() {
        return dateVente;
    }

    public void setDateVente(LocalDateTime dateVente) {
        this.dateVente = dateVente;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}
