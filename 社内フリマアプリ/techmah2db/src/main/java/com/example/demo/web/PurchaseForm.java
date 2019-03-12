package com.example.demo.web;

import lombok.Data;

@Data
public class PurchaseForm {
	private Integer purchaseId;
	private String purchasename;
	private Integer stock;
	private Boolean cansellflg;
	private Boolean purchaseflg;
	
}
