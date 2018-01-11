package com.chrisspringboot.demo.webController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chrisspringboot.demo.Domin.Model.User;
import com.chrisspringboot.demo.service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("localhost:4200")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/users")
	public User createUser(@Valid @RequestBody User user) {
		return userService.CreateUser(user);
	}

	@GetMapping(value = "/users/{name}")
	public ResponseEntity<User> getUserByName(@PathVariable("name") String name) {
		User user = userService.getUserByName(name);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(user, HttpStatus.OK);
		}
	}

	@PutMapping(value = "/users/{name}")
	public ResponseEntity<User> updateUser(@PathVariable("name") String name,
			@Valid @RequestBody User user) {
		User edittedUser = userService.getUserByName(name);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		edittedUser.setAdmin(user.isAdmin());
		edittedUser.setUserEmail(user.getUserEmail());
		edittedUser.setUserPassWord(user.getUserPassWord());
		User updatedUser = userService.updateUser(edittedUser);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/users/{name}")
	public void deleteUser(@PathVariable("name") String name) {
		userService.deleteUser(name);
	}
}
