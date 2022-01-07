package com.hacktiv8.auth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hacktiv8.auth.model.user.Role;
import com.hacktiv8.auth.model.user.UserRoles;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByRole(UserRoles role);
}
