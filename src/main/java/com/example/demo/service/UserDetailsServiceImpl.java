//package com.example.demo.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.demo.entity.Login;
//
//import com.example.demo.repository.LoginRepo;
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//	@Autowired
//	LoginRepo loginRepo;
//
//	
//     
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Login login=loginRepo.findByUsername(username);
//		if (login == null) {
//            throw new UsernameNotFoundException(username);
//        }
//		return new UserDetailsImpl(login);
//	}
//
//}
