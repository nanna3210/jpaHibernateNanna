package com.nanna.jpahibernate.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity

public class Course {


    @Id
    @GeneratedValue
    private Integer id;
    
    @Column (name = "fullName" , nullable = false)
    private String name;
    
    
    @UpdateTimestamp
    private LocalDate updatedTime;
    @CreationTimestamp
    private LocalDate createdTime;
    
    
    protected Course( ) {
    
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
