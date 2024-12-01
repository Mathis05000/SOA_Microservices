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

import com.example.soa.entity.HelpedUser;
import com.example.soa.service.HelpedUserService;

@RestController
@RequestMapping("/helpeduser")
public class HelpedUserController {

	@Autowired
	private HelpedUserService helpedUserService;
	
	@GetMapping
	public List<HelpedUser> getHelpedUser() {
		return helpedUserService.list();
    }

	@PostMapping
	public void createHelpedUser(@RequestBody HelpedUser helpedUser) {
		helpedUserService.add(helpedUser);
	}

    @GetMapping("/{id}")
    public HelpedUser findHelpedUser(@PathVariable Long id) {
        return helpedUserService.find(id);
    }

    @DeleteMapping("/{id}")
    public void deleteHelpedUser(@PathVariable Long id) {
        helpedUserService.delete(id);
    }

    @PutMapping
    public HelpedUser modifyHelpedUser(@RequestBody HelpedUser helpedUser) {
        return helpedUserService.modify(helpedUser);
    }

}