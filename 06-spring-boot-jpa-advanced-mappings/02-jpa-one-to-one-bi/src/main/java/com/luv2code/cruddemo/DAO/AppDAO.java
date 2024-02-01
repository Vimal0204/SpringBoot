package com.luv2code.cruddemo.DAO;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteinstructorById(int theID);
    InstructorDetail findIndInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
}
