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
@SessionAttributes(names= "purchaseForm")
public class PurchaseController {
	
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
	
	@ModelAttribute
	CategoryForm setUpCategoryForm() {
	return new CategoryForm();
	}
	
	@ModelAttribute("purchaseForm")
	PurchaseForm setUpPurchaseForm() {
	return new PurchaseForm();
	}
	//購入履歴画面遷移
	@RequestMapping("techma/user/purchaseindex")
	public String purchaseIndex(Model model,  Integer purchaseId, Purchase purchase, @AuthenticationPrincipal LoginUserDetails userDatails) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		List<Purchase> purchases = purchaseService.findPurchaseList(userDatails.getUser());
		model.addAttribute("purchases",purchases);
		if (purchaseService.findPurchaseList(userDatails.getUser()).size() == 0) {
			model.addAttribute("noperchase","購入商品がありません");
		}
		return "purchaseindex";
	}
	//購入アイテムキャンセル
		@RequestMapping("techma/item/purchasecansell/purchaseId{purchaseId}")
		String PurchaseItemEditForm(@RequestParam Integer purchaseId,@Validated ItemForm form, @AuthenticationPrincipal LoginUserDetails userDatails,Model model) throws IOException {
			Purchase purchase = purchaseService.findOne(purchaseId);
		     Boolean purchaseflg = purchase.getCansellflg();
		     purchaseflg = !purchaseflg;
		    purchase.setCansellflg(purchaseflg);
			purchaseService.update(purchase, userDatails.getUser());
			//slackApi呼び出し
			botService.PurchaseStatusBot(purchase);
			return "redirect:/techmatop/techma/user/purchaseindex";
		}
}
