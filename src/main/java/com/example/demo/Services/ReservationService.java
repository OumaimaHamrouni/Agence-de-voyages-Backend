package com.example.demo.Services;

import java.util.List;


import com.example.demo.entities.Reservation;

public interface ReservationService {

	Reservation saveReservation(Reservation reservation);
	Reservation updateReservation(Reservation reservation);
	void deleteReservation(Reservation reservation);
	void deleteReservationById(Long id);
	Reservation getReservation(Long id);
	List<Reservation> getAllReservations();
	List<Reservation>getallreservationid(Integer id);
	List<Reservation>getallreservationidAU(Integer id,Long ida);

}
