package com.diariodopet.diario.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diariodopet.diario.model.Petsitters;
import com.diariodopet.diario.repository.PetsitterRepository;
import com.diariodopet.diario.service.PetsitterService;

@Service
public class PetsitterServiceImpl implements PetsitterService{
    private final PetsitterRepository petsitterRepository;

    @Autowired
    public PetsitterServiceImpl(PetsitterRepository petsitterRepository) {
        this.petsitterRepository = petsitterRepository;
    }

    @Override
    public Petsitters savePetsitter(Petsitters petsitter) {
        return petsitterRepository.save(petsitter);
    }

    @Override
    public List<Petsitters> getAllPetsitters() {
        return petsitterRepository.findAll();
    }

    @Override
    public Optional<Petsitters> getPetsitterById(Long id) {
        return petsitterRepository.findById(id);
    }

    @Override
    public Optional<Petsitters> getPetsitterByEmail(String email) {
        return petsitterRepository.findByEmail(email);
    }

    @Override
    public void deletePetsitter(Long id) {
        petsitterRepository.deleteById(id);
    }
}
