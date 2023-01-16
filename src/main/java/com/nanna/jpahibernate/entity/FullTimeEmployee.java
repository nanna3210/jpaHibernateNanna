package com.nanna.jpahibernate.entity;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

@Entity
public class FullTimeEmployee extends  Employee{
    
    
    
    private BigDecimal Salary;
    protected  FullTimeEmployee() {
    
    }
    
    public  FullTimeEmployee(String name , BigDecimal salary)
    {
        super(name);
        this.Salary = salary;
        
    }

}
