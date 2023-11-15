package imis.entities;

import javax.persistence.*;

@Entity
public class ServiceInterne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServiceInterne;

    private String nomSI;
    @ManyToOne
    private Employe employe;

    public Long getIdServiceInterne() {
        return idServiceInterne;
    }

    public String getNomSI() {
        return nomSI;
    }

    public void setNomSI(String nomSI) {
        this.nomSI = nomSI;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
