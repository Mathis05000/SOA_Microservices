package com.example.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.soa.entity.Validator;
import com.example.soa.service.ValidatorService;

@RestController
@RequestMapping("/validator")
public class ValidatorController {

	@Autowired
	private ValidatorService validatorService;
	
	@GetMapping
	public List<Validator> getVolunteers() {
		return validatorService.list();
    }

	@PostMapping
	public void createVolunteer(@RequestBody Validator validator) {
		validatorService.add(validator);
	}

	@GetMapping("/{id}")
    public Validator findValidator(@PathVariable Long id) {
        return validatorService.find(id);
    }

	@DeleteMapping("/{id}")
    public void deleteValidator(@PathVariable Long id) {
        validatorService.delete(id);
    }

	@PutMapping
    public Validator modifyValidator(@RequestBody Validator validator) {
        return validatorService.modify(validator);
    }

}