package com.example.opinion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.opinion.entity.VolunteerOpinion;

@Repository
public interface VolunteerOpinionRepository extends JpaRepository<VolunteerOpinion, Long> {

}