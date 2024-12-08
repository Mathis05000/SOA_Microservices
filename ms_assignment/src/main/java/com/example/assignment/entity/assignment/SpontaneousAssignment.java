package com.example.assignment.entity.assignment;

import com.example.assignment.entity.Status;
import com.example.assignment.entity.user.Volunteer;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class SpontaneousAssignment extends Assignment {

    @OneToOne
    private Volunteer volunteer;

    // Default constructor
    public SpontaneousAssignment() {

    }

    public SpontaneousAssignment(String description, boolean isValidate, String reason, Status status, String opinion, Volunteer volunteer) {
        super(description, isValidate, reason, status, opinion);
        this.volunteer = volunteer;
    }

    public SpontaneousAssignment(Long id, String description, boolean isValidate, String reason, Status status, String opinion, Volunteer volunteer) {
        super(id, description,  isValidate, reason, status, opinion);
        this.volunteer = volunteer;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }
}
