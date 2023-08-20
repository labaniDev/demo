package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CountryDTO;
import com.example.demo.model.PersonDTO;
import com.example.demo.service.CountryService;
import com.example.demo.service.DeveloperService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	CountryService countryService;

	@Autowired
	DeveloperService developerService;
//	@Autowired
//	LoginService loginService;
	@Autowired
	UserService userService;

//   to save data into database
	

//to get all the countries from database
	@GetMapping("/getcountries")
	public List<CountryDTO> getAllCountries() {

		return countryService.getAllCountry();
	}



//	@PostMapping("/login")
//	public ResponseEntity<Boolean> getAllLogin(@RequestBody LoginDTO login) {
//
//		loginService.loginPage(login);
//
//		return new ResponseEntity<Boolean>(loginService.loginPage(login), HttpStatus.OK);
//
//	}

// to get all users from database
	@GetMapping("/showallusers")
	public List<PersonDTO> getAllUsers() {
		return userService.getAllPerson();
	}

//	to update data into the database
	@PostMapping("/updateuser")
	public ResponseEntity<PersonDTO> updateAllUser(@RequestBody PersonDTO person) {
		userService.updateUser(person);
		return new ResponseEntity<PersonDTO>(HttpStatus.OK);
	}

//		to delete data into database
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<Boolean> deleteAllPerson(@PathVariable("userid") Integer userid) {
		userService.deletePerson(userid);
		return new ResponseEntity<Boolean>(HttpStatus.OK);
	}


//	@PostMapping("/save")
//	public ResponseEntity<Boolean> saveAllDeveloper(@RequestBody PersonDTO person) {
//		developerService.saveDeveloper(person);
//		return new ResponseEntity<Boolean>(HttpStatus.OK);
//	}

}
