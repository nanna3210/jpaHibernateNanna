package com.nanna.jpahibernate.entity;

import jakarta.persistence.*;

@Entity
public class PassPort {


    
    @Id
    @GeneratedValue
    private Long  id;
    @Column(nullable = false)
    private String  number ;
    
    @OneToOne ( fetch = FetchType.LAZY, mappedBy = "passPort")
    private Student student;
    
    
    PassPort() {
    
    
    }
    
    
    public Student getStudent ( ) {
        return student;
    }
    
    public void setStudent ( Student student ) {
        this.student = student;
    }
    
    public PassPort ( String number ) {
        this.number = number;
    }
    
    public Long getId ( ) {
        return id;
    }
    
    public String getNumber ( ) {
        return number;
    }
    
    public void setNumber ( String number ) {
        this.number = number;
    }
    
    @Override
    public String toString ( ) {
        return "PassPort{" + "id=" + id + ", number='" + number + '\'' + '}';
    }
}
