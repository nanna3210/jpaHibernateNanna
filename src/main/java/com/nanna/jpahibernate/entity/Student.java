package com.nanna.jpahibernate.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Student {



    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String name ;
    
    @OneToOne(fetch = FetchType.LAZY )
    private PassPort passPort;
    
    public Integer getId ( ) {
        return id;
    }
    
    public PassPort getPassPort ( ) {
        return passPort;
    }
    
    public void setPassPort ( PassPort passPort ) {
        this.passPort = passPort;
    }
    
    public String getName ( ) {
        return name;
    }
    
    public void setName ( String name ) {
        this.name = name;
    }
    Student() {
    
    }
    
    public Student ( String name ) {
        this.name = name;
    }
    
    @Override
    public String toString ( ) {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
