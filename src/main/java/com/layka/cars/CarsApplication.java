package com.layka.cars;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.layka.cars.entities.Car;
import com.layka.cars.entities.Role;
import com.layka.cars.entities.User;
import com.layka.cars.service.CarService;
import com.layka.cars.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class CarsApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(CarsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Password Encoded BCRYPT :******************** ");
		System.out.println(passwordEncoder.encode("123"));

	}

//	@PostConstruct
//	void init_users() {
//		userService.addRole(new Role(null, "ADMIN"));
//		userService.addRole(new Role(null, "AGENT"));
//		userService.addRole(new Role(null, "USER"));
//
//		userService.saveUser(new User(null, "admin", "123", true, null));
//		userService.saveUser(new User(null, "layka", "123", true, null));
//		userService.saveUser(new User(null, "user1", "123", true, null));
//
//		userService.addRoleToUser("admin", "ADMIN");
//
//		userService.addRoleToUser("layka", "USER");
//		userService.addRoleToUser("layka", "AGENT");
//
//		userService.addRoleToUser("user1", "USER");
//	}

}
