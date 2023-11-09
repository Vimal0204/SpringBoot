package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
    //define @PostConstructor to load the data...
    @PostConstruct
    public void loadData(){
        theStudents=theStudents=new ArrayList<>();
        theStudents.add(new Student("Vimal","Kumar"));
        theStudents.add(new Student("Parth","Khanna"));
        theStudents.add(new Student("Pratyaksh","Roy"));
    }
    // define an endpoint for "/student" = return a list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    // define endpoint to return studnet at index;
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //just index into the list.. keep it simple now..

        //check the studentId again list size

        if (studentId >= theStudents.size() || (studentId<0)) {
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return theStudents.get(studentId);
    }

}
