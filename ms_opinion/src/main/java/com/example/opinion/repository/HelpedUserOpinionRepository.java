package com.example.opinion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.opinion.entity.HelpedUserOpinion;

@Repository
public interface HelpedUserOpinionRepository extends JpaRepository<HelpedUserOpinion, Long> {

}
