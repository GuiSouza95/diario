package com.diariodopet.diario.classes;

public class Reports {
    private String observation, eventVisit ;

    public Reports(String observation, String eventVisit){
        this.observation = observation;
        this.eventVisit = eventVisit;
    }

    public String getObservation(){
        return observation;
    }

    public String getEventVisit(){
        return eventVisit;
    }
}
