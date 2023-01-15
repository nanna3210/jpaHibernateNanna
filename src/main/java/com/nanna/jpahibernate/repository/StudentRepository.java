package com.nanna.jpahibernate.repository;

import com.nanna.jpahibernate.entity.PassPort;
import com.nanna.jpahibernate.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {
    
    
    private Logger logger = LoggerFactory.getLogger ( this.getClass () );
    @Autowired
    EntityManager em;
    
    public Student findById(Integer  id ){
        Student student = em.find ( Student.class , id );
        return  student;
    
    }
    public Student save(Student student){
        if (student.getId ()==null) {
            em.persist ( student );
        }
        else {
    
            em.merge ( student );
        }
        return student;
    }
    
    
//    public List<Student> allStudent() {
//        em.find (  )
//    }
//
    public void deleteByid(Integer  id ) {
    
    
        Student student = findById ( id );
        em.remove ( student );
    
    }
    public void saveStudentWithPassPort(){
        PassPort passPort = new PassPort ("ABC1234");
        em.persist ( passPort );
        Student student = new Student ( "mike" );
        student.setPassPort ( passPort );
        em.persist ( student );
        logger.info ( "play with Entity Manager " );
    }
    
    

    
    
}

