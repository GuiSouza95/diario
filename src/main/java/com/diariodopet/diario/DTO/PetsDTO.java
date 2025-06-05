package com.diariodopet.diario.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetsDTO {
    private String name;
    private String specie;
    private int age;
    private String size;
    private Long tutorId;
}
