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
public class UserService {
    @Autowired
    CostomerRepository costomerRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    public void saveCustomer(CustomerDTO customerDTO){
        CustomerDTO -> Customer
        costomerRepository.save()
    }

    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> listentity = costomerRepository.getall();

    }

    public CustomerDTO getOwnerByPet(long petId){
        costomerRepository.getbypetid(petId);
        return Customer -> CustomerDTO
    }

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        EmployeeDTO -> Employee
        employeeRepository.save()
    }

//    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
//        throw new UnsupportedOperationException();
//    }


    public List<EmployeeDTO> findEmployeesForService(EmployeeRequestDTO employeeDTO) {

    }







}
