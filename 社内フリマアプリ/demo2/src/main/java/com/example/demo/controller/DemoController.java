package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("techma")
public class DemoController {
	@GetMapping
	public String index() {
		return "demo";
	}
@RequestMapping("itemcreate")
	public String goToCreate() {
		return "itemcreate";
	}
@RequestMapping("itembuy")
public String goToBuy() {
	return "itembuy";
	}
@RequestMapping("itemserch")
public String goToSerch() {
	return "itemserch";
	}
@RequestMapping("item")
public String goToItem() {
	return "item";
	}
@RequestMapping("user")
public String goToUser() {
	return "user";
	}
}
