package com.example.demo.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Annonce;
import com.example.demo.entities.Programme;


public interface IAnnonceService {

	Annonce saveAnnonce(Annonce annonce);
	Annonce updateAnnonce(Annonce annonce);
	void deleteAnnonce(Annonce annonce);
	void deleteAnnonceById(Long id);
	Annonce getAnnonce(Long id);
	List<Annonce> getAllAnnonce();
	List<Annonce> searchAnnonce(String s);
	
}
