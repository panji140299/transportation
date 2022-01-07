package com.hacktiv8.auth.model.user;



import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserRoles role;

	public Role() {
	}

	public Role(UserRoles role) {
		this.role = role;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the role
	 */
	public UserRoles getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(UserRoles role) {
		this.role = role;
	}

	
}

