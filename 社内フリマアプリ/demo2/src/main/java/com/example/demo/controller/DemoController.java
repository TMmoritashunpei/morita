package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.User;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ItemService;
import com.example.demo.service.LoginUserDetails;
import com.example.demo.service.UserService;
import com.example.demo.web.CategoryForm;
import com.example.demo.web.ItemForm;
import com.example.demo.web.UserForm;

@Controller
@RequestMapping("techma")
public class DemoController {

	@Autowired
	ItemService itemService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
		
	@ModelAttribute
	ItemForm setUpItemForm() {
		return new ItemForm();
	}
	
	@ModelAttribute
	UserForm setUpUserForm() {
		return new UserForm();
	}
	
	@ModelAttribute
	CategoryForm setUpCategoryForm() {
		return new CategoryForm();
	}
	
	@GetMapping
	public String techmaController(Model model, @AuthenticationPrincipal LoginUserDetails userDatails) {
		/*item全件取得*/
			List<Item> items = itemService.findAll();
			model.addAttribute("items", items);
		
		/*user全件取得*/
			List<User> users = userService.findAll();
			model.addAttribute("users", users);
		
		/*ctegory全件取得*/
			List<Category> categories = categoryService.findAll();
			 model.addAttribute("categories", categories);
			return "demo";
			}
	
	@GetMapping(path = "item/{id}")
	Item getItem(@PathVariable Integer id) {
		Item item = itemService.findOne(id);
			return item;
	}
	
	@GetMapping(path = "user/{id}")
	User getUser(@PathVariable String name) {
		User user = userService.findOne(name);
			return user;
	}
	
	@GetMapping(path = "category/{id}")
	Category getCategory(@PathVariable Integer id) {
		Category category = categoryService.findOne(id);
			return category;
	}
	
	@GetMapping(path = "item/{page}")
	Page<Item> getItems(@PageableDefault Pageable pageable) {
		Page<Item> items = itemService.findAll(pageable);
			return items;
		
	}
	
	@GetMapping(path = "user/{page}")
	Page<User> getUsers(@PageableDefault Pageable pageable) {
		Page<User> users = userService.findAll(pageable);
			return users;
	}
	
	@GetMapping(path = "category/{page}")
	Page<Category> getcategorys(@PageableDefault Pageable pageable) {
		Page<Category> categorys = categoryService.findAll(pageable);
			return categorys;
	}
	
	@GetMapping(path = "itemcreate")
	public String itemcreate(Model model) {
	List<Category> categorys = categoryService.findAll();
	model.addAttribute("categorys", categorys);
			return "itemcreate";
	}
	
	@PostMapping(path = "exhibit")
	String ItemExhibit(@Validated ItemForm form, BindingResult result, Model model,
			@AuthenticationPrincipal LoginUserDetails userDatails) {
		if (result.hasErrors()) {
			 return itemcreate(model);
		}
		Item item  = new Item();
		BeanUtils.copyProperties(form, item );
		itemService.create(item, userDatails.getUser());
			return "redairect:/itemresult";
	}
	
	@PostMapping(path = "usercreate")
	String UserCreate(@Validated UserForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDatails) {
		if (result.hasErrors()) {
			 return techmaController(model, userDatails);
		}
		User user  = new User();
		BeanUtils.copyProperties(form, user);
		userService.create(user);
			return "redairect:/itemresult";
	}
	
	@PostMapping(path = "categorycreate")
	String CtegoryCreate(@Validated CategoryForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDatails) {
		if (result.hasErrors()) {
			/*＠後で繊維先変える*/
			 return techmaController(model, userDatails);
		}
		Category category  = new Category();
		BeanUtils.copyProperties(form, category);
		categoryService.create(category);
		/*＠後で繊維先変える*/
			return "redairect:/itemresult";
	}
	
	@GetMapping(path = "itemedit",params = "form")
	String ItemEditForm(@RequestParam Integer id,@Validated ItemForm form) {
		Item item = itemService.findOne(id);
		BeanUtils.copyProperties(item, form);
			return "itemedit";
		}
	
	@PostMapping(path = "itemedit")
	String ItemEdit(@RequestParam Integer id,@Validated ItemForm form, BindingResult result,
			@AuthenticationPrincipal LoginUserDetails userDatails) {
		if (result.hasErrors()) {
			/*＠後で繊維先変える*/
			return ItemEditForm(id, form);
		}
		Item item = new Item();
		BeanUtils.copyProperties(form, item);
		item.setItemId(id);
		itemService.update(item, userDatails.getUser());
		return "redirect:/item";
	}
	
	@GetMapping(path = "useredit",params = "form")
	String UserEditForm(@RequestParam String name,@Validated UserForm form) {
		User user = userService.findOne(name);
		BeanUtils.copyProperties(user, form);
			return "useredit";
		}
	
	@PostMapping(path = "useredit")
	String UserEdit(@RequestParam String name,@Validated UserForm form, BindingResult result) {
		if (result.hasErrors()) {
			/*＠後で繊維先変える*/
			return UserEditForm(name, form);
		}
		User user = new User();
		BeanUtils.copyProperties(form, user);
		user.setUsername(name);
		userService.update(user);
		return "redirect:/item";
	}
	
	@GetMapping(path = "categoryedit",params = "form")
	String CategoryEditForm(@RequestParam Integer id,@Validated CategoryForm form) {
		Category category = categoryService.findOne(id);
		BeanUtils.copyProperties(category, form);
			return "itemedit";
		}
	
	@PostMapping(path = "categoryedit")
	String CategoryEdit(@RequestParam Integer id,@Validated CategoryForm form, BindingResult result) {
		if (result.hasErrors()) {
			/*＠後で繊維先変える*/
			return CategoryEditForm(id, form);
		}
		Category category = new Category();
		BeanUtils.copyProperties(form, category);
		category.setCategoryId(id);
		categoryService.update(category);
		return "redirect:/item";
	}
	
	@PostMapping(path = "itemdalete")
	String ItemDelete(@RequestParam Integer id) {
		itemService.dalete(id);
		return "redirect:/item";
	}
	
	@PostMapping(path = "userdalete")
	String UserDelete(@RequestParam String name) {
		userService.dalete(name);
		return "redirect:/user";
	}
	
	@PostMapping(path = "categorydalete")
	String CategoryDelete(@RequestParam Integer id) {
		categoryService.dalete(id);
		return "redirect:/ctegory";
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

@RequestMapping("userresult")
public String goToUserResult() {
	return "userresult";
	}

@RequestMapping("itemresult")
public String goToItemResult() {
	return "itemresult";
	}

@RequestMapping("buyresult")
public String goTobuyResult() {
	return "itemresult";
	}

@RequestMapping("itemresultcheck")
public String goToItemresultcheck() {
	return "itemresultcheck";
	}
@RequestMapping("itembuycheck")
public String goToItembuycheck() {
	return "itembuycheck";
	}

@RequestMapping("exhibitor")
public String exhibitor() {
	return "exhibitor";
	}

}
