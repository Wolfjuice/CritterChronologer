package com.udacity.jdnd.course3.critter.schedule;

import com.udacity.jdnd.course3.critter.pet.Pet;
import com.udacity.jdnd.course3.critter.user.Costomer;
import com.udacity.jdnd.course3.critter.user.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ScheduleRepository {
    @PersistenceContext
    EntityManager entityManager;

    private static final String FIND_ALL = "select s from Schedule s";
    private static final String FIND_BY_PET = "select s from Schedule s where :pet member of s.pets";
    private static final String FIND_BY_EMPLOYEE = "select s from Schedule s where :employee member of s.employees";
    private static final String FIND_BY_COSTOMER = "select s from Schedule s where :customer member of s.customer";
    public void persist(Schedule schedule) {
        entityManager.persist(schedule);
    }

    public Schedule find(Long id) {
        return entityManager.find(Schedule.class, id);
    }

    public Schedule merge(Schedule schedule){
        return entityManager.merge(schedule);
    }


    public List<Schedule> findScheduleByPet(Pet pet){
        return entityManager
                .createQuery(FIND_BY_PET, Schedule.class)
                .setParameter("pet", pet)
                .getResultList();
    }
    public List<Schedule> findScheduleByEmployee(Employee employee){
        return entityManager
                .createQuery(FIND_BY_EMPLOYEE, Schedule.class)
                .setParameter("employee", employee)
                .getResultList();
    }

    public List<Schedule> findScheduleForCustomer(Costomer costomer){
        return entityManager
                .createQuery(FIND_BY_EMPLOYEE, Schedule.class)
                .setParameter("customer", costomer)
                .getResultList();
    }

    public void delete(Long id) {
        Schedule thisschedule = entityManager.find(Schedule.class, id);
        entityManager.remove(thisschedule);
    }

    public List<Schedule> getAll(){
        TypedQuery<Schedule> query = entityManager.createQuery(FIND_ALL, Schedule.class);
        return query.getResultList();
    }


}