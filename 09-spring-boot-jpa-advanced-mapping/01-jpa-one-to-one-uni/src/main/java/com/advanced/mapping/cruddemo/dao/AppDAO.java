package com.advanced.mapping.cruddemo.dao;

import com.advanced.mapping.cruddemo.entity.Instructor;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
