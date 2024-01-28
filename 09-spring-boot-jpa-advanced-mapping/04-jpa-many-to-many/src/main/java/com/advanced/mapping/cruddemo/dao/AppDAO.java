package com.advanced.mapping.cruddemo.dao;

import com.advanced.mapping.cruddemo.entity.Course;
import com.advanced.mapping.cruddemo.entity.Instructor;
import com.advanced.mapping.cruddemo.entity.InstructorDetail;
import com.advanced.mapping.cruddemo.entity.Student;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int id);
    Course findCourseById(int id);

    void deleteStudentById(int id);
    void deleteCourseById(int id);
    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);


    Instructor findInstructorByIdWithCoursesJoinFetch(int id);

    void updateInstructor(Instructor theInstructor);
    void updateCourse(Course theCourse);

    void save(Course theCourse);
    void updateStudent(Student theStudent);
    Course findCourseAndReviewsByCourseId(int id);
    Course findCourseAndStudentsByCourseId(int id);
    Student findStudentAndCoursesByStudentId(int id);
}
