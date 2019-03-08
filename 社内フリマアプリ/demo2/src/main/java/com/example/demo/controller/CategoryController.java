package com.example.demo.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Purchase;
import com.example.demo.domain.User;
import com.example.demo.service.BotService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ItemService;
import com.example.demo.service.LoginUserDetails;
import com.example.demo.service.PurchaseService;
import com.example.demo.service.UserService;
import com.example.demo.web.CategoryForm;
import com.example.demo.web.ItemForm;
import com.example.demo.web.PurchaseForm;
import com.example.demo.web.UserForm;

@Controller
@RequestMapping("techmatop")
@SessionAttributes(names= "categoryForm")
public class CategoryController {
	
	@Autowired
	ItemService itemService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	PurchaseService purchaseService;
	
	@Autowired
	BotService botService;
		
	@ModelAttribute
	ItemForm setUpItemForm() {
	return new ItemForm();
	}
	
	@ModelAttribute
	UserForm setUpUserForm() {
	return new UserForm();
	}
	
	@ModelAttribute("categoryForm")
	CategoryForm setUpCategoryForm() {
	return new CategoryForm();
	}
	
	@ModelAttribute
	PurchaseForm setUpPurchaseForm() {
	return new PurchaseForm();
	}
	//カテゴリー検索
	@GetMapping(path = "/techma/category/{id}")
	Category getCategory(@PathVariable Integer id) {
		Category category = categoryService.findOne(id);
		return category;
	}
	//ページャー
	@GetMapping(path = "techma/category/{page}")
	Page<Category> getcategorys(@PageableDefault Pageable pageable) {
		Page<Category> categorys = categoryService.findAll(pageable);
		return categorys;
	}
	//category カテゴリー作成　管理画面用
	//@PostMapping(path = "techma/categorycreate")
	//String CtegoryCreate(@Validated CategoryForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDatails) {
		//if (result.hasErrors()) {
			/*＠後で繊維先変える*/
			//return techmaController(model, userDatails);
		//}
		//Category category  = new Category();
		//BeanUtils.copyProperties(form, category);
		//categoryService.create(category);
		/*＠後で繊維先変える*/
		//return "redairect:/techma/itemresult";
	//}
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
	//カテゴリー削除
	@PostMapping(path = "techma/categorydalete")
	String CategoryDelete(@RequestParam Integer id) {
		categoryService.dalete(id);
		return "redirect:/techma/ctegory";
	}
	//カテゴリ検索
		@RequestMapping("techma/category{category}")
	public String goToItemInCategory(Model model, Category category) {
			/*item　全件取得*/
		List<Item> items = itemService.findCategoryInItem(category);
		model.addAttribute("items", items);
		if (itemService.findCategoryInItem(category).size() == 0) {
			model.addAttribute("categorynoitem","ご指定の検索条件でアイテムが見つかりませんでした。");
		}
			/*ctegory全件取得*/
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "itemserch";
	}
}
