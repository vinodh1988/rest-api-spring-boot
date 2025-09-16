package com.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.restapi.service.DataService;
import com.restapi.util.AppState;
import com.restapi.util.SessionState;

@Controller
@RequestMapping("/web")
public class WebController {

	@Autowired
	private DataService dservice;// (unjected object is fixed)
	
	@Autowired
	private AppState astate;
	@Autowired
	private SessionState sstate; //(reference is one but the injected object is not fixed)
	
	@RequestMapping("/greet")
	public String first(ModelMap model) {
		model.addAttribute("names",dservice.getNames());
		astate.setState();
		sstate.setState();
		model.addAttribute("adata",astate.getState());
		model.addAttribute("sdata",sstate.getState());
		return "home";
	}
}
