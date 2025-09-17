package com.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entities.Computer;
import com.restapi.repository.ComputerRepository;

@Service
public class ComputerService {
	@Autowired
	private ComputerRepository crepo;// implementation is taken care by datajpa
	
    public List<Computer> getComputers(){
    	return crepo.findAll();
    }	


}
