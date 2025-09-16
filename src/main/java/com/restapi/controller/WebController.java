package com.restapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {

	@RequestMapping("/greet")
	public String first() {
		return "home";
	}
}
