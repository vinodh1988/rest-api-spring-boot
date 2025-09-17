package com.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entities.Computer;
import com.restapi.repository.ComputerRepository;
import com.restapi.util.RecordAlreadyExistsException;

@Service
public class ComputerService {
	@Autowired
	private ComputerRepository crepo;// implementation is taken care by datajpa
	
    public List<Computer> getComputers(){
    	return crepo.findAll();
    }	

    
    public void addComputer(Computer c) throws RecordAlreadyExistsException
    {
    	Computer computer=crepo.findByCno(c.getCno());
    	if(computer!=null)
    		throw new RecordAlreadyExistsException();
    	crepo.save(c);
    		
    }

}
