package com.restapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {

	 @Id
	 private Integer eno;
	 @Column
	 private String name;
	 @Column
	 private String role;
	 
	 @ManyToOne
	 @JoinColumn(name = "dno")
	 private Department dept;
	 
	 public Employee() {}
	 public Employee(Integer eno,String name,String role) {
		 this.eno=eno;
		 this.name=name;
		 this.role=role;
	 }
	 
	 public Integer getEno() {
		return eno;
	}
	 public String getName() {
		return name;
	}
	 public String getRole() {
		return role;
	}
	 public void setEno(Integer eno) {
		this.eno = eno;
	}
	 public void setName(String name) {
		this.name = name;
	}
	 public void setRole(String role) {
		this.role = role;
	}
	 
	 public Department getDept() {
		return dept;
	}
	 
	 public void setDept(Department dept) {
		this.dept = dept;
	}
	 
}
