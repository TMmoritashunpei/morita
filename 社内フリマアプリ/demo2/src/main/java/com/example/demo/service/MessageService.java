package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Message;
import com.example.demo.domain.Purchase;
import com.example.demo.domain.User;
import com.example.demo.repository.MessageRepository;

@Service
@Transactional
public class MessageService {
	@Autowired
	MessageRepository messageRepository;
	
	public List<Message> findAll() {
		return messageRepository.findAllMessage();
	}
	
	public List<Message> findPurchaseMessage(Purchase purchase) {
		return messageRepository.findPurchaseMessage(purchase);
	}
	
	public List<Message> findPurchaseList(User user) {
		return messageRepository.findUserMessageList(user);
	}
	
	public List<Message> findItemPurchaseList(Purchase purchase) {
		return messageRepository.findIPurchaseMessageList(purchase);
	}
	
	public Message findOne(Integer id) {
		return messageRepository.findOne(id);
	}
	
	public Message create(Purchase purchase, User user, Message message) {
		message.setUser(user);
		message.setPurchase(purchase);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		message.setCreated_at(timestamp);
		message.setUpdated_at(timestamp);
		return messageRepository.save(message);
	}
	
	public Message update(Purchase purchase, User user,Message message) {
		message.setUser(user);
		message.setPurchase(purchase);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		message.setUpdated_at(timestamp);
		return messageRepository.save(message);
	}
	
	public void dalete(Integer id) {
		messageRepository.delete(id);
	}
}
