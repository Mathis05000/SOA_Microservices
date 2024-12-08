package com.example.opinion.entity;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Opinion {

    @Id
    @GeneratedValue
    private Long id;
    private String opinion;
    private LocalDate date;

    public Opinion() {
    }

    public Opinion(String opinion) {
        this.opinion = opinion;
        this.date = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public String getOpinion() {
        return opinion;
    }

    public LocalDate getDate() {
        return date;
    }
}