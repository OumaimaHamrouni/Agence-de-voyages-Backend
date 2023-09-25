package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ForfaitRepository;
import com.example.demo.entities.Forfait;


@Service
public class ForfaitServiceImp  implements ForfaitService{
	
    @Autowired
    ForfaitRepository forfaitrepositoy ;
 
	@Override
	public Forfait saveForfait(Forfait forfait) {
		
		return  forfaitrepositoy.save(forfait) ;
	}

	@Override
	public Forfait updateForfait(Forfait forfait) {
		
		return forfaitrepositoy.saveAndFlush(forfait) ;
	}

	@Override
	public void deleteForfait(Forfait forfait) {
		forfaitrepositoy.delete(forfait) ;
		
	}

	@Override
	public void deleteForfaitById(Long id) {
		forfaitrepositoy.deleteById(id) ;
		
	}

	@Override
	public Forfait getForfait(Long id) {
		
		return  forfaitrepositoy.findById(id).get() ;
	}

	@Override
	public List<Forfait> getAllForfaits() {
		return forfaitrepositoy.findAll() ;
	}
	

}
