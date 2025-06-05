package com.diariodopet.diario.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.diariodopet.diario.DTO.UserDTO;
import com.diariodopet.diario.model.User;

@Service
public interface UserService {
    User createUser(UserDTO userDTO);
    Optional<User> getUserByEmail(String email);
}