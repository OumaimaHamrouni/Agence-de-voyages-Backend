package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Programme;
import com.example.demo.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{
	

}
