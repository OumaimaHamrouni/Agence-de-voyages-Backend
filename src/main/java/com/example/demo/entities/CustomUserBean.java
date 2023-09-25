package com.example.demo.entities;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CustomUserBean implements UserDetails {
  private static final long serialVersionUID = -4709084843450077569L;  
  private Integer id; 
  private String userName; 
  private String email;
  private String nom ;
  private String prenom ;
  private String adress ;
  @JsonIgnore
  private String password;
  private Collection<? extends GrantedAuthority> authorities;
  CustomUserBean(Integer id, String userName, String email, 
      String password,String adress , String nom , String prenom, Collection<? extends GrantedAuthority> authorities){
    this.id = id;
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.adress = adress ;
    this.nom  = nom ;
    this.prenom = prenom ;
    
    this.authorities = authorities;
  }
  
  public static CustomUserBean createInstance(User user) {
    List<GrantedAuthority> authorities = user.getRoles()
                     .stream()
                         .map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                      .collect(Collectors.toList());
    return new CustomUserBean(user.getId(), user.getUserName(), 
        user.getEmail(), user.getPassword(),user.getAdress(),user.getNom(),user.getPrenom(), authorities);
  }
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return userName;
  }

  public Integer getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
  @Override
  public boolean equals(Object rhs) {
    if (rhs instanceof CustomUserBean) {
      return userName.equals(((CustomUserBean) rhs).userName);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return userName.hashCode();
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

public void setId(Integer id) {
	this.id = id;
}

public void setEmail(String email) {
	this.email = email;
}

public void setPassword(String password) {
	this.password = password;
}
  
  
  
  
}