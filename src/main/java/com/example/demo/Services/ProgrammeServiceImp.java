package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProgrammeRepository;
import com.example.demo.entities.Programme;

@Service
public class ProgrammeServiceImp implements IProgrammeService {

	@Autowired
	ProgrammeRepository programmeRepository;

	@Override
	public Programme saveProgramme(Programme programme) {
		// TODO Auto-generated method stub
		return programmeRepository.save(programme);
	}

	@Override
	public Programme updateProgramme(Programme prog) {
		// TODO Auto-generated method stub
	/*	if (programmeRepository.findById(id).isPresent()) {
			 
			Programme programme= programmeRepository.findById(id).get();
			prog.setJour(programme.getJour());
			prog.setTitre(programme.getTitre());
			prog.setDescription(programme.getDescription());
			prog.setDestination(programme.getDestination());
			prog.setImage(programme.getImage());
			return programmeRepository.save(prog);}
			else
			{ 
				return null;
			}*/
		Programme programme= programmeRepository.saveAndFlush(prog);
		return programme;
	}

	@Override
	public void deleteProgramme(Programme programme) {
		// TODO Auto-generated method stub
		programmeRepository.delete(programme);
	}

	@Override
	public void deleteProgrammeById(Long id) {
		// TODO Auto-generated method stub
		programmeRepository.deleteById(id);
	}

	@Override
	public Programme getProgramme(Long id) {
		// TODO Auto-generated method stub
		return programmeRepository.findById(id).get() ;
	}

	@Override
	public List<Programme> getAllProgrammes() {
		// TODO Auto-generated method stub
		return programmeRepository.findAll();
	}

	@Override
	public List<Programme> getAllProgrammeByAnnonce(Long id) {
		// TODO Auto-generated method stub
		return programmeRepository.findProgrammesByAnnonce(id) ;
	}
	
	
	
	
}
