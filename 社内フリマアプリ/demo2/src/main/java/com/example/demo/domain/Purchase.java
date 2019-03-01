package com.example.demo.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchases")
public class Purchase {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer purchaseId;
	@Column(name = "purchase_name")
	private String purchasename;
	@Column(name ="stock")
	private Integer stock;
	@Column(name = "filename")
	private String filename;
	@Column(name = "cansellflg")
	private Boolean cansellflg = false;
	@Column(name = "purchaseflg")
	private Boolean purchaseflg = false;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "item_id", updatable=false)
	private Item item;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "user_id", updatable=false)
	private User user;
	@Column(name="created_at")
	java.sql.Timestamp created_at;
	@Column(name="updated_at")
	java.sql.Timestamp updated_at;
}
