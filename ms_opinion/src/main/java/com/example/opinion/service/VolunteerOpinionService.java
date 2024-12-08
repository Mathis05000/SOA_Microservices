package com.example.opinion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.opinion.entity.VolunteerOpinion;
import com.example.opinion.repository.VolunteerOpinionRepository;

@Service
public class VolunteerOpinionService {

    @Autowired
    private VolunteerOpinionRepository volunteerOpinionRepository;

    public List<VolunteerOpinion> list() {
        return volunteerOpinionRepository.findAll();
    }

    public void add(VolunteerOpinion volunteerOpinion) {
        volunteerOpinionRepository.save(volunteerOpinion);
    }

    public VolunteerOpinion find(Long id) {
        return volunteerOpinionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "VolunteerOpinion with ID " + id + " not found"));
    }

    public void delete(Long id) {
        volunteerOpinionRepository.deleteById(id);
    }

    public VolunteerOpinion modify(VolunteerOpinion volunteerOpinion) {
        return volunteerOpinionRepository.save(volunteerOpinion);
    }
}