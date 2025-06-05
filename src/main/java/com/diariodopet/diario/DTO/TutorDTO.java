package com.diariodopet.diario.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TutorDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private Integer nif;
    private LocalDate birthdate;
}
