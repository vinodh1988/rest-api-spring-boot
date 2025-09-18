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

import com.restapi.entities.Computer;
import com.restapi.service.ComputerService;
import com.restapi.util.RecordAlreadyExistsException;

@RestController
@RequestMapping("/api/computers")
public class ComputerAPI {
	@Autowired
	private ComputerService cservice;
	@GetMapping("")
	public List<Computer> getAll(){
		return cservice.getComputers();
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addComputer(@RequestBody Computer computer)throws RecordAlreadyExistsException
	{
     
          cservice.addComputer(computer);
          return new ResponseEntity<>(computer,HttpStatus.CREATED);
       
     }
	}


