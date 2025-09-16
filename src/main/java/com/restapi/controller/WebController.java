package com.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restapi.service.DataService;

@Controller
@RequestMapping("/web")
public class WebController {

	@Autowired
	private DataService dservice;
	@RequestMapping("/greet")
	public String first(ModelMap model) {
		model.addAttribute("names",dservice.getNames());
		return "home";
	}
}
