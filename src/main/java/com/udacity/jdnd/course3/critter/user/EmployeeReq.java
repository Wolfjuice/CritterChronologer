package com.udacity.jdnd.course3.critter.user;
import java.time.LocalDate;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class EmployeeReq {
    @Id
    @GeneratedValue
    private Long id;

    private Set<EmployeeSkill> skills;
    private LocalDate date;


    /* getters and setters */
}