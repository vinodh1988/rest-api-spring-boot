package com.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.restapi.entities.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer>{
  public Computer  findByCno(Integer cno); //no need for definition
                                         // taken care by datajpa
  
  @Query("SELECT c from Computer c where cno between :min and :max")
  public List<Computer> findByCnoRange(@Param("min") Integer min,@Param("max") Integer max);
 // public List<Computer> findByBrand(String brand);
}
