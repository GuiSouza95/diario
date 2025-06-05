package com.diariodopet.diario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.diariodopet.diario.model.Petsitters;

@Service
public interface PetsitterService {
    Petsitters savePetsitter(Petsitters petsitter);
    List<Petsitters> getAllPetsitters();
    Optional<Petsitters> getPetsitterById(Long id);
    Optional<Petsitters> getPetsitterByEmail(String email);
    void deletePetsitter(Long id);
}
