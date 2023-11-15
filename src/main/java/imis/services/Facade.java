package imis.services;

import imis.dto.*;
import imis.entities.Contact;
import imis.entities.Entreprise;
import imis.entities.Fonction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Facade {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void creeEntreprise(CreerEntrepriseDTO dto) {
        em.persist(Entreprise.fromDTO(dto));
    }

    @Transactional
    public void creeFonction(CreerFonctionDTO dto) {
        em.persist(Fonction.fromDTO(dto));
    }

    @Transactional
    public void creeContact(CreerContactDTO dto){
        Entreprise e  = em.find(Entreprise.class, dto.getEntreprise());

        Fonction f = em.find(Fonction.class, dto.getFonction());

        em.persist(Contact.fromDTO(dto, e,f));
    }

    public List<EntrepriseDTO> getEntreprise() {
        Query query = em.createQuery("SELECT e from Entreprise e");
        List<Entreprise> entreprises = query.getResultList();
        return entreprises.stream().map(Entreprise::toDTO).collect(Collectors.toList());
    }

    public List<FonctionDTO> getFonction() {
        Query query = em.createQuery("select f from Fonction f");
        List<Fonction> fonctions = query.getResultList();
        return fonctions.stream().map(Fonction::toDTO).collect(Collectors.toList());
    }

    public List<EntrepriseDTO> getEntreprisePlusContact() {
        Query query = em.createQuery("select e from  Entreprise e left join e.contacts c GROUP BY c order by count(c) DESC ").setMaxResults(1);
        List<Entreprise> entreprises = query.getResultList();
        return entreprises.stream().map(Entreprise::toDTO).collect(Collectors.toList());
    }

    public Object getEntrepriseParMotCles(String motcle) {
        Query query = em.createQuery("select e from Entreprise e where UPPER(:motcle) member of e.motcles", Entreprise.class).setParameter("motcle", motcle);
        List<Entreprise> entreprises = query.getResultList();
        return entreprises.stream().map(Entreprise::toDTO).collect(Collectors.toList());
    }
}
