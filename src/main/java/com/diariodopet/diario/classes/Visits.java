package com.diariodopet.diario.classes;

public class Visits {
    private String dateVisit, hourInit, hourEnd;

    public Visits(String dateVisit, String hourInit, String hourEnd){
        this.dateVisit = dateVisit;
        this.hourInit = hourInit;
        this.hourEnd = hourEnd;
    }
    
    public String getDateVisit(){
        return dateVisit;
    }

    public String getHourInit(){
        return hourInit;
    }

    public String getHourEnd(){
        return hourEnd;
    }
}
