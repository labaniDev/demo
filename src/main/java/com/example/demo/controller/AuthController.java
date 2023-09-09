package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MessageResponse;
//import com.example.demo.entity.RefreshToken;
import com.example.demo.entity.TokenRefreshException;
import com.example.demo.model.CountryDTO;
import com.example.demo.model.LoginDTO;
import com.example.demo.model.PersonDTO;
import com.example.demo.model.ProjectDTO;
import com.example.demo.model.RoleDTO;
import com.example.demo.model.SpecializationDTO;
import com.example.demo.model.UserInfoResponse;

import com.example.demo.repository.RoleRepo;
import com.example.demo.security.config.JwtUtils;
import com.example.demo.service.CountryService;
import com.example.demo.service.DeveloperService;
import com.example.demo.service.ProjectService;
//import com.example.demo.service.RefreshTokenService;
import com.example.demo.service.RoleService;
import com.example.demo.service.SpecializationService;
import com.example.demo.service.UserDetailsImpl;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/auth")
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
	@Autowired
	UserService userService;
	
//	@Autowired
//    RefreshTokenService refreshTokenService;

	@Autowired
	RoleRepo roleRepo;
	@Autowired
	RoleService roleService;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	 ProjectService projectService;
	
	@PostMapping("/createProject")
	public ResponseEntity<Object> createProject(@RequestBody ProjectDTO project) {

		projectService.createProject(project);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	@GetMapping("/viewProject")
	public List<ProjectDTO> viewAllProjects(){
		
		
		return projectService.getAllProjects();
	}
	
	@PutMapping("/editProject/{pid}")	
	public ResponseEntity<String> updateProject(@PathVariable("pid")Integer pid,@RequestBody ProjectDTO project){
		projectService.updateProject(pid, project);
		return new ResponseEntity<String>("Updated Successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteProject/{pid}")
	public String deleteProject(@PathVariable("pid") Integer pid) {
		projectService.deleteProject(pid);
		return "Project Successfully Deleted";
	}
	

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
		
		//System.out.println(request.getCookies());

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		String jwt = jwtUtils.generateJwtCookie(userDetails);

		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

	//	return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
		return ResponseEntity.ok().body(new UserInfoResponse(userDetails.getUserid(),
		                                   userDetails.getUsername(),
		                                   roles,jwt));
	}
//	 @PostMapping("/refreshtoken")
//	  public ResponseEntity<?> refreshtoken(HttpServletRequest request) {
//	    String refreshToken = jwtUtils.getJwtFromCookies(request);
//	    
//	    if ((refreshToken != null) && (refreshToken.length() > 0)) {
//	      return refreshTokenService.findByToken(refreshToken)
//	          .map(refreshTokenService::verifyExpiration)
//	          .map(RefreshToken::getUser)
//	          .map(user -> {
//            ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userPrincipal);
//	            
//	            return ResponseEntity.ok()
//	                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
//	                .body(new MessageResponse("Token is refreshed successfully!"));
//	          })
//	          .orElseThrow(() -> new TokenRefreshException(refreshToken,
//	              "Refresh token is not in database!"));
//	    }
//	    
//	    return ResponseEntity.badRequest().body(new MessageResponse("Refresh Token is empty!"));
//	  }
	


	@GetMapping("/getcountries")
	public List<CountryDTO> getAllCountries() {

		return countryService.getAllCountry();
	}
	
	
	
	@GetMapping("/getskill")
	public List<SpecializationDTO> getAllSkill(){
		return specializationService.getAllSpecialization();
	}
	
	@PostMapping("/insertskill")
	public ResponseEntity<SpecializationDTO> saveSpecialization(@RequestBody SpecializationDTO specializationDTO){
		specializationService.createSpecialization(specializationDTO);
		return new ResponseEntity<SpecializationDTO>(HttpStatus.CREATED);
		
	 }
	@PostMapping("/createrole")
	public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO) {
		roleService.saveRole(roleDTO);
		return new ResponseEntity<RoleDTO>(HttpStatus.CREATED);
	}
	
	@GetMapping("/getrole")
	public List<RoleDTO> getAllrole(){
		return roleService.getAllRole();
	}
	@PostMapping("/archieveProject/{pid}")
	public ResponseEntity<String> archieveProject(@PathVariable("pid") Integer pid) {
		projectService.archiveOldProjects(pid);
		return  ResponseEntity.ok("Project Archieved Successfully");
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
