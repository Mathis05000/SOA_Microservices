package com.example.soa.entity;

import jakarta.persistence.Entity;

@Entity
public class Validator extends User {

    // Default constructor
    public Validator() {
    }
    
    public Validator(String firstName, String lastName) {
        super(firstName, lastName);
    }
}