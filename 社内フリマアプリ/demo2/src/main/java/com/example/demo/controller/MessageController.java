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
import com.example.demo.domain.Message;
import com.example.demo.domain.Purchase;
import com.example.demo.domain.User;
import com.example.demo.service.BotService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ItemService;
import com.example.demo.service.LoginUserDetails;
import com.example.demo.service.MessageService;
import com.example.demo.service.PurchaseService;
import com.example.demo.service.UserService;
import com.example.demo.web.CategoryForm;
import com.example.demo.web.ItemForm;
import com.example.demo.web.MessageForm;
import com.example.demo.web.PurchaseForm;
import com.example.demo.web.UserForm;

@Controller
@RequestMapping("techmatop")
@SessionAttributes(names= "messageForm")
public class MessageController {
	
	@Autowired
	ItemService itemService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserService userService;
	@Autowired
	PurchaseService purchaseService;
	@Autowired
	MessageService messageService;
	
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
	
	@ModelAttribute
	PurchaseForm setUpPurchaseForm() {
	return new PurchaseForm();
	}
	@ModelAttribute("messageForm")
	MessageForm setUpMessageForm() {
	return new MessageForm();
	}
	@RequestMapping("techma/purchasemessage{purchaseId}")
	public String purchaseMessage(Model model, @RequestParam Integer purchaseId, MessageForm messageForm, @AuthenticationPrincipal LoginUserDetails userDatails) {
		Purchase purchase = purchaseService.findOne(purchaseId);
		model.addAttribute("purchase", purchase);
		List<Message> messages = messageService.findPurchaseMessage(purchase);
		model.addAttribute("messages", messages);
		model.addAttribute("usercheck", userDatails.getUser().getId());
		return "message";
	}
	@RequestMapping("techma/messagesubmit{purchaseId}") 
	public String messageSubmit(@Validated MessageForm messageForm, Model model,
			@AuthenticationPrincipal LoginUserDetails userDatails, @RequestParam("purchaseId")Integer purchaseId) {
		Purchase purchase = purchaseService.findOne(purchaseId);
		model.addAttribute("purchase", purchase);
		Message message  = new Message();
		BeanUtils.copyProperties(messageForm, message);
		messageService.create(purchase, userDatails.getUser(), message);
		return purchaseMessage(model, purchaseId, messageForm, userDatails);
	}
	@RequestMapping("techma/messagedelete{messageId}")
	public String messageDelete(@RequestParam("messageId") Integer messageId, Model model, MessageForm messageForm, @AuthenticationPrincipal LoginUserDetails userDatails) {
		Message message = messageService.findOne(messageId);
		Integer purchaseId = message.getPurchase().getPurchaseId();
		messageService.dalete(messageId);
		return purchaseMessage(model, purchaseId, messageForm, userDatails);
	}
}
