package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("")
	public ResponseEntity<Object> addPerson(@RequestBody Person person){
		try {
		pservice.addPerson(person);
		return new ResponseEntity<>(person,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
