package com.oadya.springbooth2database.service;



import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oadya.springbooth2database.data.User;
import com.oadya.springbooth2database.data.UserRepository;


@Service
public class UserService {
	
	private final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}
	
	public List<User> findAllUsers() {
		List<User> users = new ArrayList<>();
		Iterable<User > liste = repository.findAll();	
		liste.forEach(x -> users.add(x));
		return users;
	}
	
	public User findUserById(Long id) {
		return repository.findById(id).orElse(null);
	}
	
	public Collection<User> findUserByLastName(String lastName) {
		return repository.findByLastName(lastName);
	}
	
	public void addUser(User user) {
		repository.save(user);	
	}
	

	public void deleteUserById(Long id) {
		repository.deleteById(id);
	}
	
	public void updateUser(User user) {
		Optional<User> oldUser = repository.findById(user.getId());
		
		if(Objects.nonNull(oldUser)) 
			repository.save(user);	
		
	}

}

