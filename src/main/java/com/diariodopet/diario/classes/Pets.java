package com.diariodopet.diario.classes;

public class Pets {
    private String namePet, speciePet, size;
    private int age;

    public Pets(String namePet, String speciePet, String size, int age){
        this.namePet = namePet;
        this.speciePet = speciePet;
        this.size = size;
        this.age = age;
    }

    public String getNamePet(){
        return namePet;
    }

    public String getSpeciePet(){
        return speciePet;
    }

    public String getSize(){
        return size;
    }

    public int getAge(){
        return age;
    }
}
