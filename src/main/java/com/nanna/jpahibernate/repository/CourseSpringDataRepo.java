package com.nanna.jpahibernate.repository;

import com.nanna.jpahibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@RepositoryRestResource(path = "courses")
public interface CourseSpringDataRepo extends JpaRepository< Course,Integer > {
    
    
    List < Course > findByName ( String name );
    
    List < Course > findByNameAndId ( String name , Integer id );
    
    List < Course > countByName ( String name );
    
    List < Course > countByNameOrderByIdDesc ( String name );
    
    List < Course > deleteById ( String name );
    

    
    


}
