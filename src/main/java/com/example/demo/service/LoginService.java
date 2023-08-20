//package com.example.demo.service;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.Login;
//import com.example.demo.model.LoginDTO;
//import com.example.demo.repository.LoginRepo;
//
//
//@Service
//public class LoginService {
//	@Autowired
//	ModelMapper modelMapper;
//	@Autowired
//	LoginRepo loginRepo;
//	public boolean loginPage(LoginDTO loginDTO) {
//		//Login developer1=modelMapper.map(L, Login.class);
//		Login login=loginRepo.findByUsernameAndPassword(loginDTO.getUsername(),loginDTO.getPassword());
//		
//		if(login!=null) {
//			return true;
//		}else {
//			return false;
//		}
//	}
//
//}
