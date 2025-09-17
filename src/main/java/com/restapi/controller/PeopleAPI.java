package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entities.Person;
import com.restapi.service.PersonService;

@RestController
@RequestMapping("/api/people")
public class PeopleAPI {
	
	@Autowired
	private PersonService pservice;
	@GetMapping("")
	public List<Person> getPeople(){
	  return pservice.getPeople();	
	}

}
