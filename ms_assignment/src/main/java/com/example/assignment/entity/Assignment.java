package com.example.assignment.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Assignment {

    @Id
    @GeneratedValue
    private Long id;
    private boolean isValidate;
    private String reason;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String opinion;

    // Default constructor
    public Assignment() {

    }
}