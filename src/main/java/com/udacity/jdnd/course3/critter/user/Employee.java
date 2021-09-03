package com.udacity.jdnd.course3.critter.user;
import javax.persistence.*;
import java.time.DayOfWeek;
import java.util.Set;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @ElementCollection
    @CollectionTable(
     name="Skill",
     joinColumns = @JoinColumn(name="id"), uniqueConstraints = @UniqueConstraint(columnNames = {"ID", "SKILL"}))
    @Column(name="skill")
    private Set<EmployeeSkill> skills;

    @ElementCollection
    @CollectionTable(
     name="Day",
     joinColumns = @JoinColumn(name="id"), uniqueConstraints = @UniqueConstraint(columnNames = {"ID", "DAY"}))
    @Column(name="day")
    private Set<DayOfWeek> daysAvailable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DayOfWeek> getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(Set<DayOfWeek> daysAvailable) {
        this.daysAvailable = daysAvailable;
    }

    public Set<EmployeeSkill> getSkills() {
        return skills;
    }

    public void setSkills(Set<EmployeeSkill> skills) {
        this.skills = skills;
    }
}