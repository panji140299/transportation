package com.hacktiv8.auth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hacktiv8.auth.model.bus.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
