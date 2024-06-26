package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);
			findInstructor(appDAO);
//			deleteInstructorById(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=3;
		System.out.println("Deleting instructor detail id: "+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=2;
		System.out.println("Finding instructor detail id: "+theId);
		InstructorDetail tempInstructorDetail=appDAO.findIndInstructorDetailById(theId);
		System.out.println("tempInstructorDetail: "+tempInstructorDetail);
		System.out.println("the associate instructor only: "+tempInstructorDetail.getInstructor());
		System.out.println("Done!");
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting instructor id: "+theId);
		appDAO.deleteinstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=3;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated instructorDetail only: "+tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {
//		// create the instructor
//		Instructor tempInstructor=new Instructor("Chad","Darby","darby@luv2code.com");
//		// create the instructor detail
//		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.luv2code.come/youtube","Luv 2 code!!!");
		// create the instructor
		Instructor tempInstructor=new Instructor("Madhu","Patel","madhu@luv2code.com");
		// create the instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.luv2code.com/youtube","Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//save the instructor
		//
		//NOTE: THIS WILL ALSO SAVE THE DETAILS OBJECT
		//because of CascadeType.ALL
		//
		System.out.println("Saving instructor: "+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}

}
