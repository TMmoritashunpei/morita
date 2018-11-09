package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.repository.ItemRepository;
import com.example.demo.domain.Item;

public class ItemService {
	@Autowired
	ItemRepository itemrepository;
	
	public List<Item> findAll() {
		return itemrepository.findAllOrderByName();
	}
}
