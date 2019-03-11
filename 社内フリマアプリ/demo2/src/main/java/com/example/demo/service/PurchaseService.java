package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Item;
import com.example.demo.domain.Purchase;
import com.example.demo.domain.User;
import com.example.demo.repository.PurchaseRepository;

@Service
@Transactional
public class PurchaseService {
	@Autowired
	PurchaseRepository purchaseRepository;
	
	public List<Purchase> findAll() {
		return purchaseRepository.findAllPurchaseName();
	}
	
	public List<Purchase> findPurchaseList(User user) {
		return purchaseRepository.findUserPurchasList(user);
	}
	
	public List<Purchase> findItemPurchaseList(Item item) {
		return purchaseRepository.findItemPurchasList(item);
	}
	
	public Purchase findOne(Integer id) {
		return purchaseRepository.findOne(id);
	}
	
	public Purchase create(Purchase purchase, User user, Item item) {
		purchase.setUser(user);
		purchase.setItem(item);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		purchase.setCreated_at(timestamp);
		return purchaseRepository.save(purchase);
	}
	
	public Purchase update(Purchase purchase, User user) {
		purchase.setUser(user);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		purchase.setUpdated_at(timestamp);
		return purchaseRepository.save(purchase);
	}
	
	public void dalete(Integer id) {
		purchaseRepository.delete(id);
	}
}
