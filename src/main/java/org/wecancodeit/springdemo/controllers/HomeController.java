package org.wecancodeit.springdemo.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.wecancodeit.springdemo.models.Person;
import org.wecancodeit.springdemo.repositories.PeopleRepository;

@Controller
public class HomeController {

	/**
	 * You're repository is what keeps track of your model data. We created one from
	 * scratch but Spring has them built in. They're just WAY more abstract.
	 * 
	 * This class should only contain a Collection of something, in our case people
	 * and offer you the ability to interact/manipulate it. The actual creation of
	 * that data should be done via a method.
	 * 
	 * We inject the list though Constructor Injection so we have more control over
	 * our implementation at the time of creation.
	 */
	@Resource
	PeopleRepository repo;

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

	/**
	 * Here we are expecting an instance of the model interface which allows us to
	 * add attributes that will be passed to our specified template so we can render
	 * dynamic info in them via thymeleaf.
	 * 
	 * Here we are passing the ArrrayList from the PersonRepository to our
	 * 'people/add.html' template. This is then letting us iterate over that list
	 * and dynamically print out all users in our repository. (Noted in
	 * 'people/add.html').
	 * 
	 * @param model
	 * @return thymeleaf template name
	 */
	@GetMapping("/people")
	public String getPersonForm(Model model) {
		model.addAttribute("people", repo.findAll());
		return "people/add";
	}
	
	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/people/{id}")
	public String getPerson(@PathVariable Long id, Model model) {
		// .get() returns the actual person from the Optional
		// More on Optionals in coming weeks
		model.addAttribute("person", repo.findById(id).get());
		return "/people/individual";
	}
	
//	@GetMapping("/people/name/{name}") // Don't do this because bad
//	public String findPersonByName(@PathVariable String name, Model model) {
//		model.addAttribute("person", repo.findByName(name));
//		return "/people/individual";
//	}
//	
//	@GetMapping("/people/age/{age}") // Don't do this because bad
//	public String findPersonByName(@PathVariable int age, Model model) {
//		model.addAttribute("person", repo.findByAge(age));
//		return "/people/individual";
//	}

	/**
	 * With our post mapping, we are expecting data from our user that will some how
	 * manipulate our application data. Here we are accepting all of the parameters
	 * (from the input fields in our form) to create a new instance of a person
	 * and add it to our repository.
	 * 
	 * The difference between this method and the previous is that we aren't rendering
	 * a view. Instead, we are redirecting our application to another route (in this case,
	 * the same route with a different request method, GET) in our application and let
	 * it do whatever it's supposed to do. 
	 * 
	 * So we're updating our repository here and then sending a redirect call to re-render
	 * the browser environment with all of the new material.
	 * 
	 * @param name
	 * @param age
	 * @param favColor
	 * @return redirect
	 */
	@PostMapping("/people/add")
	public String addPerson(String name, int age, String favColor) {
		repo.save(new Person(name, age, favColor));
		return "redirect:/people";
	}
}
