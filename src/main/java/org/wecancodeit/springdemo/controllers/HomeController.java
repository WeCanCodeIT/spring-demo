package org.wecancodeit.springdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	/**
	 * Our Get Mapping only requests data from our server environment. So in this
	 * example, when we hit 'localhost:8080' in our browser we're getting whatever
	 * is rendered in the 'home.html' template.
	 * 
	 * @return thymeleaf template name.
	 */
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
