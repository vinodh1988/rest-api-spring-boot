package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entities.Computer;
import com.restapi.service.ComputerService;
import com.restapi.util.RecordAlreadyExistsException;
import com.restapi.util.RecordNotFoundException;

@RestController
@RequestMapping("/api/computers")
public class ComputerAPI {
	@Autowired
	private ComputerService cservice;
	@GetMapping("")
	public List<Computer> getAll(){
		return cservice.getComputers();
	}
	
	@GetMapping("/{cno}")
	public ResponseEntity<Object> getPerson(@PathVariable Integer cno) throws RecordNotFoundException
	{
		return new ResponseEntity<>(cservice.getComputer(cno),HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addComputer(@RequestBody Computer computer) throws RecordAlreadyExistsException
	{
     
          cservice.addComputer(computer);
          return new ResponseEntity<>(computer,HttpStatus.CREATED);
       
     }
	
	@RequestMapping(value="",method= {RequestMethod.PATCH,RequestMethod.PUT})
	public ResponseEntity<Object> updateComputer(@RequestBody Computer computer) throws
	RecordNotFoundException,IllegalArgumentException
	{
		if(computer.getCno()==null)
			throw new IllegalArgumentException();
		cservice.updateComputer(computer);
		return new ResponseEntity<>("Successfully updated",HttpStatus.OK);
	}
	}


