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
@Table(name = "ctegorys")
@ToString(exclude ="items")
public class Ctegory {
	@Id
	@GeneratedValue
	private Integer ctegoryId;
	private String ctegoryname;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ctegory")
	private List<Item> items;
}
