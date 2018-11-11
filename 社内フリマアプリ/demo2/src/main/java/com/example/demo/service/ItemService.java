package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ItemRepository;
import com.example.demo.domain.Item;

@Service
@Transactional
public class ItemService {
	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> findAll() {
		return itemRepository.findAllItemOrderByName();
	}
	
	public Item findOne(Integer id) {
		return itemRepository.findOne(id);
	}
	
	public Item create(Item item) {
		return itemRepository.save(item);
	}
	
	public Item update(Item item) {
		return itemRepository.save(item);
	}
	
	public void dalete(Integer id) {
		itemRepository.delete(id);
	}
	
	public Page<Item> findAll(Pageable pageable) {
		return itemRepository.findAllItemOrderByName(pageable);
	}
}
