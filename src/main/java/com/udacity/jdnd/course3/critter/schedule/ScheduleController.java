package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetRepository;
import com.udacity.jdnd.course3.critter.user.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @Autowired
    PetRepository petRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    CostomerRepository costomerRepository;
    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(scheduleDTO, schedule);
        List<Pet> pets = new ArrayList<>();
        List<Costomer> customers = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();

            for (Long pid  : scheduleDTO.getPetIds()){
                pets.add(petRepository.find(pid));
            }
            for (Long cid : scheduleDTO.getCostomerIds()){
                customers.add(costomerRepository.find(cid));
            }
            for (Long eid : scheduleDTO.getEmployeeIds()){
                employees.add(employeeRepository.find(eid));
            }

        schedule.setCustomers(customers);
        schedule.setEmployees(employees);
        schedule.setPets(pets);
        scheduleService.createSchedule(schedule);
        return scheduleDTO;
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        List<ScheduleDTO> returned = new ArrayList<>();
        List<Schedule> theEntities = scheduleService.getAllSchedules();

        for (Schedule s : theEntities){
            returned.add(aConversion(s));
        }
        return returned;

    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        List<ScheduleDTO> returned = new ArrayList<>();
        List<Schedule> theEntities = scheduleService.getScheduleForPet(petId);

        for (Schedule s : theEntities){
            returned.add(aConversion(s));
        }
        return returned;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        List<ScheduleDTO> returned = new ArrayList<>();
        List<Schedule> theEntities = scheduleService.getScheduleForEmployee(employeeId);

        for (Schedule s : theEntities){
            returned.add(aConversion(s));
        }
        return returned;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List<ScheduleDTO> returned = new ArrayList<>();
        List<Schedule> theEntities = scheduleService.getScheduleForCustomer(customerId);

        for (Schedule s : theEntities){
            returned.add(aConversion(s));
        }
        return returned;
    }
    public static ScheduleDTO aConversion(Schedule schedule){
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        BeanUtils.copyProperties(schedule, scheduleDTO);
        List<Long> petIds = new ArrayList<>();
        List<Long> customerIds = new ArrayList<>();
        List<Long> employeeIds = new ArrayList<>();
        if (schedule.getPets() != null && schedule.getPets().size() > 0){
            for (Pet pet : schedule.getPets()){
                petIds.add(pet.getId());
            }
        }
        if (schedule.getCustomers() != null && schedule.getCustomers().size() > 0){
            for (Costomer costomer : schedule.getCustomers()){
                customerIds.add(costomer.getId());
            }
        }
        if (schedule.getEmployees() != null && schedule.getEmployees().size() > 0){
            for (Employee employee : schedule.getEmployees()){
                employeeIds.add(employee.getId());
            }
        }
        scheduleDTO.setCostomerIds(customerIds);
        scheduleDTO.setEmployeeIds(employeeIds);
        scheduleDTO.setPetIds(petIds);
        return scheduleDTO;
    }
}
