package com.nanna.jpahibernate.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class Student {



    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String name ;
    
    
    public Integer getId ( ) {
        return id;
    }
    
    
    public String getName ( ) {
        return name;
    }
    
    public void setName ( String name ) {
        this.name = name;
    }
    Student() {
    
    }
    
    @Override
    public String toString ( ) {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
