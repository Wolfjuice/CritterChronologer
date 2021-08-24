package com.udacity.jdnd.course3.critter.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public void save(PetDTO pet){
        Pet pete = new Pet();
        pete.setId(pet.getId());
        pete.setType(pet.getType());
        pete.setName(pet.getName());
        pete.setBirthDate(pet.getBirthDate());
        pete.setNotes(pet.getNotes());

        petRepository.persist(pete);
    }

    public Pet getById(Long id){
        return petRepository.find(id);
    }

    public List<Pet> getAll(){
        return petRepository.getAll();
    }

    public List<Pet> getPetsByOwner(Long id){
        return petRepository.findByOwner(id);
    }




}