package com.hacktiv8.auth.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hacktiv8.auth.Repository.UserRepository;
import com.hacktiv8.auth.model.user.User;

@Service
@Transactional
	public class UserService {
	    @Autowired
	    private UserRepository userRepository;

	    public void saveUser(User user) {
	        userRepository.save(user);
	    }
	}

