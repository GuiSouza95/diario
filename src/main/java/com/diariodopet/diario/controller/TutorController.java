package com.diariodopet.diario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diariodopet.diario.DTO.PetsDTO;
import com.diariodopet.diario.service.PetsService;

@Controller
@RequestMapping("/tutor")
public class TutorController {
    private final PetsService petsService;

    public TutorController(PetsService petsService) {
        this.petsService = petsService;
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
    public String registerPet(@PathVariable Long id,
                              @ModelAttribute("petDTO") PetsDTO petDTO,
                              RedirectAttributes redirectAttributes) {
        petDTO.setTutorId(id);
        petsService.createPet(petDTO);

        redirectAttributes.addFlashAttribute("mensagem", "Pet cadastrado com sucesso!");

        return "redirect:/tutor/" + id + "/pets/new";
    }
}