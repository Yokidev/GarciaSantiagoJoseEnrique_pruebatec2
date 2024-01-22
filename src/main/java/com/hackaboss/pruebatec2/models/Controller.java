package com.hackaboss.pruebatec2.models;

import com.hackaboss.pruebatec2.persistence.PersistenceController;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Controller {
    
    PersistenceController persistenceController = new PersistenceController();
    
    
    public void createCitizen(String name, int age, String identification) {
        
        persistenceController.createCitizen(new Citizen(name, age, identification));
        
    }
    
    public Citizen findCitizen(int id){
        return persistenceController.findCitizen(id);
    }
    
    public List<Citizen> citizenList(){
        return persistenceController.findCitizens();
    }
    
    public Citizen findCitizenByIdentification(String identification){
       return persistenceController.findCitizenByIdentification(identification);
    }
    
    
    public void createTurn(LocalDateTime fecha, String description, String identification) {
    
        Citizen citizen = persistenceController.findCitizenByIdentification(identification);
        
        persistenceController.createTurn(new Turn(fecha,description,citizen));
        
    }
    
    public void editTurn(int id, String state, LocalDateTime date, String description) {
    
        Turn turn = findTurn(id);
        
        turn.setDate(date);
        turn.setDescription(description);
        
        if(state.equals("waiting")){
            turn.setAttended(false);
        }
        if(state.equals("attended")){
            turn.setAttended(true);
        }
        
        persistenceController.editTurn(turn);
        
    }

    private Turn findTurn(int id) {
        return persistenceController.findTurn(id);
    }
    
    public List<Turn> turnList(){
        return persistenceController.findTurns();
    }
    
    public List<Turn> turnListFilter(LocalDate date,String state){
        if(state.equals("all")){
         return turnListByDate(date);
        }
        
        if(state.equals("waiting")){
            return turnListByDate(date).stream().filter(turn-> turn.attended == false).toList();
        }
        
        if(state.equals("attended")){
            return turnListByDate(date).stream().filter(turn-> turn.attended == true).toList();
        }
        
        return Collections.emptyList();
    }
    
    public List<Turn> turnListByDate(LocalDate date){
        return persistenceController.findTurnsByDate(date);
    }

    public void editCitizen(int id, String name, int age, String identification) {
        
        Citizen citizen = findCitizen(id);
        
        citizen.setName(name);
        citizen.setAge(age);
        citizen.setIdentification(identification);
        
        persistenceController.editCitizen(citizen);
        
    }

    public boolean checkLogin(String user, String password) {
        boolean login = false;
        
        List<Users> userList = persistenceController.getUsers();
        
        for(Users usu : userList){
            if(usu.getUser().equalsIgnoreCase(user)){
                if(usu.getPassword().equals(password)){
                    login = true;
                }else{
                    login = false;
                }
            }
        }
        return login;
    }

    

    
    
    
}
