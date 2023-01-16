package com.nanna.jpahibernate.repository;

import com.nanna.jpahibernate.JpahibernateApplication;
import com.nanna.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest ( classes =  JpahibernateApplication.class)
class CourseSpringDataRepoTest {
    
    
    
    private final Logger logger = LoggerFactory.getLogger ( this.getClass () );
    
    @Autowired
    CourseSpringDataRepo courseSpringDataRepo;
    
    @Test
    public void findById() {
    
        Optional < Course > courseById = courseSpringDataRepo.findById ( 252 );
//        logger.info ( "{}", courseById.isPresent () );
        assertTrue ( courseById.isPresent () );
        
    }
    @Test
    public void findByIdNotPresent() {
        
        Optional < Course > courseById = courseSpringDataRepo.findById ( 5 );
//        logger.info ( "{}", courseById.isPresent () );
        assertFalse ( courseById.isPresent () );
        
    }
    
    @Test
    public void playingWithJpaSpringdata() {
    
//        Course course = new Course ( "fullstack Building with spring boot and Angular" );
//        courseSpringDataRepo.save ( course );
//        course.setName ( "fullstack Building with spring boot and Angular 14" );
//        courseSpringDataRepo.save ( course );
//
    
//        Sort sort = Sort.by ( Sort.Direction.DESC , new String[]{"name"});
    
        Sort descSorting = Sort.by ( "name" ).descending ();
        List < Course > allCourses = courseSpringDataRepo.findAll ( descSorting );
    
        Sort sortingByParams = Sort.by ( List.of ( new Sort.Order ( Sort.Direction.DESC , "name" ) , new Sort.Order ( Sort.Direction.DESC , "id" )
    
        ) );
        List < Course > allcourseesByparam = courseSpringDataRepo.findAll ( sortingByParams );
    
    
        //        logger.info ( "all courses " , courseSpringDataRepo.findAll () );
//        logger.info ( "all courses count  " , courseSpringDataRepo.count () );
//        System.out.println (courseSpringDataRepo.findAll ());
        System.out.println (allcourseesByparam);
   
    }
    
    @Test
    public void  pagination(){
    
        PageRequest pageRequest = PageRequest.of ( 0 , 4 );
        Page < Course > firstPage     = courseSpringDataRepo.findAll ( pageRequest );
        System.out.println ("______________________");
        System.out.println (firstPage.getContent ());
        System.out.println ("________________________ 2nd page ");
        Pageable secondPage = firstPage.nextPageable ();
        Page < Course > secondPageData = courseSpringDataRepo.findAll ( secondPage );
        System.out.println (secondPageData.getContent ());
    }
    
}