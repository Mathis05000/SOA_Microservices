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

import com.example.soa.entity.Volunteer;
import com.example.soa.service.VolunteerService;

@RestController
@RequestMapping("/volunteer")
public class VolunteerController {

	@Autowired
	private VolunteerService volunteerService;
	
	@GetMapping
	public List<Volunteer> getVolunteers() {
		return volunteerService.list();
    }

	@PostMapping
	public void createVolunteer(@RequestBody Volunteer volunteer) {
		volunteerService.add(volunteer);
	}

	@GetMapping("/{id}")
    public Volunteer findVolunteer(@PathVariable Long id) {
        return volunteerService.find(id);
    }

	@DeleteMapping("/{id}")
    public void deleteVolunteer(@PathVariable Long id) {
        volunteerService.delete(id);
    }

	@PutMapping
    public Volunteer modifyVolunteer(@RequestBody Volunteer volunteer) {
        return volunteerService.modify(volunteer);
    }

}