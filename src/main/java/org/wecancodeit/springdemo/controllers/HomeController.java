package org.wecancodeit.springdemo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.wecancodeit.springdemo.models.Person;
import org.wecancodeit.springdemo.repositories.PeopleRepository;

@Controller
public class HomeController {
	
	private PeopleRepository repo = new PeopleRepository(new ArrayList<Person>());

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/people/add")
	public String getPersonForm(Model model) {
		model.addAttribute("people", repo.getPeople());
		return "people/add";
	}
	
	@PostMapping("/people/add")
	public String addPerson(String name, int age, String favColor) {
		repo.addPerson(new Person(name, age, favColor));
		return "redirect:/people/add";
	}
}
