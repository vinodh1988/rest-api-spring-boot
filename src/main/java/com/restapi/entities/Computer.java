package com.restapi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="computers")
public class Computer {
 @Id
  private Integer cno;
 @Column
  private String brand;
 @Column
  private String cpu;
 @Column
  private String ram;
 @Column
  private String disk;
  
public Computer() {}

public Computer(Integer cno, String brand, String cpu, String ram, String disk) {
	super();
	this.cno = cno;
	this.brand = brand;
	this.cpu = cpu;
	this.ram = ram;
	this.disk = disk;
}

public Integer getCno() {
	return cno;
}

public void setCno(Integer cno) {
	this.cno = cno;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

public String getCpu() {
	return cpu;
}

public void setCpu(String cpu) {
	this.cpu = cpu;
}

public String getRam() {
	return ram;
}

public void setRam(String ram) {
	this.ram = ram;
}

public String getDisk() {
	return disk;
}

public void setDisk(String disk) {
	this.disk = disk;
}
  

  
}
