package com.restapi.service;

import org.springframework.stereotype.Service;

@Service
public class DataService {

	public String[] getNames()
	{
		String[] n= {"Roshan","Rahul","Ganesh","Naresh","Harry"};
		return n;
	}
}
