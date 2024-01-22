package com.hackaboss.pruebatec2.models;

import com.hackaboss.pruebatec2.persistence.PersistenceController;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class Controller {
    
    PersistenceController persistenceController = new PersistenceController();
    
    /***
     * Metodo para crear un ciudadano en la BBDD
     * @param name
     * @param age
     * @param identification 
     */
    public void createCitizen(String name, int age, String identification) {
        
        persistenceController.createCitizen(new Citizen(name, age, identification));
        
    }
    
    /***
     * Metodo para eliminar un ciudadano de la BBDD
     * @param id 
     */
    public void deleteCitizen(int id){
        
        Citizen citizen = findCitizen(id);
        
        citizen.getTurnList().forEach(turn -> persistenceController.deleteTurn(turn.getId()));
        
        persistenceController.deleteCitizen(id);
        
        
    }
    
    /***
     * Metodo para recuperar un ciudadano de la BBDD usando el id
     * @param id
     * @return 
     */
    public Citizen findCitizen(int id){
        return persistenceController.findCitizen(id);
    }
    
    /***
     * Metodo para recuperar la lista de ciudadanos registrados en la BBDD
     * @return 
     */
    public List<Citizen> citizenList(){
        return persistenceController.findCitizens();
    }
    
    /***
     * Metodo para recuperar un ciudadano segun su identificacion
     * @param identification
     * @return 
     */
    public Citizen findCitizenByIdentification(String identification){
       return persistenceController.findCitizenByIdentification(identification);
    }
    
    /***
     * Metodo para crear un Turno en la BBDD
     * @param fecha
     * @param description
     * @param identification 
     */
    public void createTurn(LocalDateTime fecha, String description, String identification) {
    
        Citizen citizen = persistenceController.findCitizenByIdentification(identification);
        
        persistenceController.createTurn(new Turn(fecha,description,citizen));
        
    }
    
    /***
     * Metodo para borrar un turno de la BBDD
     * @param id 
     */
    public void deleteTurn(int id){
        persistenceController.deleteTurn(id);
        
    }
    
    /***
     * Metodo para editar un turno de la BBDD
     * @param id
     * @param state
     * @param date
     * @param description 
     */
    public void editTurn(int id, String state, LocalDateTime date, String description) {
    
        //Recuperamos el turno que queremos editar
        Turn turn = findTurn(id);
        
        //Seteamos los parametros nuevos
        turn.setDate(date);
        turn.setDescription(description);
        
        if(state.equals("waiting")){
            turn.setAttended(false);
        }
        if(state.equals("attended")){
            turn.setAttended(true);
        }
        
        //Lo modificamos en la BBDD
        persistenceController.editTurn(turn);
        
    }

    /***
     * Metodo para recuperar de la BBDD un turno segun su id
     * @param id
     * @return 
     */
    private Turn findTurn(int id) {
        return persistenceController.findTurn(id);
    }
    
    /***
     * Metodo para recuperar la lista de turnos
     * @return 
     */
    public List<Turn> turnList(){
        return persistenceController.findTurns();
    }
    
    /***
     * Metodo para recuperar los turnos segun el filto:
     * Todos -> recupera todos los turnos
     * En espera --> recupera solo los turnos que no han sido atendidos
     * Ya atendido --> recupera los turnos que han sido atendidos
     * @param date
     * @param state
     * @return 
     */
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
    
    /***
     * Metodo para recuperar una lista de turnos segun una fecha indicada
     * @param date
     * @return 
     */    
    public List<Turn> turnListByDate(LocalDate date){
        return persistenceController.findTurnsByDate(date);
    }

    /***
     * Metodo para editar un ciudadano
     * @param id
     * @param name
     * @param age
     * @param identification 
     */
    public void editCitizen(int id, String name, int age, String identification) {
        
        //Recuperamos el ciudadano que queremos editar mediante el id
        Citizen citizen = findCitizen(id);
        
        //Seteamos los parametros nuevos
        citizen.setName(name);
        citizen.setAge(age);
        citizen.setIdentification(identification);
        
        //Lo modificamos en la BBDD
        persistenceController.editCitizen(citizen);
        
    }

    /***
     * Metodo de verificacion de usuario y contraseña en la BBDD.
     * @param user
     * @param password
     * @return 
     */
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
