package com.nanna.jpahibernate.repository;

import com.nanna.jpahibernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CourseSpringDataRepo extends JpaRepository< Course,Integer > {

    
    


}
