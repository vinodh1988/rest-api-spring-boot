package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entities.Computer;
import com.restapi.service.ComputerService;
import com.restapi.util.RecordAlreadyExistsException;
import com.restapi.util.RecordNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/computers")
@Tag(name = "Computer API", description="All the operations of Project entity")
public class ComputerAPI {
	@Autowired
	private ComputerService cservice;
	@GetMapping("")
	public List<Computer> getAll(
			@RequestParam(required = false) Integer min,
			@RequestParam(required = false) Integer max
			){
		if(max==null && min==null)
				return cservice.getComputers();
		else if(max==null )
			    return cservice.getComputers(min,Integer.MAX_VALUE);
		else if(min==null)
			    return cservice.getComputers(Integer.MIN_VALUE,max);
		else
			    return cservice.getComputers(min,max);
	}
	@Operation(
			   summary="Get Computer by cno",
			   description="Get Computer by passing cno "
			)
			@ApiResponses(
				 value = {
						 @ApiResponse(responseCode="200", description=":Computer found with given cno"),
						 @ApiResponse(responseCode="400", description="if No Computer exists with given cno"),
						 @ApiResponse(responseCode="500", description="Server related error")
				 }	
				)
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
	
	@DeleteMapping("{cno}")
	public ResponseEntity<Object> deleteComputer(@PathVariable Integer cno) throws RecordNotFoundException
	{
		cservice.deleteComputer(cno);
		return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
	}
	
}


