package com.hackaboss.pruebatec2.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Citizen implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    
    @Column(unique=true)
    String identification;
    
    @OneToMany(mappedBy = "citizen")
    List<Turn> turnList;

    public Citizen() {
    }

    public Citizen(String name, int age, String identification) {
        
        this.name = name;
        this.age = age;
        this.identification = identification;
        this.turnList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public List<Turn> getTurnList() {
        return turnList;
    }

    public void setTurnList(List<Turn> turnList) {
        this.turnList = turnList;
    }
    
    
    /***
     * Metodo para agregar turno a la lista
     * @param turn 
     */
    public void addTurn(Turn turn){
        turnList.add(turn);
    }
    
    
    
    
}
