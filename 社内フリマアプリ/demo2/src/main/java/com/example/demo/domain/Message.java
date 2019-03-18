package com.example.demo.domain;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer messageId;
	@Column(name = "message")
	private String message;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "purchase_id", updatable=false)
	private Purchase purchase;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "user_id", updatable=false)
	private User user;
	@Column(name="created_at")
	java.sql.Timestamp created_at;
	@Column(name="updated_at")
	java.sql.Timestamp updated_at;
}
