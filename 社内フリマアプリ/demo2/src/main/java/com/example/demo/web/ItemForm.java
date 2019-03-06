package com.example.demo.web;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.Category;

import lombok.Data;

@Data
public class ItemForm implements Serializable{
	private String itemname;
	private Integer price;
	private String condition;
	private String payment;
	private Integer stock;
	private String comments;
	private Category category; 
	private Integer purchasenumber;
	private String filename;
	private String filename2;
	private String filename3;
	private String filename4;
	private MultipartFile uploadedFile;
	private MultipartFile uploadedFile2;
	private MultipartFile uploadedFile3;
	private MultipartFile uploadedFile4;
	private Boolean exhibitcansellflg;
}
