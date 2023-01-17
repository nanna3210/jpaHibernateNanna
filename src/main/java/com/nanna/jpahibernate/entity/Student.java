package com.nanna.jpahibernate.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {



    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String name ;
    
    @OneToOne(fetch = FetchType.LAZY )
    private PassPort passPort;
    
    @Embedded
    private Address address;
    
    
    
    @ManyToMany
    @JoinTable(name = "student_course" ,
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List < Course > courses =new ArrayList <> ();
    
    public Integer getId ( ) {
        return id;
    }
    
    
    public Address getAddress ( ) {
        return address;
    }
    
    public void setAddress ( Address address ) {
        this.address = address;
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
    
    public List < Course > getCourses ( ) {
        return courses;
    }
    
    public void addCourse ( Course  course ) {
        this.courses.add ( course );
    }
    
    public Student() {
    
    }
    
    
    public Student ( String name ) {
        this.name = name;
    }
    
    @Override
    public String toString ( ) {
        return "Student{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
