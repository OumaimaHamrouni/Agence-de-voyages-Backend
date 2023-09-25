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

import com.example.demo.Services.IAnnonceService;
import com.example.demo.entities.Annonce;

@CrossOrigin
@RestController
@RequestMapping("/annonce")
public class AnnonceController {
	@Autowired
	protected IAnnonceService annonceservice ;
	
	
	@PostMapping("/addannonce")
	public Annonce Add_Annonce(@RequestBody Annonce a) {
		return   annonceservice.saveAnnonce(a) ;
	}
	
	@PutMapping("/updateannonce") 
	public Annonce updateE(@RequestBody Annonce a)
	{
		return annonceservice.updateAnnonce(a);
	}
	

	
	
	@DeleteMapping("/deleteannonce/{id}")
	public void deleteE(@PathVariable(value = "id") Long id)
	{
		annonceservice.deleteAnnonceById(id);
	}
	
	
	
	

	@GetMapping("/getallannonce")
	public List<Annonce> getallannonce()
	{
		return annonceservice.getAllAnnonce();
	}
	
	@GetMapping("/getannonce/{id}")
    public Annonce deleteannonceId(@PathVariable(value = "id") Long id) {
		return annonceservice.getAnnonce(id) ;
	}       
	@GetMapping("/searchannonce/{s}")
    public List<Annonce> searchannonce(@PathVariable(value = "s") String s) {
     return annonceservice.searchAnnonce(s) ;
	} 
}
