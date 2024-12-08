package com.example.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.assignment.entity.Status;
import com.example.assignment.entity.assignment.ClassicAssignment;
import com.example.assignment.entity.assignment.SpontaneousAssignment;
import com.example.assignment.repository.ClassicAssignmentRepository;

@Service
public class ClassicAssignmentService {

    @Autowired
    private ClassicAssignmentRepository classicAssignmentRepository;

    public List<ClassicAssignment> list() {
        return classicAssignmentRepository.findAll();
    }

    public void add(ClassicAssignment classicAssignment) {
        classicAssignmentRepository.save(classicAssignment);
    }

    public ClassicAssignment find(Long id) {
        return classicAssignmentRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "classicAssignment with ID " + id + " not found"));
    }

    public void delete(Long id) {
        classicAssignmentRepository.deleteById(id);
    }

    public ClassicAssignment modify(ClassicAssignment classicAssignment) {
        return classicAssignmentRepository.save(classicAssignment);
    }

    public void validateAssignment(Long idAssignment, Long idValidator) {
        ClassicAssignment classicAssignment = this.find(idAssignment);
        classicAssignment.setIdValidator(idValidator);
        classicAssignment.setStatus(Status.VALIDATED);
        classicAssignment.setValidate(true);
        classicAssignmentRepository.save(classicAssignment);
    }

    public void unvalidateAssignment(Long idAssignment, Long idValidator, String reason) {
        ClassicAssignment classicAssignment = this.find(idAssignment);
        classicAssignment.setIdValidator(idValidator);
        classicAssignment.setStatus(Status.UNVALIDATED);
        classicAssignment.setValidate(false);
        classicAssignment.setReason(reason);
        classicAssignmentRepository.save(classicAssignment);
    }
}