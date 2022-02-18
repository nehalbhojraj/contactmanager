package com.mycom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mycom.entities.User;
import com.mycom.repo.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService{
      
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=repository.getUserByUserName(username);
		if(user == null) {
			
			throw new UsernameNotFoundException("Could not found user");
			
		}
		CustomUserDetails customUserDetails=new CustomUserDetails(user);
		
		return customUserDetails;
	}

}
