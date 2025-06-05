package com.diariodopet.diario.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diariodopet.diario.model.InformationTutorPets;
import com.diariodopet.diario.repository.InfoPetsRepository;
import com.diariodopet.diario.service.InfoPetsService;

@Service
public class InfoPetsServiceImpl implements InfoPetsService {

    @Autowired
    private InfoPetsRepository infoPetsRepository;

    @Override
    public InformationTutorPets saveInfo(InformationTutorPets infoPets) {
        return infoPetsRepository.save(infoPets);
    }

    @Override
    public Optional<InformationTutorPets> getInfoById(Long id) {
        return infoPetsRepository.findById(id);
    }

    @Override
    public List<InformationTutorPets> getAllInfo() {
        return infoPetsRepository.findAll();
    }

    @Override
    public void deleteInfo(Long id) {
        infoPetsRepository.deleteById(id);
    }
}
