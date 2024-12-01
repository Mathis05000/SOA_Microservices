package com.example.soa.entity;

import jakarta.persistence.Entity;

@Entity
public class HelpedUser extends User {

    // Default constructor
    public HelpedUser() {
    }
    
    public HelpedUser(String firstName, String lastName) {
        super(firstName, lastName);
    }
}