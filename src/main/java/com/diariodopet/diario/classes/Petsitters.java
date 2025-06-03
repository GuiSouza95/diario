package com.diariodopet.diario.classes;

public class Petsitters {
    private String nameSitter, email, password, phoneNumber;

    public Petsitters(String nameSitter, String email, String password, String phoneNumber){
        this.nameSitter = nameSitter;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getNameSitter(){
        return nameSitter;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
}
