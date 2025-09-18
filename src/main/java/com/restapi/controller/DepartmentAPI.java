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

import com.restapi.entities.Department;
import com.restapi.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentAPI {
	
	@Autowired
	private DepartmentService dservice;
	
	@GetMapping("")
	public List<Department> getDepartments(){
		return dservice.getDepartments();
	}

	@PostMapping("")
	public ResponseEntity<Object> addDepartment(@RequestBody Department department)
	{
		dservice.addDepartment(department);
		return new ResponseEntity<>(department,HttpStatus.CREATED);
	}
}
