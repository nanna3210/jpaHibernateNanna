package com.nanna.jpahibernate.repository;

import com.nanna.jpahibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class CourseRepository {
    
    
    private Logger logger = LoggerFactory.getLogger ( this.getClass () );
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
    
    
//    public List<Course> allCourse() {
//        em.find (  )
//    }
//
    public void deleteByid(Integer  id ) {
    
    
        Course course = findById ( id );
        em.remove ( course );
    
    }
    public void playWithEntityManager(){
        Course course1 = new Course ( "web services in depth" );
        em.persist ( course1 );
        
        
        
        Course course2 = new Course ( "Angular learned" );
        em.persist ( course2 );
        em.flush ();
        
        
        course2.setName ( "Angular learned updated" );
        em.refresh ( course1 );
    
    
    
        logger.info ( "play with Entity Manager " );
    }
    
    
    
}

