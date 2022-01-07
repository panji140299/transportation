package com.hacktiv8.auth.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hacktiv8.auth.model.user.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String email);
	Boolean existsByEmail(String email);
}
