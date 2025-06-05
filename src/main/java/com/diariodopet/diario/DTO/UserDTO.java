package com.diariodopet.diario.DTO;

import com.diariodopet.diario.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private Role role;

    private TutorDTO tutor;
    private PetsitterDTO petsitter;
}
