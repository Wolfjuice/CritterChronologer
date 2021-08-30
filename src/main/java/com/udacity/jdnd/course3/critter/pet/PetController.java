package com.udacity.jdnd.course3.critter.pet;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {
    private final PetService petService;

    PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        petService.save(petDTO);
        return petDTO;
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        PetDTO tobereturned = new PetDTO();
        Pet apet = petService.getById(petId);
        tobereturned.setId(apet.getId());
        tobereturned.setName(apet.getName());
        tobereturned.setBirthDate(apet.getBirthDate());
        tobereturned.setType(apet.getType());
        tobereturned.setOwnerId(apet.getCustomer().getId());
        tobereturned.setNotes(apet.getNotes());
        return tobereturned;

    }

    @GetMapping
    public List<PetDTO> getPets(){

        List<Pet> petlist = petService.getAll();
        List<PetDTO> returnpetlist = new ArrayList<>();
        for(int i = 0; i < petlist.size(); i++){
            PetDTO tobereturned = new PetDTO();
            Pet apet = petlist.get(i);
            tobereturned.setId(apet.getId());
            tobereturned.setName(apet.getName());
            tobereturned.setBirthDate(apet.getBirthDate());
            tobereturned.setType(apet.getType());
            tobereturned.setOwnerId(apet.getCustomer().getId());
            tobereturned.setNotes(apet.getNotes());
            returnpetlist.add(tobereturned);
        }
        return returnpetlist;
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<Pet> petlist = petService.getPetsByOwner(ownerId);
        List<PetDTO> returnpetlist = new ArrayList<>();
        for(int i = 0; i < petlist.size(); i++){
            PetDTO tobereturned = new PetDTO();
            Pet apet = petlist.get(i);
            tobereturned.setId(apet.getId());
            tobereturned.setName(apet.getName());
            tobereturned.setBirthDate(apet.getBirthDate());
            tobereturned.setType(apet.getType());
            tobereturned.setOwnerId(apet.getCustomer().getId());
            tobereturned.setNotes(apet.getNotes());
            returnpetlist.add(tobereturned);
        }
        return returnpetlist;
    }


}
