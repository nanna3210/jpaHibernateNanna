package com.nanna.jpahibernate.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String line1;
    private String colony;
    private String city ;
    
    public Address() {
    
    }
    public Address ( String line1 , String colony , String city ) {
        this.line1  = line1;
        this.colony = colony;
        this.city   = city;
    }
}
