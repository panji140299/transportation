package com.hacktiv8.auth.model.bus;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hacktiv8.auth.model.user.User;


@Table(name = "agency")
@Entity
public class Agency {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String code;
	private String name;
	private String details;
	
	@ManyToOne
	@JoinColumn
	private User owner;
	
	@OneToMany(
	mappedBy = "agency",
	cascade = CascadeType.ALL
	)
	private List<Bus> buss;
	
	@OneToMany(
	mappedBy = "agency",
	cascade = CascadeType.ALL
	)
	private List<Trip> trip;
	
	public Agency() {
		
	}
	public Agency(String code, String name, String details,long id, Bus...buss) {
		this.id = id;
		this.buss = Stream.of(buss).collect(Collectors.toList());
		this.buss.forEach(x -> x.setAgency(this));
	}
	
	public Agency(String code, String name, String details,long id, Trip...trip) {
		this.id = id;
		this.trip = Stream.of(trip).collect(Collectors.toList());
		this.trip.forEach(x -> x.setAgency(this));
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	/**
	 * @return the buss
	 */
	public List<Bus> getBuss() {
		return buss;
	}
	/**
	 * @param buss the buss to set
	 */
	public void setBuss(List<Bus> buss) {
		this.buss = buss;
	}
	/**
	 * @return the user
	 */
	/**
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
	/**
	 * @return the trip
	 */
	public List<Trip> getTrip() {
		return trip;
	}
	/**
	 * @param trip the trip to set
	 */
	public void setTrip(List<Trip> trip) {
		this.trip = trip;
	}

	
	
	
	
	
}
