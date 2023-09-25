package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id; 
  @Column(name="name")
  private String userName; 
  @Column(name="email")
  private String email;
  
  private String adress ;
  
  private String nom ;
  private String prenom ;
  
  
  
  
  @Column(name="password")
  private String password;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_role", 
      joinColumns = @JoinColumn(name="USER_ID", referencedColumnName="ID"),
      inverseJoinColumns = @JoinColumn(name="ROLE_ID", referencedColumnName="ID"))
  private Set<Role> roles = new HashSet<>();
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
  public Set<Role> getRoles() {
    return roles;
  }
  public void setRoles(Set<Role> roles) {
    this.roles = roles;
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
	public User( String userName, String email, String password , String nom , String prenom , String adress) {
		
		this.userName = userName;
		this.email = email;
		this.password = password;
	
		this.nom = nom ;
		this.prenom = prenom ;
		this.adress = adress ;}
  
  
public User() {
		
	
	}
  
 
  
}