package com.diariodopet.diario.service;

import java.util.List;

import com.diariodopet.diario.DTO.PetsDTO;
import com.diariodopet.diario.model.Pets;

public interface PetsService {
    Pets createPet(PetsDTO petDTO);
    List<Pets> getPetsByTutorId(Long tutorId);

    Pets getPetById(Long petId);
    Pets updatePet(PetsDTO petDTO);
    void deletePetById(Long petId);
    List<Pets> getAllPets();
}
