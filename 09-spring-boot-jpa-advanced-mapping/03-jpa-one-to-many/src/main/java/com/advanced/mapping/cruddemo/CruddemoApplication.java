package com.advanced.mapping.cruddemo;

import com.advanced.mapping.cruddemo.dao.AppDAO;
import com.advanced.mapping.cruddemo.entity.Course;
import com.advanced.mapping.cruddemo.entity.Instructor;
import com.advanced.mapping.cruddemo.entity.InstructorDetail;
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

		return  runner->{
            findInstructorWithCourses( appDAO);
		};
	}

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id=1;
        System.out.println("Finding id "+ id);
        Instructor tempInstructor = appDAO.findInstructorById(id);
        System.out.println("tempInstructor "+ tempInstructor);

        System.out.println("tempInstructor "+ tempInstructor.getCourses());

    }

    private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor= new Instructor("Kara","Melakis","karamelakis@hotmail.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.kapamelakis.pat/youtube","Caramel");
		Course tempCourse1 =
				new Course("Vanilla Caramel Class");
		Course tempCourse2 =
				new Course("Vanilla Caramel Master Class");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		tempInstructor.addCourse(tempCourse1);
		tempInstructor.addCourse(tempCourse2);
		System.out.println("Saving instructor "+ tempInstructor);
		System.out.println("Courses "+ tempInstructor.getCourses());
		appDAO.save(tempInstructor);

	}

	private void createInstructor(AppDAO appDAO) {
		Instructor tempInstructor= new Instructor("Mousta","Kis","moustakis@hotmail.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.kapari.pat/youtube","Shaving");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving instructor "+ tempInstructor);
		appDAO.save(tempInstructor);

	}
	private void findInstructor(AppDAO appDAO) {
		int id= 1;
		Instructor tempInstructor=  appDAO.findInstructorById(id);

		System.out.println("Instructor found  "+ tempInstructor);

		System.out.println("Instructor Details found  "+ tempInstructor.getInstructorDetail());
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id= 1;
		InstructorDetail tempInstructorDetail=  appDAO.findInstructorDetailById(id);

		System.out.println("Instructor  Detail found  "+ tempInstructorDetail);

		System.out.println("Instructor  found  "+ tempInstructorDetail.getInstructor());
	}
}
