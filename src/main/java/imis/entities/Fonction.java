package imis.entities;

import imis.dto.CreerFonctionDTO;
import imis.dto.FonctionDTO;

import javax.persistence.*;
import java.util.List;

@Entity
public class Fonction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFonction;
    private String intituleFonction;
    @OneToMany(mappedBy = "fonction")
    private List<Contact> contacts;

    public int getIdFonction() {
        return idFonction;
    }
    public String getIntituleFonction() {
        return intituleFonction;
    }

    public void setIntituleFonction(String intituleFonction) {
        this.intituleFonction = intituleFonction;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public static Fonction fromDTO(CreerFonctionDTO dto){
        Fonction fonction = new Fonction();
        fonction.setIntituleFonction(dto.getIntitule());
        return fonction;
    }
    public static FonctionDTO toDTO(Fonction fonction){
        FonctionDTO fonctionDTO = new FonctionDTO();
        fonctionDTO.setIdFonction(fonction.getIdFonction());
        fonctionDTO.setIntituleFonction(fonction.getIntituleFonction());
        return fonctionDTO;
    }
}
