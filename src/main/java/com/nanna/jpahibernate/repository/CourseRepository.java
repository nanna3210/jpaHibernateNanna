package com.nanna.jpahibernate.repository;

import com.nanna.jpahibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
    
    @Autowired
    EntityManager em;
    
    public Course findById(int id ){
        Course course = em.find ( Course.class , id );
        return  course;
    
    }
//    public Course save(Course course){
//
//    }
    
    public void deleteByid() {
    
    }
    
    
    
}

