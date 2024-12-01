package com.example.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.soa.entity.Validator;

@Repository
public interface ValidatorRepository extends JpaRepository<Validator, Long> {
    
}