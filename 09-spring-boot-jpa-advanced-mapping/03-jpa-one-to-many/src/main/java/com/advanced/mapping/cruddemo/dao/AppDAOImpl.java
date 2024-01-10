package com.advanced.mapping.cruddemo.dao;

import com.advanced.mapping.cruddemo.entity.Course;
import com.advanced.mapping.cruddemo.entity.Instructor;
import com.advanced.mapping.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id=:data", Course.class);
        query.setParameter("data",id);
        List<Course> courses= query.getResultList();
        return  courses;
    }

    @Override
    public Instructor findInstructorByIdWithCoursesJoinFetch(int id) {
        TypedQuery<Instructor> query=entityManager.createQuery("select i from Instructor  i " +
                "JOIN FETCH i.courses " +
                "JOIN FETCH i.instructorDetail " +
                "where i.id=:data", Instructor.class);
        query.setParameter("data",id);
        Instructor instructor= query.getSingleResult();
        return  instructor;
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor theInstructor) {
        entityManager.merge(theInstructor);

    }

    @Override
    @Transactional
    public void updateCourse(Course theCourse) {
        entityManager.merge(theCourse);

    }

    @Override
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
    }
}
