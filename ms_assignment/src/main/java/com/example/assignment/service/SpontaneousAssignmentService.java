package com.example.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.assignment.entity.Status;
import com.example.assignment.entity.assignment.ClassicAssignment;
import com.example.assignment.entity.assignment.SpontaneousAssignment;
import com.example.assignment.repository.SpontaneousAssignmentRepository;

@Service
public class SpontaneousAssignmentService {

    @Autowired
    private SpontaneousAssignmentRepository spontaneousAssignmentRepository;

    public List<SpontaneousAssignment> list() {
        return spontaneousAssignmentRepository.findAll();
    }

    public void add(SpontaneousAssignment spontaneousAssignment) {
        spontaneousAssignmentRepository.save(spontaneousAssignment);
    }

    public SpontaneousAssignment find(Long id) {
        return spontaneousAssignmentRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SpontaneousAssignment with ID " + id + " not found"));
    }

    public void delete(Long id) {
        spontaneousAssignmentRepository.deleteById(id);
    }

    public SpontaneousAssignment modify(SpontaneousAssignment spontaneousAssignment) {
        return spontaneousAssignmentRepository.save(spontaneousAssignment);
    }

    public void validateAssignment(Long idAssignment, Long idValidator) {
        SpontaneousAssignment spontaneousAssignment = this.find(idAssignment);
        spontaneousAssignment.setIdValidator(idValidator);
        spontaneousAssignment.setStatus(Status.VALIDATED);
        spontaneousAssignment.setValidate(true);
        spontaneousAssignmentRepository.save(spontaneousAssignment);
    }

    public void unvalidateAssignment(Long idAssignment, Long idValidator, String reason) {
        SpontaneousAssignment spontaneousAssignment = this.find(idAssignment);
        spontaneousAssignment.setIdValidator(idValidator);
        spontaneousAssignment.setStatus(Status.UNVALIDATED);
        spontaneousAssignment.setValidate(false);
        spontaneousAssignment.setReason(reason);
        spontaneousAssignmentRepository.save(spontaneousAssignment);
    }
}