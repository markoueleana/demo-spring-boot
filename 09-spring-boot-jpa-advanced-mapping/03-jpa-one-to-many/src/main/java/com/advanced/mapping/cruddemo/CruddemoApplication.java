package com.advanced.mapping.cruddemo;

import com.advanced.mapping.cruddemo.dao.AppDAO;
import com.advanced.mapping.cruddemo.entity.Course;
import com.advanced.mapping.cruddemo.entity.Instructor;
import com.advanced.mapping.cruddemo.entity.InstructorDetail;
import com.advanced.mapping.cruddemo.entity.Review;
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

		return  runner->{
			deleteCourseAndReviews( appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int courseId= 10;
		appDAO.deleteCourseById(courseId);
		System.out.println("Course and its review were deleted!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int courseId= 10;
		Course tempCourse=appDAO.findCourseAndReviewsByCourseId(courseId);

		System.out.println("Course's reviews "+ tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse = new Course("Painting Classes");

		Review tempReview1 = new Review("Awesome");
		Review tempReview2 = new Review("The classes were great");
		Review tempReview3= new Review("Loved it!");

		tempCourse.addReview(tempReview1);
		tempCourse.addReview(tempReview2);
		tempCourse.addReview(tempReview3);

		appDAO.save(tempCourse);

		System.out.println("Course's reviews "+ tempCourse.getReviews());
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id=1;
		Instructor tempInstructor= appDAO.findInstructorByIdWithCoursesJoinFetch(id);
		System.out.println("tempInstructor "+ tempInstructor);
		System.out.println("Courses "+ tempInstructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
        int id=1;
        System.out.println("Finding id "+ id);
        Instructor tempInstructor = appDAO.findInstructorById(id);
        System.out.println("tempInstructor "+ tempInstructor);

		List<Course> tempCourses = appDAO.findCoursesByInstructorId(id);
		tempInstructor.setCourses(tempCourses);
        System.out.println("tempInstructor's  Courses"+ tempInstructor.getCourses());

    }
	private void findCoursesForInstructor(AppDAO appDAO) {
		int id=1;
		System.out.println("Finding id "+ id);

		Instructor tempInstructor=  appDAO.findInstructorById(id);

		System.out.println("tempInstructor "+ tempInstructor);
		System.out.println("Courses "+ tempInstructor.getCourses());
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
	private void deleteInstructor(AppDAO appDAO) {
		int id= 1;
		appDAO.deleteInstructorById(id);
	}
	private void findInstructorDetail(AppDAO appDAO) {
		int id= 1;
		InstructorDetail tempInstructorDetail=  appDAO.findInstructorDetailById(id);

		System.out.println("Instructor  Detail found  "+ tempInstructorDetail);

		System.out.println("Instructor  found  "+ tempInstructorDetail.getInstructor());
	}
	private void updateInstructor(AppDAO appDAO) {
		int id=1;
		System.out.println("Finding id "+ id);

		Instructor tempInstructor=  appDAO.findInstructorById(id);
		tempInstructor.setLastName(tempInstructor.getLastName()+"newLast");
		appDAO.updateInstructor(tempInstructor);
	}
	private void updateCourse(AppDAO appDAO) {
		int id=10;
		System.out.println("Finding id "+ id);

		Course tempCourse=  appDAO.findCourseById(id);
		tempCourse.setTitle(tempCourse.getTitle()+" new Title");
		appDAO.updateCourse(tempCourse);
	}
}
