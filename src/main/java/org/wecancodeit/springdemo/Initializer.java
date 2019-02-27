package org.wecancodeit.springdemo;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.springdemo.models.Address;
import org.wecancodeit.springdemo.models.Friendship;
import org.wecancodeit.springdemo.models.Person;
import org.wecancodeit.springdemo.repositories.AddressRepository;
import org.wecancodeit.springdemo.repositories.FriendshipRepository;
import org.wecancodeit.springdemo.repositories.PeopleRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	PeopleRepository peopleRepo;

	@Resource
	AddressRepository addressRepo;

	@Resource
	FriendshipRepository friendshipRepo;

	@Override
	public void run(String... args) throws Exception {
		String wuTangYellow = "#e2a42b";
		String defSquadBlue = "#39add1";
		
		Address parkHillProjects = addressRepo.save(new Address("260 Park Hill Ave", "Staten Island", "NY", "10304"));
		Address brickCity = addressRepo.save(new Address("123 Brick City Ave", "Newark", "NJ", "07101"));
		
		Person methodMan = peopleRepo.save(new Person("Method Man", 47, wuTangYellow, parkHillProjects));
		Person rza = peopleRepo.save(new Person("RZA", 49, wuTangYellow, parkHillProjects));
		Person gza = peopleRepo.save(new Person("GZA", 52, wuTangYellow, parkHillProjects));
		Person rae = peopleRepo.save(new Person("Raekwon", 49, wuTangYellow, parkHillProjects));
		Person ghost = peopleRepo.save(new Person("Ghostface Killah", 48, wuTangYellow, parkHillProjects));
		Person ins = peopleRepo.save(new Person("Inspectah Deck", 48, wuTangYellow, parkHillProjects));
		Person ugod = peopleRepo.save(new Person("U-God", 48, wuTangYellow, parkHillProjects));
		Person odb = peopleRepo.save(new Person("Ol' Dirty Bastard (RIP)", 50, wuTangYellow, parkHillProjects));
		Person mk = peopleRepo.save(new Person("Masta Killa", 49, wuTangYellow, parkHillProjects));

		peopleRepo.save(new Person("Redman", 48, defSquadBlue, brickCity));
		peopleRepo.save(new Person("Erick Sermon", 50, defSquadBlue, brickCity));
		peopleRepo.save(new Person("Keith Murray", 44, defSquadBlue, brickCity));
		
		Friendship wuTangClan = friendshipRepo.save(new Friendship("Wu Tang Clan", methodMan));
		
	}

}
