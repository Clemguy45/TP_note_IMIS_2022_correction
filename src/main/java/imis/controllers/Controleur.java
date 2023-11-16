package imis.controllers;

import imis.dto.CreerContactDTO;
import imis.dto.CreerEntrepriseDTO;
import imis.dto.CreerFonctionDTO;
import imis.entities.Contact;
import imis.entities.Entreprise;
import imis.entities.Fonction;
import imis.exception.CreerContactParamException;
import imis.exception.EntrepriseNotFoundException;
import imis.exception.FonctionNotFindException;
import imis.services.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("")
public class Controleur {
    @Autowired
    Facade facade;

    @RequestMapping("")
    public String root(){
        return "hello";
    }

    @GetMapping("createEntreprise")
    public String createEntrepriseGet(){
        return "createEntreprise";
    }

    @PostMapping("createEntreprise")
    public String createEntreprisePost(CreerEntrepriseDTO dto, Model model) {
        facade.creeEntreprise(dto);
        model.addAttribute("search", dto.getNom());
        return "hello";
    }

    @GetMapping("createFonction")
    public String createFonctionGet(){
        return "createFonction";
    }

    @PostMapping("createFonction")
    public String createFonctionPost(Model model, CreerFonctionDTO dto){
        // TODO ajouter les paramètres de la méthode
        // TODO créer la méthode dans la facade
        facade.creeFonction(dto);
        model.addAttribute("search",dto.getIntitule());
        return "hello";
    }

    @GetMapping("createContact")
    public String createContactGet(Model model){
        // TODO aller chercher la liste des entreprises et des fonctions dans la facade
        // TODO les ajouter dans le modèle
        model.addAttribute("entreprises", facade.getEntreprise());
        model.addAttribute("fonctions", facade.getFonction());
        return "createContact";
    }

    @PostMapping("createContact")
    public String createContactPost(CreerContactDTO dto, Model model) {
        // TODO ajouter les paramètres de la méthode
        // TODO créer la méthode dans la facade
        facade.creeContact(dto);
        model.addAttribute("search",dto.getNom());
        return "hello";
    }

    @GetMapping("plusContact")
    public String plusContact(Model model){
        // TODO devinez...
        model.addAttribute("entreprise", facade.getEntreprisePlusContact());
        return "plusContact";
    }

    @PostMapping("parMotCle")
    public String parMotCle(@RequestParam String motcle,Model model){
        // TODO devinez...
        model.addAttribute("motcle", motcle);
        model.addAttribute("entreprises", facade.getEntrepriseParMotCles(motcle));
        return "entreprises";
    }
}
