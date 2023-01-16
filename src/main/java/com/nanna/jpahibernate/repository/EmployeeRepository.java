package com.nanna.jpahibernate.repository;

import com.nanna.jpahibernate.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Transactional
public class EmployeeRepository {
    
    
    private Logger logger = LoggerFactory.getLogger ( this.getClass () );
    @Autowired
    EntityManager entityManager;
    
//    insert Employee
    
    public void insert( Employee employee) {
            entityManager.persist ( employee );
    }
    
    public List <Employee> retrieveEmployees() {
        List < Employee > employees =
                entityManager.createQuery ( "select e from Employee e" , Employee.class ).getResultList ();
    
        return employees;
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
