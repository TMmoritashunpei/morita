package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.domain.Category;
import com.example.demo.repository.CategoryRepository;

@Service
@Transactional
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAllCategoryOrderByName();
	}
	
	public Category findOne(Integer id) {
		return categoryRepository.findOne(id);
	}
	
	public Category create(Category categoty) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		categoty.setCreated_at(timestamp);
		return categoryRepository.save(categoty);
	}
	
	public Category update(Category categoty) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		categoty.setUpdated_at(timestamp);
		return categoryRepository.save(categoty);
	}
	
	public void dalete(Integer id) {
		categoryRepository.delete(id);
	}
	
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAllCategoryOrderByName(pageable);
	}
}
