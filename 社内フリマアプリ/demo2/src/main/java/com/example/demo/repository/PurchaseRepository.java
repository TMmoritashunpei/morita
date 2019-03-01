package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Purchase;


public interface PurchaseRepository extends JpaRepository <Purchase, Integer>{
	@Query("SELECT x FROM Purchase x ORDER BY x.purchasename")
	List<Purchase> findAllPurchaseName(); 
	
	@Query("SELECT x FROM Purchase x WHERE x.purchaseId =:purchaseId")
	Purchase findByPurchase(@Param("purchaseId") Integer purchaseId);
	
}

