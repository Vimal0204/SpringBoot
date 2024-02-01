package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AppDAOImpl implements AppDAO{
    // define field for entity managet
    private EntityManager entityManager;
    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
       return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteinstructorById(int theID) {
//        Instructor tempInstructor=entityManager.find(Instructor.class,theID);
        Instructor tempInstructor=findInstructorById(theID);
        entityManager.remove(tempInstructor);
    }
}
