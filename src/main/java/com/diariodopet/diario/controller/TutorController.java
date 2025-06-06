package com.diariodopet.diario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diariodopet.diario.DTO.PetsDTO;
import com.diariodopet.diario.model.Pets;
import com.diariodopet.diario.model.Tutores;
import com.diariodopet.diario.service.PetsService;
import com.diariodopet.diario.service.TutorService;

@Controller
@RequestMapping("/tutor")
public class TutorController {
    private final PetsService petsService;
    private final TutorService tutorService;

    public TutorController(PetsService petsService, TutorService tutorService) {
        this.petsService = petsService;
        this.tutorService = tutorService;
    }

    @GetMapping("/{id}/pets/new")
    public String showAddPetForm(@PathVariable Long id, Model model) {
        PetsDTO petDTO = new PetsDTO();
        petDTO.setTutorId(id);

        model.addAttribute("petDTO", petDTO);
        model.addAttribute("pageTitle", "Cadastrar Pet");

        return "pages/forms/register-pet";
    }

    @PostMapping("/{id}/pets/new")
    public String registerPet(@PathVariable Long id, @ModelAttribute("petDTO") PetsDTO petDTO, RedirectAttributes redirectAttributes) {
        petDTO.setTutorId(id);
        petsService.createPet(petDTO);

        redirectAttributes.addFlashAttribute("mensagem", "Pet cadastrado com sucesso!");

        return "redirect:/tutor/" + id + "/pets/new";
    }

    @GetMapping("/{id}/pets")
    public String listarPets(@PathVariable Long id, Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String email = auth.getName();
    Optional<Tutores> tutorOpt = tutorService.getTutorByEmail(email);

    if (tutorOpt.isEmpty()) {
        return "redirect:/login?error=usuario_nao_encontrado";
    }

    Tutores tutor = tutorOpt.get();

    if (tutor.getId().equals(id)) {
        List<Pets> pets = petsService.getPetsByTutorId(tutor.getId());
        model.addAttribute("pets", pets);
        model.addAttribute("tutor", tutor);
        model.addAttribute("pageTitle", "Meus Pets");
        model.addAttribute("role", "TUTOR");
    } else {
        return "redirect:/login?error=acesso_negado";
    }

    return "pages/petsList";
    }

    @GetMapping("/{id}/pets/{petId}/edit")
    public String showEditPetForm(@PathVariable Long id, @PathVariable Long petId, Model model) {
        Pets pet = petsService.getPetById(petId);
        if (pet == null) {
            return "redirect:/tutor/" + id + "/pets?error=pet_nao_encontrado";
        }
        
        PetsDTO petDTO = new PetsDTO();
        petDTO.setId(pet.getId());
        petDTO.setName(pet.getName());
        petDTO.setSpecie(pet.getSpecie());
        petDTO.setAge(pet.getAge());
        petDTO.setSize(pet.getSize());
        petDTO.setTutorId(id);
        
        model.addAttribute("petDTO", petDTO);
        model.addAttribute("pageTitle", "Editar Pet");
        
        return "pages/petEdit";
    }

    @PostMapping("/{id}/pets/{petId}/edit")
    public String editPet(@PathVariable Long id, @PathVariable Long petId, @ModelAttribute("petDTO") PetsDTO petDTO, RedirectAttributes redirectAttributes) {
        petDTO.setId(petId);
        petDTO.setTutorId(id);
        petsService.updatePet(petDTO);

        redirectAttributes.addFlashAttribute("mensagem", "Pet atualizado com sucesso!");

        return "redirect:/tutor/" + id + "/pets";
    }

    @PostMapping("/{id}/pets/{petId}/delete")
    public String deletePet(@PathVariable Long id, @PathVariable Long petId, RedirectAttributes redirectAttributes) {
        petsService.deletePetById(petId);
        redirectAttributes.addFlashAttribute("mensagem", "Pet excluído com sucesso!");
        return "redirect:/tutor/" + id + "/pets";
    }
}