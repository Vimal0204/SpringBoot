package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.AppDAO;
import com.luv2code.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createCourseAndStudents(appDAO);
//			findCourseAndStudents(appDAO);
//			findStudentsAndCourse(appDAO);
//			addMoreCoursesForStudent(appDAO);
//			deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId=1;
		System.out.println("Deleting student id: "+theId);
		appDAO.deleteStudentById(theId);
		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId=2;
		Student tempStudent=appDAO.findStudentAndCoursesByStudentId(theId);
		// create more courses
		Course tempCourse1 = new Course("Rubik's Cube = HOw to speed Cube");
		Course tempCourse2 = new Course("How to cook daily");
		// add the course to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		System.out.println("Updating student: "+tempStudent);
		System.out.println("associated courses: "+tempStudent.getCourses());
		appDAO.update(tempStudent);
		System.out.println("Done!");
	}

	private void findStudentsAndCourse(AppDAO appDAO) {
		int theId=2;
		Student tempStudent=appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("Students: "+tempStudent);
		System.out.println("Loaded Courses: "+tempStudent.getCourses());
		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int theId=10;
		Course tempCourse = appDAO.findCourseAndStudentByCourseId(theId);
		System.out.println("Loaded course: "+tempCourse);
		System.out.println("Students: "+tempCourse.getStudents());
		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		// create a course
		Course tempCourse=new Course("Pacman - How to score one million points");
		// create the students
		Student tempStudent1=new Student("John","doe","john@luv2code.com");
		Student tempStudent2=new Student("Mary","Public","Mary@luv2code.com");
//		Student tempStudent=new Student("John","doe","john@luv2code.com");
		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		// save the course and associated students
		System.out.println("Saving the course: "+tempCourse);
		System.out.println("Saving the Students: "+tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId=11;
		System.out.println("Deleting curse id: "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId = 11;
		Course tempCourse=appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course tempCourse=new Course("Pacman - How to Score one Million Points");
		// add some course
		tempCourse.addReview(new Review("Great course ... loved it!"));
		tempCourse.addReview(new Review("Cool course ... job well done."));
		tempCourse.addReview(new Review("What a dumb course, you are an idiot!"));
		// save the course
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		appDAO.save(tempCourse);
		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("Deleting course id: "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId=10;
		// find the course
		System.out.println("Finding course id: "+theId);
		Course tempCourse=appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: "+theId);
		tempCourse.setTitle("Enjoy the simple Things");
		appDAO.update(tempCourse);
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;
		// find the instructor
		System.out.println("Finding the instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		// update the instructor
		System.out.println("Update instructor id: "+theId);
		tempInstructor.setLastName("TESTER");
		appDAO.update(tempInstructor);
		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		// find courses for instructor
		System.out.println("finding courses for instructor id: "+theId);
		List<Course> courses=appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("The associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor=new Instructor("Susan","Public","susan@luv2code.com");
		// create the instructor detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.youtube.com","Gamer");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		Course tempCourse1=new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2=new Course("The Pinball Masterclass");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		// save the instructor
		//
		// NOTE: this will also save course
		// because of CascadeType.PERSIST
		System.out.println("Saving instructor: "+tempInstructor);
//		System.out.println("The courses: "+tempInstructor.getCourses());

		appDAO.save(tempInstructor);
		System.out.println("Done!");


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
		int theId=2;
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
