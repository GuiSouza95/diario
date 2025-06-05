package com.diariodopet.diario.service;

import com.diariodopet.diario.model.InformationTutorPets;

import java.util.List;
import java.util.Optional;

public interface InfoPetsService {
    InformationTutorPets saveInfo(InformationTutorPets infoPets);
    Optional<InformationTutorPets> getInfoById(Long id);
    List<InformationTutorPets> getAllInfo();
    void deleteInfo(Long id);
}
