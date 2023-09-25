package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.entities.Programme;
import com.example.demo.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long>{
	
	@RestResource(path="getallreservationid")
	@Query("select r from Reservation r where  r.user.id=:id ")
	List<Reservation> getallreservationid(@Param("id") Integer id);
	
	@RestResource(path="getallreservationidAu")
	@Query("select r from Reservation r where  r.user.id=:id and r.annonce.id=:ida ")
	List<Reservation> getallreservationidAU(@Param("id") Integer id,@Param("ida")Long ida);
	
	

	
}
