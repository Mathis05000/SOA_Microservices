package com.example.soa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.soa.entity.Volunteer;
import com.example.soa.repository.VolunteerRepository;

@Service
public class VolunteerService {

    @Autowired 
    private VolunteerRepository volunteerRepository;

    public List<Volunteer> list() {
        return volunteerRepository.findAll();
    }

    public void add(Volunteer volunteer) {
        volunteerRepository.save(volunteer);
    }

    public Volunteer find(Long id) {
        return volunteerRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Volunteer with ID " + id + " not found"));
    }

    public void delete(Long id) {
        volunteerRepository.deleteById(id);
    }

    public Volunteer modify(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

}