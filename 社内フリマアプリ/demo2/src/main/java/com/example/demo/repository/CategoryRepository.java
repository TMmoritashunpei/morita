package com.example.demo.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query("SELECT x FROM Category x ORDER BY x.categoryname")
	List<Category> findAllCategoryOrderByName();
	@Query("SELECT x FROM Category x ORDER BY x.categoryname")
    Page<Category> findAllCategoryOrderByName(Pageable pageable);
}
