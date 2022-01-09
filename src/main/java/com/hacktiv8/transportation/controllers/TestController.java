package com.hacktiv8.transportation.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hacktiv8.transportation.models.ERole;
import com.hacktiv8.transportation.models.Role;
import com.hacktiv8.transportation.models.User;
import com.hacktiv8.transportation.models.bus.Stop;
import com.hacktiv8.transportation.models.bus.Ticket;
import com.hacktiv8.transportation.models.bus.Trip;
import com.hacktiv8.transportation.models.bus.TripSchedule;
import com.hacktiv8.transportation.payload.request.BookTicketRequest;
import com.hacktiv8.transportation.payload.request.SignupRequest;
import com.hacktiv8.transportation.payload.response.MessageResponse;
import com.hacktiv8.transportation.repository.StopRepository;
import com.hacktiv8.transportation.repository.TicketRepository;
import com.hacktiv8.transportation.repository.TripRepository;
import com.hacktiv8.transportation.repository.TripScheduleRepository;
import com.hacktiv8.transportation.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
	StopRepository stopRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	TripRepository tripRepository;
	
	@Autowired
	TripScheduleRepository tripScheduleRepository;
	
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
  
  @GetMapping("/reservation/tripsbystops")
	public List<Trip> getTripbyStop(){
		return tripRepository.findAll();
	}
  
  @GetMapping("/reservation/stops")
	public List<Stop> getStop(){
		return stopRepository.findAll();
	}
  
  @GetMapping("/reservation/tripschedule")
 	public List<TripSchedule> getTripSchedule(){
 		return tripScheduleRepository.findAll();
 	}
  
  @PostMapping("/reservation/bookticket")
  public ResponseEntity<?> bookingTicket(@Valid @RequestBody BookTicketRequest bookTicketRequest) {


    // Create new user's account
    Ticket ticket = new Ticket(
               bookTicketRequest.getSeatNumber(),
               bookTicketRequest.getCancellable(),
               bookTicketRequest.getJourneyDate());

    Set<String> strPassenger = bookTicketRequest.getPassenger();
    Set<Ticket> passenger = new HashSet<>();
    
    Set<String> strTripSchedule = bookTicketRequest.getTripSchedule();
    Set<Ticket> tripSchedule = new HashSet<>();
    ticketRepository.save(ticket);

    return ResponseEntity.ok(new MessageResponse("Ticket berhaisl dipesan"));
  }
}
