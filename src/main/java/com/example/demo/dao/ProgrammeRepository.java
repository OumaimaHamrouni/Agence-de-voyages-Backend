package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.entities.Programme;

@RepositoryRestResource
public interface ProgrammeRepository extends JpaRepository<Programme,Long> {
	@RestResource(path="findProgrammesByAnnonce")
	@Query("select p from Programme p where  p.annonce.id=:id ")
	List<Programme> findProgrammesByAnnonce(@Param("id") Long id);
//zzzz
}
