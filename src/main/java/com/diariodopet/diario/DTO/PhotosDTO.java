package com.diariodopet.diario.DTO;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotosDTO {
    private Long id;
    private String urlPhotos;
    private String legend;
    private Long visitsID;
}