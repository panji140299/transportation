package com.hacktiv8.transportation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hacktiv8.transportation.models.bus.Stop;

@Repository
public interface StopRepository extends JpaRepository<Stop, Long> {

}
