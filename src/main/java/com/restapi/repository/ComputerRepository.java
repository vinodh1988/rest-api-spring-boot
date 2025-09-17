package com.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.entities.Computer;

public interface ComputerRepository extends JpaRepository<Computer, Integer>{

}
