package com.hackaboss.pruebatec2.models;

import com.hackaboss.pruebatec2.persistence.PersistenceController;
import java.time.LocalDateTime;
import java.util.List;


public class Controller {
    
    PersistenceController persistenceController = new PersistenceController();
    
    
    public void createCitizen(String name, int age, String identification) {
        
        persistenceController.createCitizen(new Citizen(name, age, identification));
        
    }
    
    public Citizen findCitizenByIdentification(String identification){
       return persistenceController.findCitizenByIdentification(identification);
    }
    
    
    public void createTurn(LocalDateTime fecha, String description, String identification) {
    
        Citizen citizen = persistenceController.findCitizenByIdentification(identification);
        
        persistenceController.createTurn(new Turn(fecha,description,citizen));
        
    }
    
    
    
    public List<Turn> turnList(){
        return persistenceController.findTurns();
    }
    
    
    public List<Turn> filterByAttended(){
        return null;
    }


    
    
    
}
