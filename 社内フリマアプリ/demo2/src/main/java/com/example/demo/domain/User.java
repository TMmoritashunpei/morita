package com.example.demo.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User implements Serializable {
	private String userName;
	private String password;
	private String tel;
	private String mail;
}
