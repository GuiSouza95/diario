package com.diariodopet.diario.security;

import com.diariodopet.diario.model.User;
import com.diariodopet.diario.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByEmail(email);
        
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado com email: " + email);
        }

        User user = userOptional.get();

        System.out.println("Usuário carregado: " + user.getEmail());
        System.out.println("Senha hash no banco: " + user.getPassword());

        return new UserDetailsImpl(user);
    }
}