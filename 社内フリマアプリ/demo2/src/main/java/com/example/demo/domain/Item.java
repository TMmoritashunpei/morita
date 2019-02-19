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
	@Column(name="conditions")
	private String condition;
	@Column(name="payment")
	private String payment;
	@Column(name="stock")
	private Integer stock;
	@Column(name="comments")
	private String comments;
	@Column(name="filename")
	private String filename;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "user_id", updatable=false)
	private User user; 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "category_Id", updatable=false)
	private Category category; 
}
