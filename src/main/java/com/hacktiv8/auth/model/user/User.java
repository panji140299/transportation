package com.hacktiv8.auth.model.user;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.hacktiv8.auth.model.bus.Agency;
import com.hacktiv8.auth.model.bus.Ticket;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(unique = true)
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String mobileNumber;

	@ManyToOne
	@JoinColumn(name = "roles", nullable = false)
	private Role roles;

	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
	private List<Agency> agencys;

	@OneToMany(mappedBy = "passenger", cascade = CascadeType.ALL)
	private List<Ticket> tickets;

	public User() {
	}

	public User(Long id, String email, String password, String firstName, String lastName, String mobileNumber,
			Role roles) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.roles = roles;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Role getRoles() {
		return this.roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}

	public User id(Long id) {
		setId(id);
		return this;
	}

	public User email(String email) {
		setEmail(email);
		return this;
	}

	public User password(String password) {
		setPassword(password);
		return this;
	}

	public User firstName(String firstName) {
		setFirstName(firstName);
		return this;
	}

	public User lastName(String lastName) {
		setLastName(lastName);
		return this;
	}

	public User mobileNumber(String mobileNumber) {
		setMobileNumber(mobileNumber);
		return this;
	}

	public User roles(Role roles) {
		setRoles(roles);
		return this;
	}
}