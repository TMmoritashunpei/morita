package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;



@Service
public class LoginUserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException {
		User user = userRepository.findOne(username);
		if (user == null) {
			throw new UsernameNotFoundException("ユーザーがいません");
		}
		return new LoginUserDetails(user);
	}

}
