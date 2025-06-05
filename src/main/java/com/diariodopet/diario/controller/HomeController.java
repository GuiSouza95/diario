package com.diariodopet.diario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pageTitle", "Diário do Pet - Home");

        return "index";
    }

    @GetMapping("/about-us")
    public String aboutUs(Model model) {
        model.addAttribute("pageTitle", "Diário do Pet - Sobre nós");

        return "pages/aboutUs";
    }
    
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("pageTitle", "Diário do Pet - Login");

        return "pages/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("pageTitle", "Diário do Pet - Registro");

        return "pages/register";
    }

    @GetMapping("/contacts")
    public String contacts(Model model) {
        model.addAttribute("pageTitle", "Diário do Pet - Contatos");

        return "pages/contacts";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("pageTitle", "Diário do Pet - Dashboard");

        return "pages/dashboard";
    }
}
