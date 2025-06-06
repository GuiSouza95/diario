package com.diariodopet.diario.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diariodopet.diario.security.UserDetailsImpl;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    @GetMapping
    public String dashboard(Model model, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    String role = userDetails.getUser().getRole().name();
    String nome = "";

    if (role.equals("TUTOR") && userDetails.getUser().getTutor() != null) {
        nome = userDetails.getUser().getTutor().getName();
    } else if (role.equals("PETSITTER") && userDetails.getUser().getPetsitter() != null) {
        nome = userDetails.getUser().getPetsitter().getName();
    }

    model.addAttribute("role", role);
    model.addAttribute("nome", nome);

    if (role.equals("TUTOR")) {
        model.addAttribute("totalPets", 3);
        model.addAttribute("visitasSemana", 2);
        model.addAttribute("tutor", userDetails.getUser().getTutor());
        model.addAttribute("relatoriosRecentes", 5);
        model.addAttribute("fotosRecentes", List.of());
    } else if (role.equals("PETSITTER")) {
        model.addAttribute("visitasSemana", 4);
        model.addAttribute("relatoriosRecentes", 6);
        model.addAttribute("fotosRecentes", List.of());
        model.addAttribute("petsitter", userDetails.getUser().getPetsitter());
    }

    return "pages/dashboard";
    }
}
