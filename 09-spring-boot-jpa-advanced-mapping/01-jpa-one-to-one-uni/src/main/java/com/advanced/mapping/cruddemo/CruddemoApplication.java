package com.advanced.mapping.cruddemo;

import com.advanced.mapping.cruddemo.dao.AppDAO;
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

		return  runner->{findInstructor(appDAO);
		};
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
}
