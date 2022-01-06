package com.hacktiv8.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hacktiv8.auth.Repository.UserRepository;
import com.hacktiv8.auth.model.user.User;
import com.hacktiv8.auth.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@PostMapping("/signup")
	public ResponseEntity<?> add(@RequestBody User user) {
		if (userRepository.findByEmail(user.getEmail()).isEmpty()) {
			User userInput = new User();
			userInput.setEmail(user.getEmail());
			userInput.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			userInput.setFirstName(user.getFirstName());
			userInput.setLastName(user.getLastName());
			userInput.setMobileNumber(user.getMobileNumber());
			userInput.setRoles(user.getRoles());

			userService.saveUser(userInput);
			return ResponseEntity.ok(userInput);
		}

		else {
			return new ResponseEntity<String>("email" + user.getEmail() + " sudah terdaftar", HttpStatus.BAD_REQUEST);
		}
	}
}