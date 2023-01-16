package com.nanna.jpahibernate.repository;

import com.nanna.jpahibernate.JpahibernateApplication;
import com.nanna.jpahibernate.entity.Course;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
//import  org.junit.Test;

@SpringBootTest( classes =  JpahibernateApplication.class)
class CourseRepositoryTest {
    
    
    private Logger logger = LoggerFactory.getLogger ( this.getClass () );
    
    @Autowired
    CourseRepository courseRepository;
    @Test
    public void findByid() {
    
        Course course = courseRepository.findById ( 10001 );
        assertEquals ( "jPA LEArning" , course.getName ()) ;
    
    
    }
    @Test
    @DirtiesContext
    public void delete_byid( ) {
    
    
        courseRepository.deleteByid ( 10002 );
        assertNull ( courseRepository.findById ( 10002 ) );
    
    }
    
    @Test
    @DirtiesContext
    public void playWithEntitymanger() {
        
        courseRepository.playWithEntityManager ();
    }


    @Test
    @DirtiesContext
    @Transactional
    public void geteviews()
    {
        Course course = courseRepository.findById ( 2 );
        logger.info ( "get the reviews ", course.getReviews () );
    
    
    }
    
    
}