package imis.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PERSONNE", discriminatorType = DiscriminatorType.STRING)
public abstract class Personne {
    private String nom;
    private String prenom;
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    public int getId() {
        return id;
    }
}
