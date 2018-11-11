package com.example.demo.service;

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
	
	public Category create(Category Categoty) {
		return categoryRepository.save(Categoty);
	}
	
	public Category update(Category Categoty) {
		return categoryRepository.save(Categoty);
	}
	
	public void dalete(Integer id) {
		categoryRepository.delete(id);
	}
	
	public Page<Category> findAll(Pageable pageable) {
		return categoryRepository.findAllCategoryOrderByName(pageable);
	}
}
