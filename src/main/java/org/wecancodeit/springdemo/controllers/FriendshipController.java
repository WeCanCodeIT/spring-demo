package org.wecancodeit.springdemo.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wecancodeit.springdemo.models.Friendship;
import org.wecancodeit.springdemo.models.Person;
import org.wecancodeit.springdemo.repositories.FriendshipRepository;
import org.wecancodeit.springdemo.repositories.PeopleRepository;

@Controller
@RequestMapping("/friendships")
public class FriendshipController {
	
	@Resource
	FriendshipRepository friendshipRepo;
	
	@Resource
	PeopleRepository peopleRepo;

	@GetMapping("")
	public String getFriendships(Model model) {
		model.addAttribute("friendships", friendshipRepo.findAll());
		return "friendships/add";
	}

	@GetMapping("/{id}")
	public String getFriendship(@PathVariable Long id, Model model) {
		// .get() returns the actual person from the Optional
		// More on Optionals in coming weeks
		model.addAttribute("friendship", friendshipRepo.findById(id).get());
		model.addAttribute("allPeople", peopleRepo.findAll());
		return "/friendships/individual";
	}
	
	@PostMapping("/{friendshipId}/add")
	public String addPersonToFriendship(@PathVariable Long friendshipId, Long personId) {
		Friendship friendshipToAddTo = friendshipRepo.findById(friendshipId).get();
		Person personToAdd = peopleRepo.findById(personId).get();
		friendshipToAddTo.addPersonToPeople(personToAdd);
		friendshipRepo.save(friendshipToAddTo);
		return "redirect:/friendships/" + friendshipId;
	}
}
