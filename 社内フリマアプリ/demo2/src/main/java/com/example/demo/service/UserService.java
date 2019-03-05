package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAllUserOrderByName();
	}
	
	public User findOne(String name) {
		return userRepository.findOne(name);
	}
	
	public User findByUserId(Integer id) {
		return userRepository.findByUserId(id);
	}
	
	public User create(User user) {
		return userRepository.save(user);
	}
	
	public User update(User user) {
		return userRepository.save(user);
	}
	
	public void dalete(String name) {
		userRepository.delete(name);
	}
	
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAllUserOrderByName(pageable);
	}
}
