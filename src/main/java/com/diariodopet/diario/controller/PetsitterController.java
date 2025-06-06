package com.diariodopet.diario.controller;

import java.io.File;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.diariodopet.diario.DTO.VisitsDTO;
import com.diariodopet.diario.model.Pets;
import com.diariodopet.diario.model.Petsitters;
import com.diariodopet.diario.model.Photos;
import com.diariodopet.diario.model.Visits;
import com.diariodopet.diario.service.PetsService;
import com.diariodopet.diario.service.PetsitterService;
import com.diariodopet.diario.service.PhotosService;
import com.diariodopet.diario.service.VisitsService;

@Controller
@RequestMapping("/petsitter")
public class PetsitterController {

    private final PetsitterService petsitterService;
    private final PetsService petsService;
    private final VisitsService visitsService;
    private final PhotosService photoService;

    public PetsitterController(PetsitterService petsitterService, PetsService petsService, VisitsService visitsService, PhotosService photoService) {
        this.petsitterService = petsitterService;
        this.petsService = petsService;
        this.visitsService = visitsService;
        this.photoService = photoService;
    }

    @GetMapping("/{id}/dashboard")
    public String showDashboard(@PathVariable Long id, Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        Optional<Petsitters> petsitterOpt = petsitterService.getPetsitterByEmail(email);
        if (petsitterOpt.isEmpty()) {
            return "redirect:/login?error=usuario_nao_encontrado";
        }

        Petsitters petsitter = petsitterOpt.get();

        if (!petsitter.getId().equals(id)) {
            return "redirect:/access-denied";
        }

        model.addAttribute("petsitter", petsitter);
        model.addAttribute("pageTitle", "Dashboard Petsitter");
        model.addAttribute("role", "PETSITTER");
        List<Pets> meusPets = petsitter.getPets();
        model.addAttribute("pets", meusPets);

        return "pages/dashboard";
    }

    // Visits
    @GetMapping("/{id}/relatorios")
    public String listarRelatorios(@PathVariable Long id, @RequestParam(value = "date", required = false) String date, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        Optional<Petsitters> petsitterOpt = petsitterService.getPetsitterByEmail(email);
        if (petsitterOpt.isEmpty() || !petsitterOpt.get().getId().equals(id)) {
            return "redirect:/access-denied";
        }

        List<VisitsDTO> visitas;

        if (date != null && !date.isEmpty()) {
            visitas = visitsService.convertToDTOList(visitsService.getVisitsByDate(date));
        } else {
            visitas = visitsService.convertToDTOList(visitsService.getAllVisits());
        }

        model.addAttribute("visitas", visitas);
        model.addAttribute("petsitter", petsitterOpt.get());
        model.addAttribute("role", "PETSITTER");

        return "pages/relatorios";
    }

    @PostMapping("/{id}/adicionar-visita")
    public String salvarVisita(@PathVariable Long id, @ModelAttribute Visits novaVisita, @RequestParam("fotos") MultipartFile[] fotos) throws IOException {
    novaVisita = visitsService.saveVisit(novaVisita);

    String uploadDir = "/savePhotos/";
    File uploadDirFile = new File(uploadDir);
    if (!uploadDirFile.exists()) {
        uploadDirFile.mkdir();
    }

    for (MultipartFile foto : fotos) {
        if (foto.getContentType() == null || !foto.getContentType().startsWith("image")) {
        return "redirect:/petsitter/{id}/dashboard?error=arquivo_invalido";
    }

    String fileName = foto.getOriginalFilename();
    if (!fileName.toLowerCase().endsWith(".jpg") && !fileName.toLowerCase().endsWith(".jpeg") && !fileName.toLowerCase().endsWith(".png")) {
        return "redirect:/petsitter/{id}/dashboard?error=extensao_invalida";
    }

    String fileNameToSave = System.currentTimeMillis() + "_" + fileName;
    File file = new File(uploadDir + fileNameToSave);
    foto.transferTo(file);

    Photos newPhoto = Photos.builder()
            .urlPhotos(file.getAbsolutePath())
            .visit(novaVisita)
            .build();
    photoService.savePhoto(newPhoto);
    }

    return "redirect:/petsitter/{id}/dashboard";
    }
    // Pets

    @GetMapping("/{id}/pets")
    public String listarPets(@PathVariable Long id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        Optional<Petsitters> petsitterOpt = petsitterService.getPetsitterByEmail(email);
        if (petsitterOpt.isEmpty() || !petsitterOpt.get().getId().equals(id)) {
            return "redirect:/access-denied";
        }

        Petsitters petsitter = petsitterOpt.get();

        model.addAttribute("petsitter", petsitter);
        model.addAttribute("role", "PETSITTER");
        model.addAttribute("petsitterPets", petsitter.getPets());

        return "pages/petsList";
    }

    @GetMapping("/{id}/selecionar-pets")
    public String selecionarPets(@PathVariable Long id, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        Optional<Petsitters> petsitterOpt = petsitterService.getPetsitterByEmail(email);
        if (petsitterOpt.isEmpty() || !petsitterOpt.get().getId().equals(id)) {
            return "redirect:/access-denied";
        }

        List<Pets> allPets = petsService.getAllPets();
        model.addAttribute("pets", allPets);
        model.addAttribute("petsitterId", id);
        return "pages/petsitterSelecPets";
    }

    @PostMapping("/{petsitterId}/adicionar-pet/{petId}")
    public String adicionarPetAoPetsitter(@PathVariable Long petsitterId, @PathVariable Long petId) {
        petsitterService.addPetToPetsitter(petsitterId, petId);
        return "redirect:/petsitter/" + petsitterId + "/dashboard";
    }

    @PostMapping("/{petsitterId}/pets/{petId}/delete")
    public String deletarPetDoPetsitter(@PathVariable Long petsitterId, @PathVariable Long petId) {
        petsitterService.removePetFromPetsitter(petsitterId, petId);
        return "redirect:/petsitter/" + petsitterId + "/dashboard";
    }

    // Reports
    
}