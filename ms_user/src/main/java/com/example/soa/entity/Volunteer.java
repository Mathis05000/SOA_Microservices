package com.example.soa.entity;

import jakarta.persistence.Entity;

@Entity
public class Volunteer extends User {

	// Default constructor
    public Volunteer() {
    }

    public Volunteer(String firstName, String lastName) {
        super(firstName, lastName);
    }
}