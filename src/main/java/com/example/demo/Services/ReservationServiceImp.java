package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ReservationRepository;
import com.example.demo.entities.Reservation;
@Service
public class ReservationServiceImp implements ReservationService {
@Autowired
ReservationRepository rr;
	@Override
	public Reservation saveReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return rr.save(reservation); 
	}

	@Override
	public Reservation updateReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		return rr.saveAndFlush(reservation);
	}

	@Override
	public void deleteReservation(Reservation reservation) {
		rr.delete(reservation);
		
	}

	@Override
	public void deleteReservationById(Long id) {
		// TODO Auto-generated method stub
		rr.deleteById(id);
	}

	@Override
	public Reservation getReservation(Long id) {
		// TODO Auto-generated method stub
		return rr.findById(id).get();
	}

	@Override
	public List<Reservation> getAllReservations() {
		// TODO Auto-generated method stub
		return rr.findAll();
	}

	@Override
	public List<Reservation> getallreservationid(Integer id) {
		// TODO Auto-generated method stub
		return rr.getallreservationid(id);
	}

	@Override
	public List<Reservation> getallreservationidAU(Integer id, Long ida) {
		// TODO Auto-generated method stub
		return rr.getallreservationidAU(id, ida);
	}
	
	
	

}
