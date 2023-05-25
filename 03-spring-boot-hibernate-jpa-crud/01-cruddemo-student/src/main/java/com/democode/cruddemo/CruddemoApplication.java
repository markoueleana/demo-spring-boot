package com.democode.cruddemo;

import com.democode.cruddemo.dao.StudentDAO;
import com.democode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner->{

			//createMultipleStudent( studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println(studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("Deleting the student" + studentDAO.findByid(studentId).getFirstName());
		studentDAO.delete(studentId);
	}

	private void queryForLastName(StudentDAO studentDAO) {
		List<Student> listOfStudent=studentDAO.findByLastName("Lavida");
		for (Student st : listOfStudent){
			System.out.println(st);
		}
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		Student newStudent1 = new Student("Maria","Papadopoulou","papadopoulou@gmail.com");
		Student newStudent2 = new Student("Kostas","Dimitriadhs","dimitriadhs@gmail.com");
		Student newStudent3 = new Student("Banana","Tsita","tsita@gmail.com");
		Student newStudent4 = new Student("Coca","Lavida","lavida@gmail.com");
		System.out.println("Saving...");
		studentDAO.save(newStudent1);
		studentDAO.save(newStudent2);
		studentDAO.save(newStudent3);
		studentDAO.save(newStudent4);
	}

	private void createStudent(StudentDAO studentDAO) {

		Student newStudent = new Student("Eleana","Markou","eleana@gmail.com");
		System.out.println("Saving...");
		studentDAO.save(newStudent);
		System.out.println("Saved with id: "+ newStudent.getId());
	}
	private void findStudentById(StudentDAO studentDAO) throws IOException {
		Student newStudent = new Student("Silly","Willy","willy@gmail.com");
		System.out.println("Saving...");
		studentDAO.save(newStudent);
		studentDAO.findByid(System.in.read());
		System.out.println(newStudent);
	}
	private void findAll(StudentDAO studentDAO) {
		List<Student> listOfStudent=studentDAO.findAll();
		for (Student st : listOfStudent){
			System.out.println(st);
		}

	}
    private void updateStudent ( StudentDAO studentDAO) throws IOException {
        int studentId= 1;
        Student studentToBeUpdated =  studentDAO.findByid(studentId);
        studentToBeUpdated.setFirstName("Eleana");
        studentDAO.update(studentToBeUpdated);

    }
}
