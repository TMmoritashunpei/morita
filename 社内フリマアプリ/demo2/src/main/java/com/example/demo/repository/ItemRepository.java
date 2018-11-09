package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import com.example.demo.domain.Item;
import org.springframework.data.domain.Pageable;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	@Query("SELECT x FROM Item x ORDER BY x.itemname")
	List<Item> findAllOrderByName();
	@Query("SELECT x FROM Item x ORDER BY x.itemname")
    Page<Item> findAllOrderByName(Pageable pageable);
}
