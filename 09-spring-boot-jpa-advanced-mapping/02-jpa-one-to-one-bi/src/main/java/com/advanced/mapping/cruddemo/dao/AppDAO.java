package com.advanced.mapping.cruddemo.dao;

import com.advanced.mapping.cruddemo.entity.Instructor;
import com.advanced.mapping.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);

}
