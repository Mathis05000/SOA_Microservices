package com.example.assignment.entity.assignment;

import com.example.assignment.entity.Status;
import com.example.assignment.entity.user.HelpedUser;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class ClassicAssignment extends Assignment {

    @OneToOne
    private HelpedUser helpedUser;

    // Default constructor
    public ClassicAssignment() {

    }

    public ClassicAssignment(String description, boolean isValidate, String reason, Status status, String opinion, HelpedUser helpedUser) {
        super(description, isValidate, reason, status, opinion);
        this.helpedUser = helpedUser;
    }

    public ClassicAssignment(Long id, String description, boolean isValidate, String reason, Status status, String opinion, HelpedUser helpedUser) {
        super(id, description, isValidate, reason, status, opinion);
        this.helpedUser = helpedUser;
    }

    public HelpedUser getHelpedUser() {
        return helpedUser;
    }


}
