package com.udacity.jdnd.course3.critter.pet;

import java.util.List;

@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public Long save(PetDTO pet){
        // dto to entity
        return petRepository.save(    ).getId();
    }

    public Pet getById(Long id){
        return petRepository.getById(id);
    }

    public List<Pet> getAll(){
        return petRepository.getAll();
    }

    public List<Pet> getPetsByOwner(){
        return petRepository.getPetsByOwner(id);
    }




}