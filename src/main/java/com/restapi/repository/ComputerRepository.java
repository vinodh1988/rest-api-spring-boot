package com.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.entities.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer>{
  public Computer  findByCno(Integer cno); //no need for definition
                                         // taken care by datajpa
 // public List<Computer> findByBrand(String brand);
}
