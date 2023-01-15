package com.nanna.jpahibernate.repository;

import com.nanna.jpahibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {
    
    @Autowired
    EntityManager em;
    
    public Course findById(Integer  id ){
        Course course = em.find ( Course.class , id );
        return  course;
    
    }
    public Course save(Course course){
        if (course.getId ()==null) {
            em.persist ( course );
        }
        else {
    
            em.merge ( course );
        }
        return course;
    }
    
    public void deleteByid(Integer  id ) {
    
    
        Course course = findById ( id );
        em.remove ( course );
    
    }
    
    
    
}

