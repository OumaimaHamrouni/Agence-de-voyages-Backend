package com.example.demo.Controller;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Services.IAnnonceService;
import com.example.demo.Services.ReservationServiceImp;
import com.example.demo.entities.Annonce;
import com.example.demo.entities.Reservation;

import aj.org.objectweb.asm.Type;
@CrossOrigin	
@RestController
@RequestMapping("/reservation")
public class ReservationController {
	@Autowired
	protected ReservationServiceImp RSI ;
	
	
	@PostMapping("/addreservation")
	public Reservation Add_reservation(@RequestBody Reservation R) {
		R.setDateReservation(LocalDate.now());
		return   RSI.saveReservation(R) ;
	}
	
	@PutMapping("/updatereservation") 
	public Reservation updateE(@RequestBody Reservation R)
	{
		return RSI.updateReservation(R);
	}
	

	
	
	@DeleteMapping("/deletereservation/{id}")
	public void deleteE(@PathVariable(value = "id") Long id)
	{
		RSI.deleteReservationById(id);
	}
	
	@DeleteMapping("/getallreservationid/{id}")
	public void getallreservationid(@PathVariable(value = "id") Long id)
	{
		RSI.deleteReservationById(id);
	}
	
	@GetMapping("/getallreservation")
	public List<Reservation> getallreservation()
	{
		return RSI.getAllReservations();
	}

	@GetMapping("/getallreservationM")
	public HashMap<String,Integer> getallreservationM()
	{List<Reservation> l=RSI.getAllReservations();
	int nbj=0,nbf=0,nbm=0,nba=0,nbma=0,nbju=0,nbjul=0,nbao=0,nbs=0,nbo=0,nbn=0,nbd=0;
	   
		for (Reservation reservation : l) {
		switch (reservation.getDateReservation().getMonthValue()) {
		case 1:nbj++;
		break;
		case 2:nbf++;
		break;
		case 3:nbm++;
		break;
		case 4:nba++;
		break;
		case 5:nbma++;
		break;
		case 6:nbju++;
		break;
		case 7:nbjul++;
		break;
		case 8:nbao++;
		break;
		case 9:nbs++;
		break;
		case 10:nbo++;
		break;
		case 11:nbn++;
		break;
		case 12:nbd++;
			break;

		default:
			break;
		} 
		}
		HashMap<String,Integer> lRM=new HashMap();
		lRM.put("jannvier",nbj);
		lRM.put("fevrier",nbf);
		lRM.put("mars",nbm);
		lRM.put("avril",nba);
		lRM.put("mai",nbma);
		lRM.put("juin",nbju);
		lRM.put("Juillet",nbjul);
		lRM.put("août",nbao);
		lRM.put("september",nbs);
		lRM.put("october",nbo);
		lRM.put("November",nbn);
		lRM.put("december",nbd);
		return lRM;
	}


	@GetMapping("/getReservationbyiduser/{id}")
	public List<Reservation> getReservationbyiduser(@PathVariable(value = "id") Integer id)
	{System.out.println(id.getClass().getName());
		
		return RSI.getallreservationid(id);
	}
	@GetMapping("/getReservationbyiduserA/{id}/{ida}")
	public List<Reservation> getReservationbyiduserA(@PathVariable(value = "id") Integer id,@PathVariable(value = "ida") Long ida)
	{System.out.println(id.getClass().getName());
		
		return RSI.getallreservationidAU(id, ida);
	}

}
