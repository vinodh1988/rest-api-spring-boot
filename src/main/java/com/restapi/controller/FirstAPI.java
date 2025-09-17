package com.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/first")
public class FirstAPI {
  
	@GetMapping("")
	public String first() {
		return "First Rest API";
	}
}

/*
Controller method is
expected to return String
or ModelandView object
which means it returns view details

RestController methods
is expected to return any 
form of data (string,list,binary...)
(rest apis return data in any representational
format)
*/