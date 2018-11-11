package com.example.demo.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue
	private Integer itemId;
	private String itemname;
	private Integer price;
	private String condition;
	private String payment;
	private Integer stock;
	private String coments;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "username")
	private User user; 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "categoryId")
	private Category category; 
}
