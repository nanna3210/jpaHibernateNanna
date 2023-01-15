package com.nanna.jpahibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PassPort {


    
    @Id
    @GeneratedValue
    private Long  id;
    @Column(nullable = false)
    private String  number ;
    
    
    PassPort() {
    
    
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
