package com.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.entities.Computer;
import com.restapi.service.ComputerService;

@RestController
@RequestMapping("/api/computers")
public class ComputerAPI {
	@Autowired
	private ComputerService cservice;
	@GetMapping("")
	public List<Computer> getAll(){
		return cservice.getComputers();
	}

}
