package com.hacktiv8.auth.model.bus;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "tripschedule")
public class TripSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int fare;
    private String tripDate;
    private int availableSeat;
    private String ticketSold;
    
    @ManyToOne
	@JoinColumn
	private Trip trip;
    
    @OneToMany(
    		mappedBy = "tripschedule",
    		cascade = CascadeType.ALL
    		)
    private List<Ticket> ticket;
    
    
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
	 * @return the fare
	 */
	public int getFare() {
		return fare;
	}
	/**
	 * @param fare the fare to set
	 */
	public void setFare(int fare) {
		this.fare = fare;
	}
	/**
	 * @return the tripDate
	 */
	public String getTripDate() {
		return tripDate;
	}
	/**
	 * @param tripDate the tripDate to set
	 */
	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}
	/**
	 * @return the availableSeat
	 */
	public int getAvailableSeat() {
		return availableSeat;
	}
	/**
	 * @param availableSeat the availableSeat to set
	 */
	public void setAvailableSeat(int availableSeat) {
		this.availableSeat = availableSeat;
	}

	/**
	 * @return the ticketSold
	 */
	public String getTicketSold() {
		return ticketSold;
	}
	/**
	 * @param ticketSold the ticketSold to set
	 */
	public void setTicketSold(String ticketSold) {
		this.ticketSold = ticketSold;
	}
	/**
	 * @return the trip
	 */
	public Trip getTrip() {
		return trip;
	}
	/**
	 * @param trip the trip to set
	 */
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	/**
	 * @return the ticket
	 */
	public List<Ticket> getTicket() {
		return ticket;
	}
	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(List<Ticket> ticket) {
		this.ticket = ticket;
	}
	
    
    
    
}

