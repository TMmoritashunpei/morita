package com.example.demo.web;

import com.example.demo.domain.Category;

import lombok.Data;

@Data
public class ItemForm {
	private String itemname;
	private Integer price;
	private String condition;
	private String payment;
	private Integer stock;
	private String comments;
	private Category category; 
	private Integer purchasenumber;
}
