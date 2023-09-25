package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AnnonceRepository;
import com.example.demo.dao.ForfaitRepository;
import com.example.demo.entities.Annonce;
import com.example.demo.entities.Programme;

@Service
public class AnnonceServiceImp   implements IAnnonceService {
	
	  @Autowired
	    AnnonceRepository annoncerepositoy ;

	@Override
	public Annonce saveAnnonce(Annonce annonce) {
		return  annoncerepositoy.save(annonce) ;
	}

	@Override
	public Annonce updateAnnonce(Annonce annonce) {
		return  annoncerepositoy.saveAndFlush(annonce) ;
	}

	@Override
	public void deleteAnnonce(Annonce annonce) {
		 annoncerepositoy.delete(annonce);
		
	}

	@Override
	public void deleteAnnonceById(Long id) {
		 annoncerepositoy.deleteById(id);
		
	}

	@Override
	public Annonce getAnnonce(Long id) {
		return annoncerepositoy.findById(id).get() ;
	}

	@Override
	public List<Annonce> getAllAnnonce() {
		 return annoncerepositoy.findAll() ;
	}
	
	@Override
	public List<Annonce> searchAnnonce(String s) {
		return  annoncerepositoy.findAnnonce(s);
	}

}
