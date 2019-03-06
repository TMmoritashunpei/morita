package com.example.demo.web;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserForm implements Serializable {
	private String username;
	private String password;
	private String tel;
	private String mail;
	private String comments;
	private String slackname;
	private String filename;
	private MultipartFile uploadedFile;
}
