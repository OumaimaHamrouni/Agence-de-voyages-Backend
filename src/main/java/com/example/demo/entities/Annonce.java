package com.example.demo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import lombok.*;

@AllArgsConstructor
@Data
@Entity
@RequiredArgsConstructor
public class Annonce {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Lob
	private String titre;
	@Lob
	private String destination; 
	private Float prix;
	private Date date_debut;
	private Date date_fin;
  
	@Lob
	private String image ;
	@Lob
	private String description;
	@ManyToOne
	private Forfait forfait;
	
	
	
}
