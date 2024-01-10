package com.advanced.mapping.cruddemo.dao;

import com.advanced.mapping.cruddemo.entity.Course;
import com.advanced.mapping.cruddemo.entity.Instructor;
import com.advanced.mapping.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int id);
    Course findCourseById(int id);

    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);


    Instructor findInstructorByIdWithCoursesJoinFetch(int id);

    void updateInstructor(Instructor theInstructor);
    void updateCourse(Course theCourse);
}
