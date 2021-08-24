package com.udacity.jdnd.course3.critter.user;
import javax.persistence.*;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetDTO;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CostomerService {
    @Autowired
    CostomerRepository costomerRepository;


    public void saveCustomer(CustomerDTO customerDTO){
        Costomer costomer = new Costomer();
        costomer.setId(customerDTO.getId());
        costomer.setName(customerDTO.getName());
        costomer.setNotes(customerDTO.getNotes());
        costomer.setPetIds(customerDTO.getPetIds());
        costomer.setPhoneNumber(customerDTO.getPhoneNumber());

        costomerRepository.persist(costomer);
    }

    public List<CustomerDTO> getAllCustomers(){
        List<Costomer> listentity = costomerRepository.getAll();
        List<CustomerDTO> returnlist = new ArrayList<>();

        for(int i = 0; i < listentity.size(); i++){
            CustomerDTO tobereturned = new CustomerDTO();
            Costomer cust = listentity.get(i);
            tobereturned.setId(cust.getId());
            tobereturned.setName(cust.getName());
            tobereturned.setNotes(cust.getNotes());
            tobereturned.setPetIds(cust.getPetIds());
            tobereturned.setPhoneNumber(cust.getPhoneNumber());
            returnlist.add(tobereturned);
        }
        return returnlist;

    }

    public CustomerDTO getOwnerByPet(long petId){
        costomerRepository.getbypetid(petId);
        return Customer -> CustomerDTO
    }

}
