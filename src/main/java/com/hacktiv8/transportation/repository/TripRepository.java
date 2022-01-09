package com.hacktiv8.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hacktiv8.transportation.models.bus.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
