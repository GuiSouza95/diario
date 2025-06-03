package com.diariodopet.diario.model;

import java.time.LocalDate;

import org.springframework.security.crypto.bcrypt.BCrypt;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Tutores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameTutor, phoneNumber, address;

    @NotNull
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
    private String password;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    private Integer nif;

    private LocalDate birthdate;

    public Tutores(){}

    public Tutores(String nameTutor, String phoneNumber, String email, String address, String password, Integer nif, LocalDate birthdate){
        this.nameTutor = nameTutor;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.password = password;
        this.nif = nif;
        this.birthdate = birthdate;
    }

    public String getNameTutor(){
        return nameTutor;
    }

    public void setNameTutor(String nameTutor){
        this.nameTutor = nameTutor;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }
    
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public Integer getNif(){
        return nif;
    }

    public void setNif(Integer nif){
        this.nif = nif;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
