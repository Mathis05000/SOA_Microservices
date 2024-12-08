package com.example.opinion.entity;

import com.example.opinion.entity.user.Volunteer;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class VolunteerOpinion extends Opinion {

    @OneToOne
    private Volunteer volunteer;

    public VolunteerOpinion() {
        
    }

    public VolunteerOpinion(String opinion, Volunteer volunteer) {
        super(opinion);
        this.volunteer = volunteer;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }
}