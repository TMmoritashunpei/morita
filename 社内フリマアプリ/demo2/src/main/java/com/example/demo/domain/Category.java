package com.example.demo.domain;

import java.util.List;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categorys")
@ToString(exclude ="items")
public class Category {
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer categoryId;
	@Column(name="category_name")
	private String categoryname;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category")
	private List<Item> items;
	@Column(name="created_at")
	java.sql.Timestamp created_at;
	@Column(name="updated_at")
	java.sql.Timestamp updated_at;
}
