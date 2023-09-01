package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MessageResponse;
import com.example.demo.model.CountryDTO;
import com.example.demo.model.LoginDTO;
import com.example.demo.model.PersonDTO;
import com.example.demo.model.SpecializationDTO;
import com.example.demo.model.UserInfoResponse;

import com.example.demo.repository.RoleRepo;
import com.example.demo.security.config.JwtUtils;
import com.example.demo.service.CountryService;
import com.example.demo.service.DeveloperService;
import com.example.demo.service.SpecializationService;
import com.example.demo.service.UserDetailsImpl;

@RestController
@RequestMapping("/api/users/auth")
@CrossOrigin(origins = "*")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	DeveloperService developerService;
	@Autowired
	CountryService countryService;
	@Autowired
	SpecializationService specializationService;
//	@Autowired
//	SpecializationService specializationService;



	@Autowired
	RoleRepo roleRepo;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	

	@PostMapping("/signup")
	public ResponseEntity<MessageResponse> saveDeveloper(@RequestBody PersonDTO person) {
		
		if (developerService.existsByUsername(person.getUsername())) {
		      return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		    }

	    developerService.saveDeveloper(person);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginDTO loginDto) {

		Authentication authentication = authenticationManager
		        .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
		        .body(new UserInfoResponse(userDetails.getUserid(),
		                                   userDetails.getUsername(),
		                                   roles));
	}
	
	@GetMapping("/getcountries")
	public List<CountryDTO> getAllCountries() {

		return countryService.getAllCountry();
	}
	
	
	@GetMapping("/getskill")
	public List<SpecializationDTO> getAllSkill(){
		return specializationService.getAllSpecialization();
	}
	
	@PostMapping("/insert")
	public ResponseEntity<SpecializationDTO> saveSpecialization(@RequestBody SpecializationDTO specializationDTO){
		specializationService.createSpecialization(specializationDTO);
		return new ResponseEntity<SpecializationDTO>(HttpStatus.CREATED);
		
	 }

//	@PostMapping("/signup")
//	public ResponseEntity<?> registerUser(@Valid @RequestBody LoginDTO loginDto) {
//		if (loginRepo.existsByUsername(loginDto.getUsername())) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
//		}
//
//		// Create new user's account
//		Login login = new Login(loginDto.getUsername(),
//
//				encoder.encode(loginDto.getPassword()));
//
//		Set<String> strRoles = loginDto.getRole();
//		Set<Role> roles = new HashSet<>();
//
//		if (strRoles == null) {
//			Role userRole = roleRepo.findByName(Erole.roleuser)
//					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//			roles.add(userRole);
//		} else {
//			strRoles.forEach(role -> {
//				switch (role) {
//				case "admin":
//					Role adminRole = roleRepo.findByName(Erole.roleadmin)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(adminRole);
//
//				}
//			});
//		}
//		login.setRoles(roles);
//		loginRepo.save(login);
//
//		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
//	}

	@PostMapping("/signout")
	public ResponseEntity<?> logoutUser() {
		ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
		return ResponseEntity.ok().body(cookie.toString());
	}

}
