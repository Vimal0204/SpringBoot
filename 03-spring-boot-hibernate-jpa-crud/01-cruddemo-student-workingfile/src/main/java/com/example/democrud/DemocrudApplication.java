package com.example.democrud;

import com.example.democrud.dao.StudentDAO;
import com.example.democrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemocrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemocrudApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new Student object...");
		Student tempStudent = new Student("Paul","Doe","paul@luv2code.com");

		//save the student object
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);

		//display the id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}

}
