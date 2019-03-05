package com.example.demo.web;

import lombok.Data;

@Data
public class UserForm {
	private String username;
	private String password;
	private String tel;
	private String mail;
	private String comments;
	private String slackname;
	private String filename;
}
