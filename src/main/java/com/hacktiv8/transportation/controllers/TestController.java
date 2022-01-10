package com.hacktiv8.transportation.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping("/api/v1")
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
  @PreAuthorize("hasAuthority('PASSENGER') or hasAuthority('ADMIN')")
  public String userAccess() {
    return "User Content.";
  }

  @GetMapping("/admin")
  @PreAuthorize("hasAuthority('ADMIN')")
  public String adminAccess() {
    return "Admin Board.";
  }
  
  @PreAuthorize("hasAuthority('PASSENGER') or hasAuthority('ADMIN')") 
  @GetMapping("/reservation/tripsbystops") 
  public ResponseEntity<?> tripsbystops(@RequestBody Trip trip) { 
      Integer destStop = trip.getDeststop().getId().intValue(); 
      Integer sourceStop = trip.getSourcestop().getId().intValue(); 
      List<Trip> byStops = tripRepository.findByStops(destStop, sourceStop); 
      return ResponseEntity.ok().body(byStops); 
  }
  
  @GetMapping("/reservation/stops")
	public List<Stop> getStop(){
		return stopRepository.findAll();
	}
  
  @GetMapping("/reservation/tripschedule")
 	public List<TripSchedule> getTripSchedule(){
 		return tripScheduleRepository.findAll();
 	}
  
//  @PreAuthorize("hasAuthority('owner') or hasAuthority('passenger') or hasAuthority('admin')") 
  @PostMapping("/reservation/bookticket") 
  public ResponseEntity<?> bookticket(@Valid @RequestBody Ticket ticket) { 
      User passenger = new User(); 
      passenger.setId(ticket.getPassenger().getId()); 
      TripSchedule tripSchedule = new TripSchedule(); 
      tripSchedule.setId(ticket.getTripschedule().getId()); 
      List<Ticket> byPassenger = ticketRepository.findByPassenger(passenger); 
      List<Ticket> byTripSchedule = ticketRepository.findByTripschedule(tripSchedule); 
      List<Ticket> bySeatNumber = ticketRepository.findBySeatNumber(ticket.getSeatNumber()); 
      if (!byPassenger.isEmpty() && !byTripSchedule.isEmpty() && !bySeatNumber.isEmpty()) { 
          return ResponseEntity.status(HttpStatus.NOT_FOUND) 
                  .body("Id sudah ada"); 
//          return ResponseEntity.status(HttpStatus.NOT_FOUND) 
//                  .body("Ticket dengan id passenger = " + ticket.getPassenger().getId() 
//                          + " dan dengan id trip schedule " + ticket.getTripschedule().getId() 
//                          + " dan dengan seat number " + ticket.getSeatNumber() + " sudah ada."); 
      } else { 
          TripSchedule tripScheduleNew = tripScheduleRepository.findById(ticket.getTripschedule().getId()).get(); 
          if (tripScheduleNew.getAvailableSeat() > 0) { 
              tripSchedule.setAvailableSeat(tripScheduleNew.getAvailableSeat() - 1); 
              tripSchedule.setTripDate(tripScheduleNew.getTripDate()); 
              tripSchedule.setTicketSold(tripScheduleNew.getTicketSold()); 
              tripSchedule.setTripDetail(tripScheduleNew.getTripDetail()); 
              tripScheduleRepository.save(tripSchedule); 
              ticketRepository.save(ticket); 
              return ResponseEntity.ok().body(ticket); 
          } else { 
              return ResponseEntity.status(HttpStatus.NOT_FOUND) 
                      .body("Trip Schedule yang anda pilih, sudah tidak tersedia bangkunya."); 
          } 
      } 
  }
}
