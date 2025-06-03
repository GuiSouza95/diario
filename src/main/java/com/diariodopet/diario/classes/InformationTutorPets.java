package com.diariodopet.diario.classes;

public class InformationTutorPets {
    private String infoSpecial, description;

    public InformationTutorPets(String infoSpecial, String description){
        this.infoSpecial = infoSpecial;
        this.description = description;
    }

    public String getInfospecial(){
        return infoSpecial;
    }

    public String getDescription(){
        return description;
    }
}
