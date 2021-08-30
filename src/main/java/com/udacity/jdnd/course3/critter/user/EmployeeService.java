package com.udacity.jdnd.course3.critter.user;
import javax.persistence.*;
import com.udacity.jdnd.course3.critter.schedule.ScheduleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee aemployee = new Employee();
        aemployee.setId(employeeDTO.getId());
        aemployee.setName(employeeDTO.getName());
        aemployee.setSkills(employeeDTO.getSkills());
        aemployee.setDaysAvailable(employeeDTO.getDaysAvailable());
        employeeRepository.persist(aemployee);
        return employeeDTO;
    }

    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        Employee xdd = employeeRepository.find(employeeId);
        xdd.setDaysAvailable(daysAvailable);
        employeeRepository.merge(xdd);
    }


    public List<EmployeeDTO> findEmployeesForService(EmployeeRequestDTO employeeDTO) {

    }







}
