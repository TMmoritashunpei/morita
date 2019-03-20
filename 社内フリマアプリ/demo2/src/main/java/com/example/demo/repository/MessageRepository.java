package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.domain.Message;
import com.example.demo.domain.Purchase;
import com.example.demo.domain.User;


public interface MessageRepository extends JpaRepository <Message, Integer>{
	@Query("SELECT x FROM Message x ORDER BY x.created_at")
	List<Message> findAllMessage(); 
	
	@Query("SELECT x FROM Message x  where x.purchase = :purchase ORDER BY x.created_at")
	List<Message> findPurchaseMessage(@Param("purchase") Purchase purchase); 
	
	@Query("SELECT x FROM Message x where x.user = :user")
	List<Message> findUserMessageList(@Param("user") User user); 
	
	@Query("SELECT x FROM Message x where x.purchase = :purchase")
	List<Message> findIPurchaseMessageList(@Param("purchase") Purchase purchase); 
}

