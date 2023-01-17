package com.nanna.jpahibernate.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Cacheable
@SQLDelete ( sql = "update course set is_deleted =true where id =?")
@Where ( clause = "is_deleted = false")
public class Course {


    @Id
    @GeneratedValue
    private Integer id;
    
    @Column (name = "fullName" , nullable = false)
    private String name;
    @ManyToMany(mappedBy = "courses")
   
    private List < Student > students = new ArrayList <> ();
    @UpdateTimestamp
    private LocalDate updatedTime;
    @CreationTimestamp
    private LocalDate createdTime;
    private boolean isDeleted;
    
    public List < Review > getReviews ( ) {
        return reviews;
    }
    
    public void addReview (Review  review ) {
        this.reviews.add ( review );
    }
    public void removeReview (Review  review ) {
        this.reviews.remove ( review );
    }
    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList <> (  );
    
    
    public  Course( ) {
    
    }
    
    public List < Student > getStudents ( ) {
        return students;
    }
    
    public void setStudents ( Student  student ) {
        this.students.add ( student );
    }
    
    public Course ( String name ) {
        this.name = name;
    }
    
    public String getName ( ) {
        return name;
    }
    
    public void setName ( String name ) {
        this.name = name;
    }
    
    public Integer getId ( ) {
        return id;
    }
    
    @Override
    public String toString ( ) {
        return " \n Course{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
