package com.example.assignment.entity.assignment;

import com.example.assignment.entity.Status;

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
    private String description;
    private boolean isValidate;
    private String reason;

    @Enumerated(EnumType.STRING)
    private Status status;
    private String opinion;
    private Long idValidator;

    public Assignment(String description, boolean isValidate, String reason, Status status, String opinion) {
        this.description = description;
        this.isValidate = isValidate;
        this.reason = reason;
        this.status = status;
        this.opinion = opinion;
    }

    public Assignment(Long id, String description, boolean isValidate, String reason, Status status, String opinion) {
        this.id = id;
        this.description = description;
        this.isValidate = isValidate;
        this.reason = reason;
        this.status = status;
        this.opinion = opinion;
    }

    // Default constructor
    public Assignment() {

    }

    // Getters
    public Long getId() {
        return id;
    }

    public boolean isValidate() {
        return isValidate;
    }

    public String getReason() {
        return reason;
    }

    public Status getStatus() {
        return status;
    }

    public String getOpinion() {
        return opinion;
    }

    public Long getIdValidator() {
        return idValidator;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setIdValidator(Long idValidator) {
        this.idValidator = idValidator;
    }

    public void setValidate(boolean isValidate) {
        this.isValidate = isValidate;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}