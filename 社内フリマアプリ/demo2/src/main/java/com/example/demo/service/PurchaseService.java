package com.example.demo.service;

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
	
	public Purchase findOne(Integer id) {
		return purchaseRepository.findOne(id);
	}
	
	public Purchase create(Purchase purchase, User user, Item item) {
		purchase.setUser(user);
		purchase.setItem(item);
		return purchaseRepository.save(purchase);
	}
	
	public Purchase update(Purchase purchase, User user) {
		purchase.setUser(user);
		return purchaseRepository.save(purchase);
	}
	
	public void dalete(Integer id) {
		purchaseRepository.delete(id);
	}
}
