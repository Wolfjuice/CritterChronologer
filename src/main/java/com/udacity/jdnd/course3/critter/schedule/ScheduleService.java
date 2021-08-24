package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    public void createSchedule(ScheduleDTO scheduleDTO){

    }

    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> listentity = scheduleRepository.getall

    }

    public List<ScheduleDTO> getScheduleForPet(long petId) {
        List<Schedule> listentity = scheduleRepository.getpetid

    }

    public List<ScheduleDTO> getScheduleForEmployee(long employeeId) {
        List<Schedule> listentity = scheduleRepository.getemployeid


    }
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List<Schedule> listentity = scheduleRepository.getcostomerid
    }




}