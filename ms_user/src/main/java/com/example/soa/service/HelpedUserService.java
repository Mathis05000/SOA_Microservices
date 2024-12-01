package com.example.soa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.soa.entity.HelpedUser;
import com.example.soa.repository.HelpedUserRepository;

@Service
public class HelpedUserService {

    @Autowired
    private HelpedUserRepository helpedUserRepository;

    public List<HelpedUser> list() {
        return helpedUserRepository.findAll();
    }

    public void add(HelpedUser helpedUser) {
        helpedUserRepository.save(helpedUser);
    }

    public HelpedUser find(Long id) {
        return helpedUserRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "HelpedUser with ID " + id + " not found"));
    }

    public void delete(Long id) {
        helpedUserRepository.deleteById(id);
    }

    public HelpedUser modify(HelpedUser helpedUser) {
        return helpedUserRepository.save(helpedUser);
    }

}