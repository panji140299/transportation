package com.hacktiv8.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hacktiv8.transportation.models.bus.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> {

}
