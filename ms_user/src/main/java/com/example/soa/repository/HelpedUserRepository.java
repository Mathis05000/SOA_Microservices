package com.example.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.soa.entity.HelpedUser;

@Repository
public interface HelpedUserRepository extends JpaRepository<HelpedUser, Long> {
    
}