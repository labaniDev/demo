//package com.example.demo.controller;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import javax.validation.Valid;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseCookie;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.entity.Erole;
//import com.example.demo.entity.Login;
//import com.example.demo.entity.MessageResponse;
//import com.example.demo.entity.Role;
//import com.example.demo.model.LoginDTO;
//import com.example.demo.repository.LoginRepo;
//import com.example.demo.repository.RoleRepo;
//import com.example.demo.security.config.JwtUtils;
//import com.example.demo.service.UserDetailsImpl;
//
//@RestController
//@RequestMapping("/api/users/auth")
//public class AuthController {
//	
//	 @Autowired
//	  AuthenticationManager authenticationManager;
//
//	  @Autowired
//	 LoginRepo loginRepo;
//
//	  @Autowired
//	  RoleRepo roleRepo;
//
//	  @Autowired
//	  PasswordEncoder encoder;
//
//	  @Autowired
//	  JwtUtils jwtUtils;
//	  @Autowired
//	  Login login;
//	  
//	  @PostMapping("/signin")
//	  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginDto) {
//
//	    org.springframework.security.core.Authentication authentication = authenticationManager
//	        .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
//
//	    SecurityContextHolder.getContext().setAuthentication(authentication);
//
//	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//
//	    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
//
//	    List<String> roles = userDetails.getAuthorities().stream()
//	        .map(item -> item.getAuthority())
//	        .collect(Collectors.toList());
//
//	    return ResponseEntity.ok()
//	        .body(jwtCookie.toString());
//	  }
//	  @PostMapping("/signup")
//	  public ResponseEntity<?> registerUser(@Valid @RequestBody LoginDTO loginDto) {
//	    if (loginRepo.existsByUsername(loginDto.getUsername())) {
//	      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
//	    }
//
//	    // Create new user's account
//	   Login login=new Login(loginDto.getUsername(), 
//	               
//	               encoder.encode(loginDto.getPassword()));
//
//	    
//	    Set<String> strRoles = loginDto.getRole();
//	    Set<Role> roles = new HashSet<>();
//
//	    if (strRoles == null) {
//	      Role userRole = roleRepo.findByName(Erole.roleuser)
//	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//	      roles.add(userRole);
//	    } else {
//	      strRoles.forEach(role -> {
//	        switch (role) {
//	        case "admin":
//	            Role adminRole = roleRepo.findByName(Erole.roleadmin)
//	                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//	            roles.add(adminRole);
//
//	           
//	           
//	          }
//	        });
//	      }
//	    login.setRoles(roles);
//	    loginRepo.save(login);
//
//	    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//	  }
//	  @PostMapping("/signout")
//	  public ResponseEntity<?> logoutUser() {
//	    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
//	    return ResponseEntity.ok()
//	        .body(cookie.toString());
//	  }
//
//	 
//	
//	        }
//
//
