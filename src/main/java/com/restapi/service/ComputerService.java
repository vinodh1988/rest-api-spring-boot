package com.restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.entities.Computer;
import com.restapi.entities.Person;
import com.restapi.repository.ComputerRepository;
import com.restapi.util.RecordAlreadyExistsException;
import com.restapi.util.RecordNotFoundException;

@Service
public class ComputerService {
	@Autowired
	private ComputerRepository crepo;// implementation is taken care by datajpa
	
    public List<Computer> getComputers(){
    	return crepo.findAll();
    }	
   
    
    public List<Computer> getComputers(Integer min,Integer max){
    	return crepo.findByCnoRange(min, max);
    }
    public Computer getComputer(Integer cno) throws RecordNotFoundException{
    	Computer computer=crepo.findByCno(cno);
    	if(computer==null)
    		throw new RecordNotFoundException();
    	return computer;
    }
    
    public void addComputer(Computer c) throws RecordAlreadyExistsException
    {
    	Computer computer=crepo.findByCno(c.getCno());
    	if(computer!=null)
    		throw new RecordAlreadyExistsException();
    	crepo.save(c);
    		
    }
    
    public void updateComputer(Computer c) throws RecordNotFoundException
    {
    	Computer computer=crepo.findByCno(c.getCno());
    	if(computer==null)
    		throw new RecordNotFoundException();
    	c.setBrand(c.getBrand()==null?computer.getBrand():c.getBrand());
    	c.setCpu(c.getCpu()==null?computer.getCpu():c.getCpu());
    	c.setDisk(c.getDisk()==null?computer.getDisk():c.getDisk());
    	c.setRam(c.getRam()==null?computer.getRam():c.getRam());
    	crepo.save(c);
    		
    }
    
    public void deleteComputer(Integer cno) throws RecordNotFoundException{
    	Computer computer=crepo.findByCno(cno);
    	if(computer==null)
    		throw new RecordNotFoundException();
        crepo.delete(computer);
    }
    
    
    
    

}
