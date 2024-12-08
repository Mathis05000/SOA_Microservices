package com.example.opinion.entity;

import com.example.opinion.entity.user.HelpedUser;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class HelpedUserOpinion extends Opinion {

    @OneToOne
    private HelpedUser helpedUser;

    public HelpedUserOpinion() {
    }
    
    public HelpedUserOpinion(String opinion, HelpedUser helpedUser) {
        super(opinion);
        this.helpedUser = helpedUser;
    }

    public HelpedUser getHelpedUser() {
        return helpedUser;
    }
}