package com.nanna.jpahibernate.repository;

import com.nanna.jpahibernate.JpahibernateApplication;
import com.nanna.jpahibernate.entity.PassPort;
import com.nanna.jpahibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest ( classes =  JpahibernateApplication.class)
class StudentRepositoryTest {
    private Logger logger = LoggerFactory.getLogger ( this.getClass () );
    @Autowired
    StudentRepository studentRepository;
    
    @Autowired
    EntityManager em;
    
    
    @Test
    @Transactional
    public void retrievePassportandAssociatedStudent() {

        PassPort passPort = em.find ( PassPort.class , 40001 );
        logger.info ( "student by id {} -> ", passPort );
        logger.info ( "passport by student  by  {} -> ", passPort.getStudent () );



    }
    @Test
    @Transactional
    public void retrievestudentAndCourse() {
    
        Student student = em.find ( Student.class , 20001 );
        
        
        logger.info ( "student by id {} -> ", student );
        logger.info ( "courses  by student  by  {} -> ",student.getCourses () );
        
        
        
    }
    
    
    
    
}