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
import java.util.Base64;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.domain.Category;
import com.example.demo.domain.Item;
import com.example.demo.domain.Purchase;
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
@SessionAttributes(names= "itemForm")
public class ItemController {
	
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
	//ページャー
	@GetMapping(path = "item/{page}")
	Page<Item> getItems(@PageableDefault Pageable pageable) {
		Page<Item> items = itemService.findAll(pageable);
		return items;	
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
	    String base64str = Base64.getEncoder().encodeToString(bytes);
	    form.setFilename(base64str);
	    model.addAttribute("base64str",base64str);
	 //転送したファイルを書き込みディレクトリに格納
	    //os.write(bytes);
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
	  //ビューでファイルが選択され無かった時の処理
	  if(dot2 < 0) {
		 form.setFilename2(null);
	  } else {
	  try (OutputStream os = Files.newOutputStream(uploadfile2, StandardOpenOption.CREATE)) {
	    byte[] bytes2 = form.getUploadedFile2().getBytes();
	  //bytesをBase64に変換してビューに渡す
	    String base64str2 = Base64.getEncoder().encodeToString(bytes2);
	    form.setFilename2(base64str2);
	    model.addAttribute("base64str2",base64str2);
	  //転送したファイルを書き込みディレクトリに格納
	    //os.write(bytes2);
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
	  //ビューでファイルが選択され無かった時の処理
	  if(dot3 < 0) {
			 form.setFilename3(null);
	  } else {
	  try (OutputStream os = Files.newOutputStream(uploadfile3, StandardOpenOption.CREATE)) {
	    byte[] bytes3 = form.getUploadedFile3().getBytes();
	  //bytesをBase64に変換してビューに渡す
	    String base64str3 = Base64.getEncoder().encodeToString(bytes3);
	    form.setFilename3(base64str3);
	    model.addAttribute("base64str3",base64str3);
	  //転送したファイルを書き込みディレクトリに格納
	    //os.write(bytes3);
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
	  //ビューでファイルが選択され無かった時の処理
	  if(dot4 < 0) {
			 form.setFilename4(null);
	  } else {
	  try (OutputStream os = Files.newOutputStream(uploadfile4, StandardOpenOption.CREATE)) {
	    byte[] bytes4 = form.getUploadedFile4().getBytes();
	  //bytesをBase64に変換してビューに渡す
	    String base64str4 = Base64.getEncoder().encodeToString(bytes4);
	    form.setFilename4(base64str4);
	    model.addAttribute("base64str4",base64str4);
	 //転送したファイルを書き込みディレクトリに格納
	    //os.write(bytes4);
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
			@AuthenticationPrincipal LoginUserDetails userDatails) throws IOException {
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
	public String goToItemResult(Model model, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "itemresult";
	}

	//アイテム削除
	@PostMapping(path = "techma/itemdalete")
	String ItemDelete(@RequestParam Integer id) {
		itemService.dalete(id);
		return "redirect:/techma/item";
	}
//アイテム検索画面
	@RequestMapping("techma/itemserch")
	public String goToSerch(Model model, String itemname, Category category, Item item) {
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
	public String itemNameSerch(Model model, @RequestParam("itemname") String itemname,  ItemForm form, Category category, Item item) {
		model.addAttribute("itemForm", form);
		model.addAttribute("itemname", itemname);
		model.addAttribute("category", category);
		//検索画面から商品名を検索
		if (category.getCategoryId() == null) {
			List<Item>items = itemService.findItemNameSerch(itemname);
			model.addAttribute("items", items);
			//item検索で見つからない場合
			if (itemService.findItemNameSerch(itemname).size() == 0) {
				model.addAttribute("noitem","ご指定の検索条件でアイテムが見つかりませんでした。");
			} 	
		} else {
			List<Item> items = itemService.itemNameInCategory(itemname, category.getCategoryId());
			model.addAttribute("items", items);
			//カテゴリ検索からアイテムの名前を検索し見つからない時の処理
			if (itemService.itemNameInCategory(itemname, category.getCategoryId()).size() == 0) {
				model.addAttribute("noitem","ご指定の検索条件でアイテムが見つかりませんでした。");
			}
		}
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "itemserch";
	}
	//アイテム詳細画面遷移
	@RequestMapping({"techma/item","techma/item/itemId{itemId}"})
	public String goToItem(@RequestParam Integer itemId ,Model model, ItemForm form, 
			@AuthenticationPrincipal LoginUserDetails userDatails, java.sql.Timestamp created_at) {
		Item item = itemService.findOne(itemId);
		//作成日をビューに渡す
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		sdf.setLenient(false);
		String str = sdf.format(item.getCreated_at());
		model.addAttribute("str", str);
		model.addAttribute("item",item);
		//出品アイテムが自身の所有アイテム時の処理
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
			return "itembuyresult";
	}
	//出品者画面遷移
	@RequestMapping("techma/exhibitor/itemId{itemId}")
	public String exhibitor(Model model, @RequestParam Integer itemId) {
		Item item = itemService.findOne(itemId);
		//画像をビューに渡す
		model.addAttribute("item",item);
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "exhibitor";
	}
	//出品履歴画面遷移
	@RequestMapping("techma/user/exhibitindex")
	public String exhibitIndex(Model model,@AuthenticationPrincipal LoginUserDetails userDatails,Item item) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		List<Item> items = itemService.findEhibitList(userDatails.getUser());
		model.addAttribute("items", items);
		//画像をビューに渡す
		String base64str = item.getFilename();
		model.addAttribute("base64str", base64str);
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
}
