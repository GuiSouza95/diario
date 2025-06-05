package com.diariodopet.diario.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diariodopet.diario.model.Tutores;
import com.diariodopet.diario.repository.TutorRepository;
import com.diariodopet.diario.service.TutorService;

@Service
public class TutorServiceImpl implements TutorService{
    
    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public Tutores saveTutor(Tutores tutor){
        return tutorRepository.save(tutor);
    }

    @Override
    public List<Tutores> getAllTutores() {
        return tutorRepository.findAll();
    }

    @Override
    public Optional<Tutores> getTutorById(Long id) {
        return tutorRepository.findById(id);
    }

    @Override
    public Optional<Tutores> getTutorByEmail(String email) {
        return tutorRepository.findByEmail(email);
    }

    @Override
    public void deleteTutor(Long id) {
        tutorRepository.deleteById(id);
    }
}
