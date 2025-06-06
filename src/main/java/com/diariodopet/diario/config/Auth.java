package com.diariodopet.diario.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.diariodopet.diario.security.UserDetailsImpl;

import java.io.IOException;

@Component
public class Auth implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(
        HttpServletRequest request,
        HttpServletResponse response,
        Authentication authentication)

        throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        String role = userDetails.getUser().getRole().name();

        if (role.equals("TUTOR")) {
            response.sendRedirect("/dashboard");
        } else if (role.equals("PETSITTER")) {
            response.sendRedirect("/dashboard");
        } else {
            response.sendRedirect("/");
        }
    }
}