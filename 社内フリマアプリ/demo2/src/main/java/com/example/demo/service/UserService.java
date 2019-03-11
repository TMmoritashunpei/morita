package com.example.demo.service;

import java.sql.Timestamp;
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
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		user.setCreated_at(timestamp);
		return userRepository.save(user);
	}
	
	public User update(User user) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		user.setUpdated_at(timestamp);
		return userRepository.save(user);
	}
	
	public void dalete(String name) {
		userRepository.delete(name);
	}
	
	public Page<User> findAll(Pageable pageable) {
		return userRepository.findAllUserOrderByName(pageable);
	}
}
