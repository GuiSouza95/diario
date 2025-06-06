package com.diariodopet.diario.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diariodopet.diario.DTO.PetsDTO;
import com.diariodopet.diario.model.Pets;
import com.diariodopet.diario.model.Tutores;
import com.diariodopet.diario.repository.PetsRepository;
import com.diariodopet.diario.repository.TutorRepository;
import com.diariodopet.diario.service.PetsService;

@Service
public class PetsServiceImpl implements PetsService{

    @Autowired
    private PetsRepository petsRepository;

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public Pets createPet(PetsDTO petDTO) {
        Tutores tutor = tutorRepository.findById(petDTO.getTutorId())
            .orElseThrow(() -> new RuntimeException("Tutor não encontrado"));

        Pets pet = Pets.builder()
            .name(petDTO.getName())
            .specie(petDTO.getSpecie())
            .age(petDTO.getAge())
            .size(petDTO.getSize())
            .tutor(tutor)
            .build();

        return petsRepository.save(pet);
    }

    @Override
    public List<Pets> getPetsByTutorId(Long tutorId) {
        return petsRepository.findByTutorId(tutorId);
    }

    @Override
    public Pets getPetById(Long petId) {
        return petsRepository.findById(petId).orElse(null);
    }

    @Override
    public Pets updatePet(PetsDTO petDTO) {
        Pets pet = petsRepository.findById(petDTO.getId())
            .orElseThrow(() -> new RuntimeException("Pet não encontrado"));

        pet.setName(petDTO.getName());
        pet.setSpecie(petDTO.getSpecie());
        pet.setAge(petDTO.getAge());
        pet.setSize(petDTO.getSize());

        return petsRepository.save(pet);
    }

    @Override
    public void deletePetById(Long petId) {
        petsRepository.deleteById(petId);
    }
    
    @Override
    public List<Pets> getAllPets() {
        return petsRepository.findAll();
    }

}
