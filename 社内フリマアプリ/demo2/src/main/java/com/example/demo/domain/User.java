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
	private String username;
	@JsonIgnore
	private String password;
	private String tel;
	private String mail;
	private String coments;
	/*itemと一対多の関係にする*/
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	private List<Item> items;
}
