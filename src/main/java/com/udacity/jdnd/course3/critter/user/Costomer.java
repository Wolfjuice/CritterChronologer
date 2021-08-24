package com.udacity.jdnd.course3.critter.user;
import javax.persistence.*;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Costomer {
    @Id
    @GeneratedValue
    private Long id;


    private String name;

    private String phoneNumber;
    private String notes;

    private List<Long> petIds;


    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<Long> getPetIds() {
        return petIds;
    }

    public void setPetIds(List<Long> petIds) {
        this.petIds = petIds;
    }
}