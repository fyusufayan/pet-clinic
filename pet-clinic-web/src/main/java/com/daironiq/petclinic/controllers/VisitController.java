package com.daironiq.petclinic.controllers;

import com.daironiq.petclinic.model.Pet;
import com.daironiq.petclinic.model.Visit;
import com.daironiq.petclinic.services.PetService;
import com.daironiq.petclinic.services.VisitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId") Long petId, Model model){
        Pet pet=petService.findById(petId);
        model.addAttribute("pet",pet);
        Visit visit=new Visit();
        pet.getVisits().add(visit);
        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable("petId") Long petId,Model model){
        return "pets/createOrUpdateVisitForm";
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(@Valid Visit visit, BindingResult result){
        if (result.hasErrors()){
            return "pets/createOrUpdateVisitForm";
        }else {
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }

}
