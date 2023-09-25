package com.example.demo.entities;

import java.util.List;

public class AuthResponse {
	  private String token;
	  private List<String> roles;
private String email ;
private Integer id; 
private String userName; 
private String nom ;
private String prenom ;
private String adress ;

	  public String getToken() {
	    return token;
	  }

	  public void setToken(String token) {
	    this.token = token;
	  }

	  public List<String> getRoles() {
	    return roles;
	  }

	  public void setRoles(List<String> roles) {
	    this.roles = roles;
	  }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	} 
	  
	  
	  
	  
	}