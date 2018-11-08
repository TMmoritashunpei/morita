package com.example.demo.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category implements Serializable {
	private Integer ctegoryId;
	private String ctegoryName;
	//private Item item;
}
