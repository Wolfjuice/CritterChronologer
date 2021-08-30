package com.udacity.jdnd.course3.critter.pet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.udacity.jdnd.course3.critter.user.Costomer;
import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private PetType type;
    private String name;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ownerId")
    private Costomer customer; // ownerId;
    private LocalDate birthDate;
    private String notes;
    public Costomer getCustomer() {
        return customer;
    }
    public void setCustomer(Costomer customer) {
        this.customer = customer;
    }
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