package com.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entities.Department;
import com.restapi.entities.Employee;
import com.restapi.repository.DepartmentRepository;

@Service
public class DepartmentService {
  @Autowired
  private DepartmentRepository drepo;
  
  public List<Department> getDepartments(){
	  return drepo.findAll();
  }
  
  public void addDepartment(Department d) {
	  for(Employee e:d.getEmployees()) {
		  e.setDept(d);
	  }
	  drepo.save(d);
  }
}

