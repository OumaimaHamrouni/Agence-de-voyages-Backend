package com.example.demo.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.AuthResponse;
import com.example.demo.entities.CustomUserBean;
import com.example.demo.entities.Role;
import com.example.demo.entities.Roles;
import com.example.demo.entities.SignupRequest;
import com.example.demo.entities.User;
import com.example.demo.security.JwtTokenUtil;

@RestController
@CrossOrigin(origins="http://localhost:4200") 
@RequestMapping("/auth")
public class AuthController {
  @Autowired
  UserRepository userRepository;
  @Autowired
  RoleRepository roleRepository;
  @Autowired
  PasswordEncoder encoder;
  @Autowired
  AuthenticationManager authenticationManager;
  @Autowired
  JwtTokenUtil jwtTokenUtil;
  
  @PostMapping("/login")
  public ResponseEntity<?> userLogin(@Valid @RequestBody User user) {
    //System.out.println("AuthController -- userLogin");
    Authentication authentication = authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
    
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String token = jwtTokenUtil.generateJwtToken(authentication);
    CustomUserBean userBean = (CustomUserBean) authentication.getPrincipal();  
    System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
    System.out.println(userBean.getPrenom());
    List<String> roles = userBean.getAuthorities().stream()
                   .map(auth -> auth.getAuthority())
                   .collect(Collectors.toList());
    AuthResponse authResponse = new AuthResponse();
    authResponse.setToken(token);
    authResponse.setRoles(roles);
    authResponse.setEmail(userBean.getEmail());
    authResponse.setNom(userBean.getNom());
    authResponse.setPrenom(userBean.getPrenom());
    authResponse.setAdress(userBean.getAdress());
    authResponse.setId(userBean.getId());
  System.out.print(user.getRoles());
    return ResponseEntity.ok(authResponse);
  }
  
 
  
  
  //cote CLIENT
  
  @PostMapping("/newClient")
	public ResponseEntity<?> newClient(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUserName(signUpRequest.getUserName())) {
			return ResponseEntity
					.badRequest()
					.body("Error: Username is already taken!");
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body("Error: Email is already in use!");
		}
		// Create new user's account
		User user = new User( signUpRequest.getUserName() ,
				signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()) ,signUpRequest.getNom() , signUpRequest.getPrenom(), signUpRequest.getAdress());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();


		if (strRoles == null) {
			Role userRole = roleRepository.findByRoleName(Roles.ROLE_CLIENT)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {


					case "reception":
						Role receptionRole = roleRepository.findByRoleName(Roles.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(receptionRole);
						break;

				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok("Client registered successfully!");
	}
 
  
  
  
  

  //cote RESPONSABLE
  
  @PostMapping("/newResponsable")
	public ResponseEntity<?> newResponsable(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUserName(signUpRequest.getUserName())) {
			return ResponseEntity
					.badRequest()
					.body("Error: Username is already taken!");
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body("Error: Email is already in use!");
		}
		// Create new user's account
				User user = new User( signUpRequest.getUserName() ,
						signUpRequest.getEmail(),
						encoder.encode(signUpRequest.getPassword()) ,signUpRequest.getNom() , signUpRequest.getPrenom(), signUpRequest.getAdress());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();


		if (strRoles == null) {
			Role userRole = roleRepository.findByRoleName(Roles.ROLE_RESPONSABLE)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {


					case "reception":
						Role receptionRole = roleRepository.findByRoleName(Roles.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(receptionRole);
						break;

				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);
		return ResponseEntity.ok("responsable registered successfully!");
	}
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}