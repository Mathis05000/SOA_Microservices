package com.example.opinion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.opinion.entity.HelpedUserOpinion;
import com.example.opinion.repository.HelpedUserOpinionRepository;

@Service
public class HelpedUserOpinionService {

    @Autowired
    private HelpedUserOpinionRepository helpedUserOpinionRepository;

    public List<HelpedUserOpinion> list() {
        return helpedUserOpinionRepository.findAll();
    }

    public void add(HelpedUserOpinion helpedUserOpinion) {
        helpedUserOpinionRepository.save(helpedUserOpinion);
    }

    public HelpedUserOpinion find(Long id) {
        return helpedUserOpinionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "HelpedUserOpinion with ID " + id + " not found"));
    }

    public void delete(Long id) {
        helpedUserOpinionRepository.deleteById(id);
    }

    public HelpedUserOpinion modify(HelpedUserOpinion helpedUserOpinion) {
        return helpedUserOpinionRepository.save(helpedUserOpinion);
    }
}