package com.hackaboss.pruebatec2.persistence;

import com.hackaboss.pruebatec2.models.Citizen;
import com.hackaboss.pruebatec2.models.Turn;
import com.hackaboss.pruebatec2.models.Users;
import com.hackaboss.pruebatec2.persistence.exceptions.NonexistentEntityException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenceController {

    CitizenJpaController citizenJpaController = new CitizenJpaController();
    TurnJpaController turnJpaController = new TurnJpaController();
    UsersJpaController usersJpaController = new UsersJpaController();

    //Citizen
    public void createCitizen(Citizen citizen) {
        citizenJpaController.create(citizen);
    }

    public void deleteCitizen(int id) {
        try {
            citizenJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Citizen> findCitizens() {
        return citizenJpaController.findCitizenEntities();
    }

    public void editCitizen(Citizen citizen) {
        try {
            citizenJpaController.edit(citizen);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Citizen findCitizenByIdentification(String identification) {
        return citizenJpaController.findCitizenByIdentification(identification);
    }

    public Citizen findCitizen(int id) {
        return citizenJpaController.findCitizen(id);
    }

    //Turn
    public void createTurn(Turn turn) {
        turnJpaController.create(turn);
    }

    public void deleteTurn(int id) {
        try {
            turnJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Turn> findTurns() {
        return turnJpaController.findTurnEntities();
    }

    public void editTurn(Turn turn) {
        try {
            turnJpaController.edit(turn);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Turn> findTurnsByDate(LocalDate date) {
        return turnJpaController.findTurnEntitiesByDate(date);
    }

    public Turn findTurn(int id) {
        return turnJpaController.findTurn(id);
    }

    public List<Users> getUsers() {
        return usersJpaController.findUsersEntities();
    }

}
