package com.nanna.jpahibernate;

import com.nanna.jpahibernate.entity.Course;
import com.nanna.jpahibernate.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpahibernateApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger ( this.getClass () );
	@Autowired
	CourseRepository courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpahibernateApplication.class, args);
	}
	
	@Override
	public void run ( String... args ) throws Exception {
		
		Course course = courseRepository.findById ( 10001 );
		logger.info ( "course 10001 ->{}",course );
//		logger.info ( "course 10001 ->{}",courseRepository.deleteByid ( 10002 ) );
//		courseRepository.deleteByid ( 10002 );
	}
}
