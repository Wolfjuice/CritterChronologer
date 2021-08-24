package com.udacity.jdnd.course3.critter.pet;
import javax.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pet {

    @Id
    @GeneratedValue
    private Long id;


    private PetType type;


    private String name;

    private long ownerId;


    private LocalDate birthDate;


    private String notes;

    public Long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public PetType getType(){
        return type;
    }
    public void setType(PetType type){
        this.type = type;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public long getOwnerId(){
        return ownerId;
    }
    public void setOwnerId(long ownerId){
        this.ownerId = ownerId;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate){
        this.birthDate = birthDate;
    }
    public String getNotes(){
        return notes;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
}