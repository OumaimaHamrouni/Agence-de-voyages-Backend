package com.example.demo.entities;

import java.util.Date;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.*;
import javax.persistence.*;



@AllArgsConstructor
@Data
@Entity
@RequiredArgsConstructor

public class Forfait {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Lob
	private String inclut ;
	@Lob
	private String noninclut ;

}
