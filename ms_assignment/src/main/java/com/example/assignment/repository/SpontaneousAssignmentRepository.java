package com.example.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.assignment.entity.assignment.SpontaneousAssignment;

@Repository
public interface SpontaneousAssignmentRepository extends JpaRepository<SpontaneousAssignment, Long> {

}