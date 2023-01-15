package com.nanna.jpahibernate.repository;

import com.nanna.jpahibernate.entity.Course;
import com.nanna.jpahibernate.entity.Review;
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

    public void addReview() {
    
        Course course = findById ( 1 );
        logger.info ( "reviews  " , course.getReviews () );
    
        Review review = new Review ( "5" , "great content" );
        Review review2 = new Review ( "4" , "need more explanation with real world Example" );
        course.addReview ( review );
        review.setCourse ( course );
        course.addReview ( review2 );
        review2.setCourse ( course );
        em.persist ( review2 );
        em.persist ( review );
    
    }
    public void addReviews(Integer courseId, List<Review> reviews) {
        Course course = findById ( courseId );
        
        for ( Review review : reviews ) {
    
                course.addReview ( review );
                review.setCourse ( course );
                em.persist ( review );
            
        }
    }
    
}

