package com.nanna.jpahibernate;

import com.nanna.jpahibernate.entity.Course;
import com.nanna.jpahibernate.entity.Review;
import com.nanna.jpahibernate.repository.CourseRepository;
import com.nanna.jpahibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpahibernateApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger ( this.getClass () );
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpahibernateApplication.class, args);
	}
	
	@Override
	public void run ( String... args ) throws Exception {
		
//		Course course = courseRepository.findById (  10001 );
//		logger.info ( "course 10001 ->{}",course );
//		logger.info ( "course 10001 ->{}",courseRepository.deleteByid ( 10002 ) );
//		courseRepository.deleteByid ( 10002 );
//		logger.info ( "course 10001->{}",courseRepository.save ( new Course ( "Microservices" ) ) );
		studentRepository.saveStudentWithPassPort ();
		courseRepository.addReview ();
		
		List < Review > reviews = new ArrayList <> ();
		Review review = new Review ( "4" , "great" );
		Review review1 = new Review ( "5" , "awsome yp boyyy ! " );
		
		reviews.add ( review1 );
		
		reviews.add ( review );
		
		courseRepository.addReviews ( 2, reviews );

	}
}
