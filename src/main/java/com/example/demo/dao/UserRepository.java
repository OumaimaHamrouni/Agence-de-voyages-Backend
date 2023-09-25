package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Annonce;
import com.example.demo.entities.Programme;
import com.example.demo.entities.User;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Integer>{
  public Optional<User> findByUserName(String userName);
  public boolean existsByEmail(String email);
  public boolean existsByUserName(String userName);

  
}