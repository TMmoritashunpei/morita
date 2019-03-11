package com.example.demo.domain;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name ="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "items")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="username", nullable = false)
	private String username;
	@JsonIgnore
	private String password;
	private String tel;
	private String mail;
	@Column(name="comments")
	private String comments;
	@Column(name="slackname")
	private String slackname;
	/*itemと一対多の関係にする*/
	@Column(name="filename")
	private String filename;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Item> items;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Purchase> purchases;
	@Column(name="created_at")
	java.sql.Timestamp created_at;
	@Column(name="updated_at")
	java.sql.Timestamp updated_at;
}
