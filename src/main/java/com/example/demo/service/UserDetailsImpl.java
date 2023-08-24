package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import com.example.demo.entity.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDetailsImpl implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6415638262818325588L;

	private Integer userid;
	private String username;

	@JsonIgnore
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;

	
	
	 public UserDetailsImpl( Integer userid,String username, String password,
		      Collection<? extends GrantedAuthority> authorities) {
		 	this.userid=userid;
		    this.username = username;
		    this.password = password;
		    this.authorities = authorities;
		  }
	 
	 
	 
	 public static UserDetailsImpl build(Person user) {
		    List<GrantedAuthority> authorities = user.getRoles().stream()
		        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
		        .collect(Collectors.toList());

		    return new UserDetailsImpl(
		    	user.getUserid(),
		        user.getUsername(), 
		        user.getPassword(), 
		        authorities);
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
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
