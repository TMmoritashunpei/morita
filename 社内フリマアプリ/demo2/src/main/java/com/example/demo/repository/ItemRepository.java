package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import com.example.demo.domain.Item;

public class ItemRepository {
	private final ConcurrentMap<Integer, Item> ItemMap = new ConcurrentHashMap<>();
	
	public List<Item> findAll() {
		return new ArrayList<>(ItemMap.values());
	}
	
	public Item findOne(Integer itemId) {
		return ItemMap.get(itemId);
	}
	
	public void delete(Integer itemId) {
		
	}
}
