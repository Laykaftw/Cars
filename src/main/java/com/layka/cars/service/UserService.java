package com.layka.cars.service;

import com.layka.cars.entities.Role;
import com.layka.cars.entities.User;


public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);


}