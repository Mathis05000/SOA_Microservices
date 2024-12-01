package com.example.soa.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class User {

    @Id
    @GeneratedValue
    private Long id;
    String firstName;
    String lastName;
    
    public User() {
    	
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return this.id;
    }
    
    public String getLastName() {
    	return this.lastName;
    }
    
    public String getFirstName() {
    	return this.firstName;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
}