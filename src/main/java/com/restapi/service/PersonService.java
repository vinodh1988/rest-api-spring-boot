package com.restapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.restapi.entities.Person;

@Service
public class PersonService {
	
	private List<Person> people=new ArrayList<Person>();
	
	{
		people.add(new Person(1,"Roshan","Chennai"));
		people.add(new Person(2,"Peter","Mumbai"));
		people.add(new Person(3,"Bhargav","Delhi"));
		people.add(new Person(4,"Naresh","Delhi"));
		people.add(new Person(5,"Naveen","Chennai"));
		
	}
	
	public List<Person> getPeople() {
		return people;
	}

}
