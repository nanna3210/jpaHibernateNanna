package com.nanna.jpahibernate.repository;

import com.nanna.jpahibernate.JpahibernateApplication;
import com.nanna.jpahibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.hibernate.query.sqm.internal.SqmCriteriaNodeBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
//import  org.junit.Test;

@SpringBootTest( classes =  JpahibernateApplication.class)
class CriteriaTest {
    
    
    private Logger logger = LoggerFactory.getLogger ( this.getClass () );
    
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    EntityManager em;

    @Test
    public void  allCourseHavingDomething() {
    
        CriteriaBuilder cb = em.getCriteriaBuilder ();
        CriteriaQuery < Course > query = cb.createQuery ( Course.class );
    
        Root < Course > courseRoot = query.from ( Course.class );
    
        Predicate predicate = cb.like ( courseRoot.get ( "name" ) , "%updated" );
        query.where ( predicate );
    
        TypedQuery < Course > emQuery = em.createQuery ( query.select ( courseRoot ) );
        List < Course >       resultList = emQuery.getResultList ();
        logger.info ( "course that are updated -> {}", resultList );
    }
    
}