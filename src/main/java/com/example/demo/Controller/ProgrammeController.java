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

 
import com.example.demo.Services.IProgrammeService;
import com.example.demo.entities.Programme;
 
@CrossOrigin
@RestController
@RequestMapping("/programme")
public class ProgrammeController {
	@Autowired
	protected IProgrammeService programmeService ;
	
	
	
	@PostMapping("/addProgramme")
	public Programme Add_Programme(@RequestBody Programme prog) {
		return programmeService.saveProgramme(prog);
	}
	@PutMapping("/updateProgramme")
	public Programme update_Programme(@RequestBody Programme prog) {
		return programmeService.updateProgramme(prog);
	}
	
	@GetMapping("/findProgrammesByAnnonce/{id}")
	public List<Programme> getAllprogrammeByAnnonce(@PathVariable(value = "id") Long id)
	{
		return  programmeService.getAllProgrammeByAnnonce(id);
	}
	@DeleteMapping("/deleteprogramme")
	public void deleteprogramme(@RequestBody Programme p)
	{
		programmeService.deleteProgramme(p);
	}
	
	@DeleteMapping("/deleteprogrammebyid/{id}")
	public void deleteprogrammebyid(@PathVariable(value = "id") Long id)
	{  
		programmeService.deleteProgrammeById(id);
		
	}
	
	

	
	
	

}
