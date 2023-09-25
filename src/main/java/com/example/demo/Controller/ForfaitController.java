package com.example.demo.Controller;

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

import com.example.demo.Services.ForfaitService;
import com.example.demo.entities.Forfait;
@CrossOrigin
@RestController
@RequestMapping("/forfait")

public class ForfaitController {	
	
	@Autowired
	protected ForfaitService forfaitservice ;
	
	
	@PostMapping("/addforfait")
	public Forfait Add_Client(@RequestBody Forfait f) {
		return forfaitservice.saveForfait(f);
	}
	
	@PutMapping("/updateforfait") 
	public Forfait updateE(@RequestBody Forfait f)
	{
		return forfaitservice.updateForfait(f);
	}
	
	@DeleteMapping("/deleteforfait/{id}")
	public void deleteE(@PathVariable(value = "id") Long id)
	{
		forfaitservice.deleteForfaitById(id);
	}
	
	
	
	
	
	

	@GetMapping("/getallforfait")
	public List<Forfait> getallforfait()
	{
		return forfaitservice.getAllForfaits();
	}
	
	@GetMapping("/getforfait/{id}")
    public Forfait deleteforfaitId(@PathVariable(value = "id") Long id) {
		return forfaitservice.getForfait(id) ;
	}        
	
}
