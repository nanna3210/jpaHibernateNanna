package com.nanna.jpahibernate.entity;

import jakarta.persistence.*;

@Entity
public class Review {
    
    @Id
    @GeneratedValue
    private Long id;
    
    
    
    
    private String rating ;
    
    
    private String description;
    @ManyToOne
    private Course course;
    
    public Review() {
    
    }
    
    public Course getCourse ( ) {
        return course;
    }
    
    public void setCourse ( Course course ) {
        this.course = course;
    }
    
    public Long getId ( ) {
        
        return id;
    }
    
    public String getRating ( ) {
        return rating;
    }
    
    public void setRating ( String rating ) {
        this.rating = rating;
    }
    
    public Review ( String rating , String description ) {
        this.rating      = rating;
        this.description = description;
    }
    
    public String getDescription ( ) {
        return description;
    }
    
    public void setDescription ( String description ) {
        this.description = description;
    }
    
    @Override
    public String toString ( ) {
        return "Review{" + "id=" + id + ", rating='" + rating + '\'' + ", description='" + description + '\'' + '}';
    }
}
