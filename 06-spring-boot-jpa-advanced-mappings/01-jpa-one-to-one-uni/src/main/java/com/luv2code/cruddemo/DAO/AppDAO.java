package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteinstructorById(int theID);
}
