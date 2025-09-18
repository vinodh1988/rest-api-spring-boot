package com.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entities.Department;
import com.restapi.repository.DepartmentRepository;

@Service
public class DepartmentService {
  @Autowired
  private DepartmentRepository drepo;
  
  public List<Department> getDepartments(){
	  return drepo.findAll();
  }
}

