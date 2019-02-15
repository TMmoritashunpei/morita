package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
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
@RequestMapping("techmatop")
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
	//top画面に遷移
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
		return "techmatop";
			}
	//ログイン後遷移
	@RequestMapping("techma")
	public String techmaloginController(Model model, @AuthenticationPrincipal LoginUserDetails userDatails) {
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
	//アイテム詳細画面遷移
	@RequestMapping({"techma/item","techma/item/itemId{itemId}"})
	public String goToItem(@RequestParam Integer itemId ,Model model, ItemForm form) {
		Item item = itemService.findOne(itemId);
		model.addAttribute("item",item);
		return "item";
	}
	//カテゴリー検索
	@GetMapping(path = "category/{id}")
	Category getCategory(@PathVariable Integer id) {
		Category category = categoryService.findOne(id);
		return category;
	}
	//ページャー
	@GetMapping(path = "item/{page}")
	Page<Item> getItems(@PageableDefault Pageable pageable) {
		Page<Item> items = itemService.findAll(pageable);
		return items;
		
	}
	//ページャー
	@GetMapping(path = "techma/user/{page}")
	Page<User> getUsers(@PageableDefault Pageable pageable) {
		Page<User> users = userService.findAll(pageable);
		return users;
	}
	//ページャー
	@GetMapping(path = "techma/category/{page}")
	Page<Category> getcategorys(@PageableDefault Pageable pageable) {
		Page<Category> categorys = categoryService.findAll(pageable);
		return categorys;
	}
	//出品画面遷移
	@GetMapping(path = "techma/itemcreate")
	public String itemcreate(Model model) {
		/*ctegory全件取得*/
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "itemcreate";
	}
	//アイテム出品処理
	@PostMapping(path = "techma/exhibit")
	String ItemExhibit(@Validated ItemForm form, BindingResult result, Model model,
			@AuthenticationPrincipal LoginUserDetails userDatails) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		 
		if (result.hasErrors()) {
		 return itemcreate(model);
		}
		
		Item item  = new Item();
		BeanUtils.copyProperties(form, item );
		itemService.create(item, userDatails.getUser());
		return "itemresult";
	}
	//ユーザー作成
	@PostMapping(path = "**/usercreate")
	String UserCreate(@Validated UserForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDatails ,String password) {
		if (result.hasErrors()) {
		 return techmaController(model, userDatails);
		}
		User user  = new User();
		BeanUtils.copyProperties(form, user);
		password = user.getPassword();
		password = new Pbkdf2PasswordEncoder().encode(password);
		user.setPassword(password);
		userService.create(user);
		return "userresult";
	}
	//category カテゴリー作成　管理画面用
	@PostMapping(path = "techma/categorycreate")
	String CtegoryCreate(@Validated CategoryForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDatails) {
		if (result.hasErrors()) {
			/*＠後で繊維先変える*/
		return techmaController(model, userDatails);
		}
		Category category  = new Category();
		BeanUtils.copyProperties(form, category);
		categoryService.create(category);
		/*＠後で繊維先変える*/
		return "redairect:/techma/itemresult";
	}
	//アイテム更新
	@GetMapping(path = "techma/itemedit",params = "form")
	String ItemEditForm(@RequestParam Integer id,@Validated ItemForm form) {
		Item item = itemService.findOne(id);
		BeanUtils.copyProperties(item, form);
		return "itemedit";
		}
	//アイテム作成
	@PostMapping(path = "techma/itemedit")
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
		return "redirect:/techma/item";
	}
	//ユーザー更新
	@GetMapping(path = "techma/useredit",params = "form")
	String UserEditForm(@RequestParam String name,@Validated UserForm form) {
		User user = userService.findOne(name);
		BeanUtils.copyProperties(user, form);
		return "useredit";
		}
	//ユーザー更新
	@PostMapping(path = "techma/useredit")
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
	//カテゴリー更新
	@GetMapping(path = "techma/categoryedit",params = "form")
	String CategoryEditForm(@RequestParam Integer id,@Validated CategoryForm form) {
		Category category = categoryService.findOne(id);
		BeanUtils.copyProperties(category, form);
		return "itemedit";
		}
	//カテゴリー更新
	@PostMapping(path = "techma/categoryedit")
	String CategoryEdit(@RequestParam Integer id,@Validated CategoryForm form, BindingResult result) {
		if (result.hasErrors()) {
			/*＠後で繊維先変える*/
		return CategoryEditForm(id, form);
		}
		Category category = new Category();
		BeanUtils.copyProperties(form, category);
		category.setCategoryId(id);
		categoryService.update(category);
		return "redirect:/techma/item";
	}
	//アイテム削除
	@PostMapping(path = "techma/itemdalete")
	String ItemDelete(@RequestParam Integer id) {
		itemService.dalete(id);
		return "redirect:/techma/item";
	}
	//ユーザー削除
	@PostMapping(path = "techma/userdalete")
	String UserDelete(@RequestParam String name) {
		userService.dalete(name);
		return "redirect:/techma/user";
	}
	//カテゴリー削除
	@PostMapping(path = "techma/categorydalete")
	String CategoryDelete(@RequestParam Integer id) {
		categoryService.dalete(id);
		return "redirect:/techma/ctegory";
	}
	//アイテム購入
	@RequestMapping("techma/itembuy")
	public String goToBuy() {
		return "itembuy";
	}
	//アイテム検索
	@RequestMapping("techma/itemserch")
	public String goToSerch(Model model) {
		/*item　全件取得*/
		List<Item> items = itemService.findAll();
		model.addAttribute("items", items);
		/*ctegory　全件取得*/
		
		return "itemserch";
	}
	 //マイページに遷移
	@RequestMapping("techma/user")
	public String goToUser(@AuthenticationPrincipal LoginUserDetails userDatails , Model model , Integer id) {
		User user = userDatails.getUser();
		model.addAttribute("user", user);
		return "user";
	}
//アカウント作成完了
	@RequestMapping("techma/userresult")
	public String goToUserResult() {
		return "userresult";
	}
//出品完了
	@RequestMapping("techma/itemresult")
	public String goToItemResult() {
		return "itemresult";
	}
//購入完了
	@PostMapping("techma/buyresult/itemId{itemId}")
	public String goTobuyResult(Model model, Integer itemId, ItemForm form) {
		Item item = itemService.findOne(itemId);
		if (item.getStock()==0) {
			return goToItem(itemId, model,form);
		}
		item.setStock(form.getPurchasenumber());
		itemService.update(item, item.getUser());
		return "itembuyresult";
	}
//購入確認
	@RequestMapping("techma/itemresultcheck")
	public String goToItemresultcheck() {
		return "itemresultcheck";
	}
//アイテム購入チェック
	@RequestMapping("techma/itembuycheck")
	public String goToItembuycheck() {
		return "itembuycheck";
	}
//出品者画面遷移
	@RequestMapping("techma/exhibitor")
	public String exhibitor() {
		return "exhibitor";
	}

}
