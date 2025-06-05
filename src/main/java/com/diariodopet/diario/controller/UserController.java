package com.diariodopet.diario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.diariodopet.diario.DTO.PetsitterDTO;
import com.diariodopet.diario.DTO.TutorDTO;
import com.diariodopet.diario.DTO.UserDTO;
import com.diariodopet.diario.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        UserDTO userDTO = new UserDTO();
        userDTO.setTutor(new TutorDTO());
        userDTO.setPetsitter(new PetsitterDTO());
        
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("pageTitle", "Diário do Pet - Registro");

        return"pages/register";
    }
    
    @PostMapping("/register")
    public String register(@ModelAttribute("userDTO") UserDTO userDTO) {
        userService.createUser(userDTO);
        
        return "redirect:/login";
    }
}