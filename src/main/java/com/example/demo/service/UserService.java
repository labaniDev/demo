package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Person;
import com.example.demo.model.PersonDTO;
import com.example.demo.repository.DeveloperRepo;

@Service
@EnableCaching
public class UserService {

	@Autowired
	DeveloperRepo developerRepo;
	@Autowired
	ModelMapper modelMapper;
   
	
	@Cacheable("person")
	public List<PersonDTO> getAllPerson() {

		List<Person> userlist = developerRepo.findAll();

		List<PersonDTO> personDTOlist = modelMapper.map(userlist, new TypeToken<List<PersonDTO>>() {
		}.getType());
		return personDTOlist;

	}

	public int updateUser(PersonDTO person) {
		Optional<Person> user = developerRepo.findById(person.getUserid());

		if (user.isPresent()) {
			Person updateUser = modelMapper.map(person, Person.class);
			developerRepo.save(updateUser);
			return 1;
		}
		return 0;

	}
	
	public int deletePerson(Integer userid) {
		
		 
		Optional<Person> user=developerRepo.findById(userid);
		if(user.isPresent()) {
			developerRepo.deleteById(userid);
		   
		   return 1;
		
	}
		return 0;

}
}

//	public static void main(String args[]) {
//
//		String temp = "Sat Jul 29 09:37:43 GMT+05:30 2023";
//		String end = "Sat Jul 29 05:37:43 GMT+05:30 2023";
//		Date date = null;
//
//		// SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz
//		// yyyy");
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzzz yyyy");
//		LocalDateTime startdateTime = LocalDateTime.parse(temp, format);
//
//		LocalDateTime enddateTime = LocalDateTime.parse(end, format);
//
//		LocalTime localTime = startdateTime.toLocalTime();
//
//		LocalTime endlocalTime = enddateTime.toLocalTime();
//		LocalTime local = LocalTime.now();
//
//		Duration duration = Duration.between(endlocalTime, localTime);
//		Duration duration1 = Duration.between(localTime, startdateTime);
//
//		java.sql.Time start_time = java.sql.Time.valueOf(localTime);
//
//		System.out.println(duration.getSeconds());
////	 System.out.println(date.getMonth());
////	 System.out.println(date.getDay());
////	 System.out.println(date.getYear());
////	 System.out.println(date.getTime());
//
//	}
//
//}
