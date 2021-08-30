package com.udacity.jdnd.course3.critter.user;
import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.pet.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * Handles web requests related to Users.
 *
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    PetService petService;
    @Autowired
    CostomerService costomerService;
    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        throw new UnsupportedOperationException();
    }
    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers(){
        return costomerService.getAllCustomers();
    }
    public static CustomerDTO convertCostomerToCustomerDTO(Costomer costomer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(costomer, customerDTO);
        List<Long> petIds = new ArrayList<>();
        if (costomer.getPets() != null && costomer.getPets().size() > 0){
            for (Pet pet : costomer.getPets()){
                petIds.add(pet.getId());
            }
        }
        customerDTO.setPetIds(petIds);
        return customerDTO;
    }
    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        Pet pet = petService.getById(petId);
        Costomer costomer = costomerService.getOwnerByPet(pet);
        return convertCostomerToCustomerDTO(costomer);
    }
    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        throw new UnsupportedOperationException();
    }
    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        throw new UnsupportedOperationException();
    }
    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        throw new UnsupportedOperationException();
    }
    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        throw new UnsupportedOperationException();
    }
}