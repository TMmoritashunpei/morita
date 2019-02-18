package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;

import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import org.springframework.data.domain.Pageable;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	@Query("SELECT x FROM Item x ORDER BY x.itemname")
	List<Item> findAllItemOrderByName();
	
	@Query("SELECT x FROM Item x ORDER BY x.itemname")
    Page<Item> findAllItemOrderByName(Pageable pageable);
	
	@Query("SELECT x FROM Item x where x.itemId = :itemId")
	Item findByItem(@Param("itemId") Integer itemId);
	
	@Query("SELECT x FROM Item x where x.category =  :category")
	List<Item> itemInCategory(@Param("category") Category category);
	
	@Query("SELECT x FROM Item x where x.itemname like  %:itemname%")
	List<Item> itemNameSerch(@Param("itemname") String itemname);
	
	@Query("SELECT x FROM Item x where x.itemname like  %:itemname% and x.category = :category")
	List<Item> itemInCategoryInItemSerch(@Param("itemname") String itemname, @Param("category") Category category);
}
