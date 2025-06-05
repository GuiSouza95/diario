package com.diariodopet.diario.service.implementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.diariodopet.diario.DTO.UserDTO;
import com.diariodopet.diario.model.Petsitters;
import com.diariodopet.diario.model.Role;
import com.diariodopet.diario.model.Tutores;
import com.diariodopet.diario.model.User;
import com.diariodopet.diario.repository.UserRepository;
import com.diariodopet.diario.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(UserDTO userDTO) {
            System.out.println("Salvando usuário com email: " + userDTO.getEmail());
            System.out.println("Tipo: " + userDTO.getRole());
            if (userDTO.getTutor() != null) {
                System.out.println("Nome tutor: " + userDTO.getTutor().getName());
            }
            if (userDTO.getPetsitter() != null) {
                System.out.println("Nome petsitter: " + userDTO.getPetsitter().getName());
            }
            
        User.UserBuilder userBuilder = User.builder()
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .role(userDTO.getRole());

         if (userDTO.getRole() == Role.TUTOR && userDTO.getTutor() != null) {
            Tutores tutor = Tutores.builder()
                    .name(userDTO.getTutor().getName())
                    .email(userDTO.getEmail())
                    .phoneNumber(userDTO.getTutor().getPhoneNumber())
                    .address(userDTO.getTutor().getAddress())
                    .nif(userDTO.getTutor().getNif())
                    .birthdate(userDTO.getTutor().getBirthdate())
                    .build();

            userBuilder.tutor(tutor);

        } else if (userDTO.getRole() == Role.PETSITTER && userDTO.getPetsitter() != null) {
            Petsitters petsitter = Petsitters.builder()
                    .name(userDTO.getPetsitter().getName())
                    .email(userDTO.getEmail())
                    .phoneNumber(userDTO.getPetsitter().getPhoneNumber())
                    .build();

            userBuilder.petsitter(petsitter);
        }

        User user = userBuilder.build();

        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
