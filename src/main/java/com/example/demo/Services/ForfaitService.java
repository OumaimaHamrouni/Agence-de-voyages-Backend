package com.example.demo.Services;

import java.util.List;

import com.example.demo.entities.Forfait;

public interface ForfaitService {
	
	Forfait saveForfait(Forfait forfait);
	Forfait updateForfait(Forfait forfait);
	void deleteForfait(Forfait forfait);
	void deleteForfaitById(Long id);
	Forfait getForfait(Long id);
	List<Forfait> getAllForfaits();


}
