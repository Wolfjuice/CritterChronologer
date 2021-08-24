package com.udacity.jdnd.course3.critter.pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PetRepository {
    @PersistenceContext
    EntityManager entityManager;

    private static final String FIND_ALL = "select p from Pet p";
    private static final String FIND_BY_OWNER = "select p from Pet p" + "where p.ownerId = :ownerId";
    public void persist(Pet pet) {
        entityManager.persist(pet);
    }

    public Pet find(Long id) {
        return entityManager.find(Pet.class, id);
    }

    public Pet merge(Pet pet){
        return entityManager.merge(pet);
    }

    public List<Pet> getAll(){
        TypedQuery<Pet> query = entityManager.createQuery(FIND_ALL, Pet.class);
        return query.getResultList();
    }
    public List<Pet> findByOwner(Long id){
        TypedQuery<Pet> query = entityManager.createQuery(FIND_BY_OWNER, Pet.class);
        query.setParameter("ownerId", id);
        return query.getResultList();
    }

    public void delete(Long id) {
        Pet thispet = entityManager.find(Pet.class, id);
        entityManager.remove(thispet);
    }


}