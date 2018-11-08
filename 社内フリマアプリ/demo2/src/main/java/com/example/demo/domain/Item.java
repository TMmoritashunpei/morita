package com.example.demo.domain;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item implements Serializable {
	private Integer itemId;
	private String itemName;
	private Integer price;
	//praivate Ctegory ctegory;
	private String condition;
	private String payment;
	private Integer stock;
	private String coments;
}
