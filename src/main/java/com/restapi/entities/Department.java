package com.restapi.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="departments")
public class Department {

	@Id
	 private Integer dno;
	@Column
	 private String dname;
	@OneToMany(mappedBy="dept",cascade = CascadeType.ALL)
	 Set<Employee> employees;
	
	
	 public Department() {}
	 
	 public Department(Integer dno,String dname) {
		 this.dno=dno;
		 this.dname=dname;
	 }
	 
	 public String getDname() {
		return dname;
	}
	 public void setDname(String dname) {
		this.dname = dname;
	}
	 public Integer getDno() {
		return dno;
	}
	 public void setDno(Integer dno) {
		this.dno = dno;
	}
	 
	 public Set<Employee> getEmployees() {
		return employees;
	}
	 public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	 
}
