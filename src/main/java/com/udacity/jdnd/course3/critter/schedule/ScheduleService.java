package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepository;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import com.udacity.jdnd.course3.critter.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    PetRepository petRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CostomerRepository costomerRepository;
    public void createSchedule(Schedule schedule){
        scheduleRepository.persist(schedule);
    }

    public List<Schedule> getAllSchedules() {
        return scheduleRepository.getAll();

    }

    public List<Schedule> getScheduleForPet(long petId) {
        Pet thePet = petRepository.find(petId);
        return scheduleRepository.findScheduleByPet(thePet);
    }

    public List<Schedule> getScheduleForEmployee(long employeeId) {
        Employee av = employeeRepository.find(employeeId);
        return scheduleRepository.findScheduleByEmployee(av);


    }
    public List<Schedule> getScheduleForCustomer(long customerId) {
        List<Schedule> returnMe = new ArrayList<Schedule>();
        List<Pet> thePets = petRepository.findByOwner(customerId);
        for(Pet onepet : thePets){
            returnMe.addAll(scheduleRepository.findScheduleByPet(onepet));
        }

        return returnMe;

    }




}