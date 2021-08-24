package com.udacity.jdnd.course3.critter.user;


import com.udacity.jdnd.course3.critter.pet.Pet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CostomerRepository {
    @PersistenceContext
    EntityManager entityManager;

    private static final String FIND_ALL = "select c from Costomer c";
    private static final String FIND_BY_PET


    public void persist(Costomer costomer) {
        entityManager.persist(costomer);
    }

    public Costomer find(Long id) {
        return entityManager.find(Costomer.class, id);
    }

    public Costomer merge(Costomer costomer){
        return entityManager.merge(costomer);
    }


    public void delete(Long id) {
        Costomer thiscostomer = entityManager.find(Costomer.class, id);
        entityManager.remove(thiscostomer);
    }
    public List<Costomer> getAll(){
        TypedQuery<Costomer> query = entityManager.createQuery(FIND_ALL, Costomer.class);
        return query.getResultList();
    }
}
