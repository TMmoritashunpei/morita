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
	@Column(name="id")
	private Integer itemId;
	@Column(name="item_name")
	private String itemname;
	private Integer price;
	private String condition;
	private String payment;
	private Integer stock;
	@Column(name="comments")
	private String comments;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "user_id")
	private User user; 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "category_Id")
	private Category category; 
}
