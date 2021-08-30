package com.udacity.jdnd.course3.critter.schedule;
import com.udacity.jdnd.course3.critter.user.EmployeeSkill;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Schedule {
    @Id
    @GeneratedValue
    private Long id;


    private List<Long> employeeIds;

    private List<Long> petIds;

    private LocalDate date;


    private Set<EmployeeSkill> activities;





    /* getters and setters */
}