package com.nanna.jpahibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Employee {


    @Id
    @GeneratedValue
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    
    
    protected  Employee() {
    
    }
    
    public Employee ( String name ) {
        this.name = name;
    }
    
    public String getName ( ) {
        return name;
    }
    
    public void setName ( String name ) {
        this.name = name;
    }
    
    public Long getId ( ) {
        return id;
    }
    
    @Override
    public String toString ( ) {
        return "Employee{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
