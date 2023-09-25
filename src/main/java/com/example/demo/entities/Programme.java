package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@RequiredArgsConstructor
@Table(name = "programme")
public class Programme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
private Long id ;

private String titre;
private String jour;
@Lob
private String destination ;
@Lob
private String description;
@Lob
private String image;

@ManyToOne
private Annonce annonce;


}
