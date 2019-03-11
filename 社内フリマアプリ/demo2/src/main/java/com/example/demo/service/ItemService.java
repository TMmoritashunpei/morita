package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ItemRepository;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.User;

@Service
@Transactional
public class ItemService {
	@Autowired
	ItemRepository itemRepository;
	
	public List<Item> findAll() {
		return itemRepository.findAllItemOrderByName();
	}
	
	public List<Item> findEhibitList(User user) {
		return itemRepository.findAllExhibitList(user);
	}
	
	public Item findOne(Integer id) {
		return itemRepository.findOne(id);
	}
	
	public Item create(Item item, User user) {
		item.setUser(user);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		item.setCreated_at(timestamp);
		item.setUpdated_at(timestamp);
		return itemRepository.save(item);
	}
	
	public Item update(Item item, User user) {
		item.setUser(user);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		item.setUpdated_at(timestamp);
		return itemRepository.save(item);
	}
	
	public void dalete(Integer id) {
		itemRepository.delete(id);
	}
	
	public Page<Item> findAll(Pageable pageable) {
		return itemRepository.findAllItemOrderByName(pageable);
	}
	public List<Item> findCategoryInItem(Category category) {
		return itemRepository.itemInCategory(category);
	}
	public List<Item> findItemNameSerch(String itemname) {
		return itemRepository.itemNameSerch(itemname);
	}
	public List<Item> itemNameInCategory( String itemname, Integer categoryId) {
		return itemRepository.itemInCategoryInItemSerch(itemname, categoryId);
	}
}
	
