package com.udacity.jdnd.course3.critter.user;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
@Transactional
public class EmployeeRepository {
    @PersistenceContext
    EntityManager entityManager;


    public void persist(Employee employee) {
        entityManager.persist(employee);
    }

    public Employee find(Long id) {
        return entityManager.find(Employee.class, id);
    }

    public Employee merge(Employee employee){
        return entityManager.merge(employee);
    }


    public void delete(Long id) {
        Costomer thiscostomer = entityManager.find(Costomer.class, id);
        entityManager.remove(thiscostomer);
    }

    public List<Employee> findEmployeesForService(Set<EmployeeSkill> skillsSet, DayOfWeek dayOfWeek){
        String FIND_BY_SERVICE = "select e from Employee e, Skill s, Day d" +
                "where e.id = s.id and e.id = d.id and s.skill in (" + skillsSet
                .stream()
                .map((skill) -> { return String.valueOf(skill.ordinal()); })
                .collect(Collectors.joining(",")) + ") AND d.day = " + dayOfWeek.ordinal() + " ";

        TypedQuery<Employee> query = entityManager.createQuery(FIND_BY_SERVICE, Employee.class);
        return query.getResultList();
    }


}
