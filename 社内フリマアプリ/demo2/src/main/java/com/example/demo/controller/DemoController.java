package com.example.demo.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

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
@SessionAttributes(value = "itemForm")
public class DemoController {
	
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
		
	@ModelAttribute("itemForm")
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
	//カテゴリー検索
	@GetMapping(path = "/techma/category/{id}")
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
	public String itemcreate(Model model, ItemForm form) {
		/*ctegory全件取得*/
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("itemForm", form);
		return "itemcreate";
	}
	//出品確認画面遷移
	@PostMapping("techma/itemchack")	
	public String itemChack(Model model, ItemForm form, BindingResult result) {
	/*ctegory全件取得*/
	List<Category> categories = categoryService.findAll();
	model.addAttribute("categories", categories);
	model.addAttribute("itemForm", form);
	if (form.getUploadedFile().isEmpty()) {
		return "itemcreate";
	}
	Path path = Paths.get("src/main/resources/static/itemimage/");
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
	      .get("src/main/resources/static/itemimage/" + filename + extention);

	  try (OutputStream os = Files.newOutputStream(uploadfile, StandardOpenOption.CREATE)) {
	    byte[] bytes = form.getUploadedFile().getBytes();
	    os.write(bytes);
	  } catch (IOException ex) {
	    System.err.println(ex);
	  }
	if (result.hasErrors()) {
	 return itemcreate(model, form);
	}
	//2つ目の画像処理
	int dot2 = form.getUploadedFile2().getOriginalFilename().lastIndexOf(".");
	  String extention2 = "";
	  if (dot2 > 0) {
	    extention2 = form.getUploadedFile2().getOriginalFilename().substring(dot2).toLowerCase();
	  }
	  String filename2 = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
	  form.setFilename2(filename2 + extention2);
	  Path uploadfile2 = Paths
	      .get("src/main/resources/static/itemimage/" + filename2 + extention2);
	  if(dot2 < 0) {
		 form.setFilename2(null);
	  } else {
	  try (OutputStream os = Files.newOutputStream(uploadfile2, StandardOpenOption.CREATE)) {
	    byte[] bytes = form.getUploadedFile2().getBytes();
	    os.write(bytes);
	  } catch (IOException ex) {
	    System.err.println(ex);
	  		}
	  }
	 //3つ目の画像処理
	 int dot3 = form.getUploadedFile3().getOriginalFilename().lastIndexOf(".");
	  String extention3 = "";
	  if (dot3 > 0) {
	    extention3 = form.getUploadedFile3().getOriginalFilename().substring(dot3).toLowerCase();
	  }
	  String filename3 = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
	  form.setFilename3(filename3 + extention3);
	  Path uploadfile3 = Paths
	      .get("src/main/resources/static/itemimage/" + filename3 + extention3);
	  if(dot3 < 0) {
			 form.setFilename3(null);
	  } else {
	  try (OutputStream os = Files.newOutputStream(uploadfile3, StandardOpenOption.CREATE)) {
	    byte[] bytes = form.getUploadedFile3().getBytes();
	    os.write(bytes);
	  } catch (IOException ex) {
	    System.err.println(ex);
	  		}
	  }
	if (result.hasErrors()) {
	 return itemcreate(model, form);
	}
	int dot4 = form.getUploadedFile4().getOriginalFilename().lastIndexOf(".");
	  String extention4 = "";
	  if (dot4 > 0) {
	    extention4 = form.getUploadedFile4().getOriginalFilename().substring(dot4).toLowerCase();
	  }
	  String filename4 = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
	  form.setFilename4(filename4 + extention4);
	  Path uploadfile4 = Paths
	      .get("src/main/resources/static/itemimage/" + filename4 + extention4);
	  if(dot4 < 0) {
			 form.setFilename4(null);
	  } else {
	  try (OutputStream os = Files.newOutputStream(uploadfile4, StandardOpenOption.CREATE)) {
	    byte[] bytes = form.getUploadedFile4().getBytes();
	    os.write(bytes);
	  } catch (IOException ex) {
	    System.err.println(ex);
	  		}
	  }
	if (result.hasErrors()) {
	 return itemcreate(model, form);
	}
	return "itemexhibitcheck";
	}
	//アイテム画像送信
	@RequestMapping(path ="techma/uproadfile",method = RequestMethod.POST)
	String ItemUproadFile(Model model ,ItemForm form, MultipartFile uploadedFile) {		
		    //fileUploadSampleForm.getUploadedFile().getOriginalFilename();
			return itemcreate(model, form);
	}
	//アイテム出品処理
	@PostMapping(path = "techma/exhibit")
	String ItemExhibit(@Validated ItemForm form, BindingResult result, Model model,
			@AuthenticationPrincipal LoginUserDetails userDatails, MultipartFile uploadedFile) throws IOException {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		
		//アイテム作成後にDB登録
		Item item  = new Item();
		BeanUtils.copyProperties(form, item );
		itemService.create(item, userDatails.getUser());
		//slackapi呼び出し
		if (userDatails.getUser().getSlackname() != null) {
			botService.ExhibitBot(form, userDatails);
		}
		return "redirect:/techmatop/techma/itemresult";
	}
	//出品完了画面遷移
	@RequestMapping("techma/itemresult")
	public String goToItemResult() {
		return "itemresult";
	}
	//＠ユーザー作成
	@PostMapping(path = "**/usercreate")
	String UserCreate(@Validated UserForm form, BindingResult result, Model model, @AuthenticationPrincipal LoginUserDetails userDatails , String password) throws IOException {
		if (result.hasErrors()) {
		 return techmaController(model, userDatails);
		}
		User user  = new User();
		BeanUtils.copyProperties(form, user);
		password = user.getPassword();
		password = new Pbkdf2PasswordEncoder().encode(password);
		user.setPassword(password);
		userService.create(user);
		//slackapi呼び出し
		if (form.getSlackname() != null) {
			botService.UsercreateBot(form);
		}
		return "userresult";
	}
	//アカウント作成完了
	@RequestMapping("techma/userresult")
	public String goToUserResult() {
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
	//ユーザー更新画面
	@GetMapping(path = "techma/user/useredit")
	String UserEditForm(@Validated UserForm form, @AuthenticationPrincipal LoginUserDetails userDatails, BindingResult result, Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "userupdate";
	}
	//ユーザー更新処理
	@PostMapping(path = "techma/userupdate")
	String UserEdit(@Validated UserForm form, @AuthenticationPrincipal LoginUserDetails userDatails, BindingResult result, String password,Model model) throws IOException {
		User user = userDatails.getUser();
		if (result.hasErrors()) {
			/*＠後で繊維先変える*/
		return UserEditForm( form, userDatails, result, model);
		}
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
		    os.write(bytes);
		  } catch (IOException ex) {
		    System.err.println(ex);
		  }
		}
		  if (result.hasErrors()) {
				 return UserEditForm(form, userDatails, result, model);
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
	public String UserUpdateresult() {
	return "userupdateresult";
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
	//アイテム検索画面
	@RequestMapping("techma/itemserch")
	public String goToSerch(Model model, String itemname, Category category) {
		/*item　全件取得*/
		model.addAttribute("itemname", itemname);
		List<Item> items = itemService.findAll();
		model.addAttribute("items", items);
		/*ctegory　全件取得*/
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "itemserch";
	}
	//アイテム検索機能
	@GetMapping("techma/itemserch/itemname")
	public String itemNameSerch(Model model, @RequestParam("itemname") String itemname, Category category, ItemForm form) {
		model.addAttribute("itemForm", form);
		model.addAttribute("itemname", itemname);
		model.addAttribute("category", category);
		List<Item> items = itemService.findItemNameSerch(itemname);
		//item検索で見つからない場合
		if (itemService.findItemNameSerch(itemname).size() == 0) {
			model.addAttribute("noitem","ご指定の検索条件でアイテムが見つかりませんでした。");
		}
		model.addAttribute("items", items);	
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "itemserch";
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
	 //マイページに遷移
	@RequestMapping("techma/user")
	public String goToUser(@AuthenticationPrincipal LoginUserDetails userDatails , Model model , Integer id) {
		User user = userDatails.getUser();
		model.addAttribute("user", user);
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "user";
	}
	//アイテム詳細画面遷移
	@RequestMapping({"techma/item","techma/item/itemId{itemId}"})
	public String goToItem(@RequestParam Integer itemId ,Model model, ItemForm form, 
			@AuthenticationPrincipal LoginUserDetails userDatails, java.sql.Timestamp created_at) {
		Item item = itemService.findOne(itemId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setLenient(false);
		String str = sdf.format(item.getCreated_at());
		model.addAttribute("str", str);
		model.addAttribute("item",item);
		if (userDatails.getUser().getId() == item.getUser().getId()) {
			model.addAttribute("userDatailscheck", "この商品はご自身で出品されたアイテムの為購入できません。");
		}
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "item";
	}
	//購入確認
	@RequestMapping("techma/itemcheck/itemId{itemId}")
	public String goToItemresultcheck(@RequestParam Integer itemId ,Model model, ItemForm form, 
			@AuthenticationPrincipal LoginUserDetails userDatails, java.sql.Timestamp created_at) {
		Item item = itemService.findOne(itemId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setLenient(false);
		String str = sdf.format(item.getCreated_at());
		model.addAttribute("str", str);
		model.addAttribute("item",item);
	return "itempurchasecheck";
	}
	//購入処理
	@PostMapping("techma/buyresult/itemId")
	public String goTobuyResult(Model model, @RequestParam("itemId") Integer itemId, ItemForm form, BindingResult result,
			@AuthenticationPrincipal LoginUserDetails userDatails, java.sql.Timestamp created_at, @RequestParam("purchasenumber")Integer purchasenumber) throws IOException {
		Item item = itemService.findOne(itemId);
		model.addAttribute("itemForm", form);
		if (item.getStock()==0) {
			return goToItem(itemId, model,form, userDatails, created_at);
		}
		item.setStock(item.getStock() - purchasenumber);
		//購入履歴作成
		//商品名と購入数を取得しpurchaseインスタンスにセットする
		Purchase purchase = new Purchase();
		purchase.setPurchasename(item.getItemname());
		purchase.setStock(form.getPurchasenumber());
		purchase.setFilename(item.getFilename());
		purchaseService.create(purchase, userDatails.getUser(), item);
		itemService.update(item, item.getUser());
		//slackapi呼び出し
		if (userDatails.getUser().getSlackname() != null) {
			botService.purchaseBot(item, form, userDatails);
		}
		//slackapi呼び出し
		if (item.getUser().getSlackname() != null) {
			botService.ExhibitPurchaseBot(item, form, userDatails);
		}
		return "redirect:/techmatop/techma/buyresult";
	}
	//購入完了
		@RequestMapping("techma/buyresult")
		public String ItemBuyresult() {
			return "itemresult";
	}
	//出品者画面遷移
	@RequestMapping("techma/exhibitor/itemId{itemId}")
	public String exhibitor(Model model, @RequestParam Integer itemId) {
		Item item = itemService.findOne(itemId);
		model.addAttribute("item",item);
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "exhibitor";
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
	//出品履歴画面遷移
	@RequestMapping("techma/user/exhibitindex")
	public String exhibitIndex(Model model,@AuthenticationPrincipal LoginUserDetails userDatails) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		List<Item> items = itemService.findEhibitList(userDatails.getUser());
		model.addAttribute("items", items);
		if (itemService.findEhibitList(userDatails.getUser()).size() == 0) {
			model.addAttribute("noexhibit","出品商品がありません");
		}
		return "exhibitindex";
	}
	//出品アイテムキャンセル
	@RequestMapping("techma/item/cansell/itemId{itemId}")
	String ItemEditForm(@RequestParam Integer itemId,@Validated ItemForm form, @AuthenticationPrincipal LoginUserDetails userDatails,Model model) throws IOException {
		Item item = itemService.findOne(itemId);
	     Boolean itemflg = item.getExhibitcansellflg();
	     itemflg = !itemflg;
	    item.setExhibitcansellflg(itemflg);
		itemService.update(item, userDatails.getUser());
		//slackApi呼び出し
		botService.ItemStatusBot(item);
		return "redirect:/techmatop/techma/user/exhibitindex";
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
