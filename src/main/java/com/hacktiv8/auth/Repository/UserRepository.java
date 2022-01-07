package com.hacktiv8.auth.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hacktiv8.auth.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByEmail(String email);
}
