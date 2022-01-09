package com.hacktiv8.transportation.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class BookTicketRequest {
  private Integer seatNumber;

  private Boolean cancellable;

  @NotBlank
  @Size(max = 50)
  private String journeyDate;
  
  private Set<String> passenger;
  
  private Set<String> tripSchedule;

/**
 * @return the seatNumber
 */
public Integer getSeatNumber() {
	return seatNumber;
}

/**
 * @param seatNumber the seatNumber to set
 */
public void setSeatNumber(Integer seatNumber) {
	this.seatNumber = seatNumber;
}

/**
 * @return the cancellable
 */
public Boolean getCancellable() {
	return cancellable;
}

/**
 * @param cancellable the cancellable to set
 */
public void setCancellable(Boolean cancellable) {
	this.cancellable = cancellable;
}

/**
 * @return the journeyDate
 */
public String getJourneyDate() {
	return journeyDate;
}

/**
 * @param journeyDate the journeyDate to set
 */
public void setJourneyDate(String journeyDate) {
	this.journeyDate = journeyDate;
}

/**
 * @return the passenger
 */
public Set<String> getPassenger() {
	return passenger;
}

/**
 * @param passenger the passenger to set
 */
public void setPassenger(Set<String> passenger) {
	this.passenger = passenger;
}

/**
 * @return the tripSchedule
 */
public Set<String> getTripSchedule() {
	return tripSchedule;
}

/**
 * @param tripSchedule the tripSchedule to set
 */
public void setTripSchedule(Set<String> tripSchedule) {
	this.tripSchedule = tripSchedule;
}
  
  
  
}
  

