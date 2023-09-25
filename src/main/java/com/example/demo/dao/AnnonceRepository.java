package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.entities.Annonce;
import com.example.demo.entities.Forfait;
import com.example.demo.entities.Programme;

@RepositoryRestResource
public interface AnnonceRepository extends JpaRepository <Annonce, Long> {

	
	
	@RestResource(path="findAnnonceBySearch")
	@Query("select a from Annonce a where  a.titre=:s or a.destination=:s")
	List<Annonce> findAnnonce(@Param("s") String s);
}
