package com.example.demo.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
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
@SessionAttributes(names= "userForm")
public class UserController {
	
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
	
	@ModelAttribute("userForm")
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
		
		/*purchase全件取得*/
		List<Purchase> purchases = purchaseService.findAll();
		model.addAttribute("purchases", purchases);
		return "demo";
	}
	//ページャー
	@GetMapping(path = "techma/user/{page}")
	Page<User> getUsers(@PageableDefault Pageable pageable) {
		Page<User> users = userService.findAll(pageable);
		return users;
	}
	//ログアウト画面遷移
	@RequestMapping("logoutresult")
	public String logoutResult() {
	return "logoutresult";
	}
	//アカウント作成確認
	@RequestMapping(path = "createusercheck")
	public String createUserNologinCheck(Model model, UserForm form,String password) {
		model.addAttribute("userForm", form);
		//return "demo";
		return "createusercheck";
	}
	//＠ユーザー作成
	@PostMapping(path = "**/usercreate")
	String UserCreate(@Validated UserForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDatails , String password, SessionStatus sessionStatus) throws IOException {
		if (result.hasErrors()) {
		 return techmaController(model, userDatails);
		}
		User user  = new User();
		form.getUsername();
		form.getPassword();
		BeanUtils.copyProperties(form, user);
		password = user.getPassword();
		password = new Pbkdf2PasswordEncoder().encode(password);
		user.setPassword(password);
		userService.create(user);
		//slackapi呼び出し
		if (form.getSlackname() != null) {
			botService.UsercreateBot(form);
		}
		sessionStatus.setComplete();
		return "userresult";
		//return "createuserchack";
	}
	//アカウント作成完了
	@RequestMapping("userresult")
	public String goToUserResult(Model model, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "userresult";
	}
	 //マイページに遷移
	@RequestMapping("techma/user")
	public String goToUser(@AuthenticationPrincipal LoginUserDetails userDatails , Model model , Integer id) {
		User user = userDatails.getUser();
		model.addAttribute("user", user);
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "user";
	}
	//ユーザー更新画面
	@GetMapping(path = "techma/user/useredit")
	String UserEditForm(@Validated UserForm form, @AuthenticationPrincipal LoginUserDetails userDatails, BindingResult result, Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "userupdate";
	}
	//ユーザー更新確認
	@PostMapping("techma/user/userupdatecheck")
		public String UserUpdateCheck(UserForm form, Model model,@AuthenticationPrincipal LoginUserDetails userDatails, BindingResult result) {
		model.addAttribute("userForm", form);
		//画像アップロード
				Path path = Paths.get("src/main/resources/static/userimage/");
				if (!Files.exists(path)) {
					try {
						Files.createDirectory(path);
					} catch (NoSuchFileException ex) {
						System.out.println(ex);
						} catch (IOException ex) {
						System.out.println(ex);
					}	
				}
				int dot = form.getUploadedFile().getOriginalFilename().lastIndexOf(".");
				  String extention = "";
				  if (dot > 0) {
				    extention = form.getUploadedFile().getOriginalFilename().substring(dot).toLowerCase();
				  }
				  String filename = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
				  form.setFilename(filename + extention);
				  Path uploadfile = Paths		  
				      .get("src/main/resources/static/userimage/" + filename + extention);
				  if(dot < 0) {
						form.setFilename(null);
					} else {
				  try (OutputStream os = Files.newOutputStream(uploadfile, StandardOpenOption.CREATE)) {
				    byte[] bytes = form.getUploadedFile().getBytes();
				  //bytesをBase64に変換してビューに渡す
				    String base64str = Base64.getEncoder().encodeToString(bytes);
				    form.setFilename(base64str);
				    model.addAttribute("base64str",base64str);
				  //転送したファイルを書き込みディレクトリに格納
				    //os.write(bytes);
				  } catch (IOException ex) {
				    System.err.println(ex);
				  }
				}
				  if (result.hasErrors()) {
						 return UserEditForm(form, userDatails, result, model);
				  }
		return "updateusercheck";
	}
	//ユーザー更新処理
	@PostMapping(path = "techma/userupdate")
	String UserEdit(@Validated UserForm form, @AuthenticationPrincipal LoginUserDetails userDatails, BindingResult result, String password,Model model) throws IOException {
		User user = userDatails.getUser();
		if (result.hasErrors()) {
			/*＠後で繊維先変える*/
		return UserEditForm( form, userDatails, result, model);
		}
		BeanUtils.copyProperties(form, user);
		password = user.getPassword();
		password = new Pbkdf2PasswordEncoder().encode(password);
		user.setPassword(password);
		userService.update(user);
		//slackapi呼び出し
		if (user.getSlackname() != null) {
			botService.UserUpdateBot(user);
		}
		return "redirect:/techmatop/techma/userupdateresult";
	}
	//ユーザー更新完了
	@RequestMapping("techma/userupdateresult")
	public String UserUpdateresult(Model model, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
	return "userupdateresult";
	}
	//ユーザー削除
	@PostMapping(path = "techma/userdalete")
	String UserDelete(@RequestParam String name) {
		userService.dalete(name);
		return "redirect:/techma/user";
	}
}
