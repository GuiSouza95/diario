package com.diariodopet.diario.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "petsitters")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Petsitters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo não pode ser vazio ou apenas espaços.")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "O campo não pode ser vazio ou apenas espaços.")
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @NotBlank(message = "O campo não pode ser vazio ou apenas espaços.")
    @Email
    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "petsitter", cascade = CascadeType.ALL)
    private List<Visits> visits;

    @ManyToMany
    @JoinTable(
        name = "petsitter_pets",
        joinColumns = @JoinColumn(name = "petsitter_id"),
        inverseJoinColumns = @JoinColumn(name = "pet_id")
    )
    private List<Pets> pets;
}
