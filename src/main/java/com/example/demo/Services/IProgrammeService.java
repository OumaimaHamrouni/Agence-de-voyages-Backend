package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Programme;


public interface IProgrammeService  {
	Programme saveProgramme(Programme programme);
	Programme updateProgramme(Programme programme);
	void deleteProgramme(Programme programme);
	void deleteProgrammeById(Long id);
	Programme getProgramme(Long id);
	List<Programme> getAllProgrammes();
	List<Programme> getAllProgrammeByAnnonce(Long id);


}
