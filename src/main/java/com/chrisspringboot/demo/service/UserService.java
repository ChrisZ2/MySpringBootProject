package com.chrisspringboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.chrisspringboot.demo.Domin.Model.User;
import com.chrisspringboot.demo.Domin.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		Sort sortByCreatedTime = new Sort(new Sort.Order(Sort.Direction.ASC,
				"isAdmin"), new Sort.Order(Sort.Direction.ASC, "timeCreated"));
		return userRepository.findAll(sortByCreatedTime);
	}
	
	public User CreateUser(User user) {
		return userRepository.save(user);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public void deleteUser(String userName) {
		userRepository.delete(userName);
	}
	
	public User getUserByName(String name) {
		return userRepository.findOne(name);
	}
	
	
}
