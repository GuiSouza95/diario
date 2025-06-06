package com.diariodopet.diario.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diariodopet.diario.model.Pets;
import com.diariodopet.diario.model.Petsitters;
import com.diariodopet.diario.repository.PetsRepository;
import com.diariodopet.diario.repository.PetsitterRepository;
import com.diariodopet.diario.service.PetsitterService;

@Service
public class PetsitterServiceImpl implements PetsitterService{
    private final PetsitterRepository petsitterRepository;
    private PetsRepository petsRepository;

    @Autowired
    public PetsitterServiceImpl(PetsitterRepository petsitterRepository, PetsRepository petsRepository) {
        this.petsitterRepository = petsitterRepository;
        this.petsRepository = petsRepository;
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

    @Override
    public void addPetToPetsitter(Long petsitterId, Long petId) {
        Optional<Petsitters> petsitterOpt = petsitterRepository.findById(petsitterId);
        Optional<Pets> petOpt = petsRepository.findById(petId);

        if (petsitterOpt.isPresent() && petOpt.isPresent()) {
            Petsitters petsitter = petsitterOpt.get();
            Pets pet = petOpt.get();

            petsitter.getPets().add(pet);
            petsitterRepository.save(petsitter);
        }
    }

    @Override
    public void removePetFromPetsitter(Long petsitterId, Long petId) {
        Optional<Petsitters> petsitterOpt = petsitterRepository.findById(petsitterId);
        Optional<Pets> petOpt = petsRepository.findById(petId);

        if (petsitterOpt.isPresent() && petOpt.isPresent()) {
            Petsitters petsitter = petsitterOpt.get();
            Pets pet = petOpt.get();

            petsitter.getPets().remove(pet);
            petsitterRepository.save(petsitter);
        }
    }

    @Override
    public List<Pets> getPetsByPetsitter(Long petsitterId) {
        return petsitterRepository.findById(petsitterId)
            .map(Petsitters::getPets)
            .orElse(List.of());
    }
}
