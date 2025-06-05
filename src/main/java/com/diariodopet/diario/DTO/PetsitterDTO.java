package com.diariodopet.diario.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetsitterDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
}
