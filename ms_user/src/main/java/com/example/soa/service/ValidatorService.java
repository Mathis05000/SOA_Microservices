package com.example.soa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.soa.entity.Validator;
import com.example.soa.repository.ValidatorRepository;

@Service
public class ValidatorService {

    @Autowired 
    private ValidatorRepository validatorRepository;

    public List<Validator> list() {
        return validatorRepository.findAll();
    }

    public void add(Validator validator) {
        validatorRepository.save(validator);
    }

    public Validator find(Long id) {
        return validatorRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Validator with ID " + id + " not found"));
    }

    public void delete(Long id) {
        validatorRepository.deleteById(id);
    }

    public Validator modify(Validator validator) {
        return validatorRepository.save(validator);
    }

}