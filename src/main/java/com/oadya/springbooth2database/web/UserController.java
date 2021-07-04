package com.oadya.springbooth2database.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oadya.springbooth2database.data.User;
import com.oadya.springbooth2database.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("api/user")
@Api(description = "User API", value = "/user")
public class UserController {

	@Autowired
	private UserService userService;


	@GetMapping
	@ApiOperation(value = "Get all users", response = User.class, responseContainer = "List")  
	public List<User> getUsers() {
		return userService.findAllUsers();
	}

	@PostMapping
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	@GetMapping(path = "{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return userService.findUserById(id);
	}

	@DeleteMapping(path = "{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}

	@PutMapping
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}

}
