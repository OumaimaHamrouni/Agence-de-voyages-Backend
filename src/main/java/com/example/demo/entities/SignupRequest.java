package com.example.demo.entities;

import java.util.Set;

public class SignupRequest {
	private String userName; 
	private String email;
	private String password;
	  private String adress ;
	  
	  private String nom ;
	  private String prenom ; 
	  
	private Set<String> roles;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 public Set<String> getRole() {
	      return this.roles;
	    }
	    
	    public void setRole(Set<String> role) {
	      this.roles = role;
	    }
		public String getAdress() {
			return adress;
		}
		public void setAdress(String adress) {
			this.adress = adress;
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
	    
	    
	    
	    
	    
}