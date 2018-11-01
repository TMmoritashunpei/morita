package techma.web.exhibit;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.util.UriComponentsBuilder;

import techma.domain.categories.Category;
import techma.domain.items.Item;
import techma.domain.login.LoginUserDetails;
//import techma.domain.login.LoginUserDetails;
import techma.domain.users.User;
import techma.service.topPage.TopPageService;
import techma.web.ItemForm;




@Controller
@RequestMapping("item/exhibit")
public class ExhibitController {
	@Autowired
	TopPageService topPageService;
	
	
	private User user;	
	private Date date;
	
	public Date getDate2() {
		return date;
	}

	public void setDate2(Date date2) {
		this.date = date2;
	}
	
	@ModelAttribute
    ItemForm setUpForm() {
        return new ItemForm();
	}
	
	@GetMapping
    String list(Model model) {
		//About Category
	    List<Category> categories = topPageService.findAllGetCategory();
	    model.addAttribute("categories", categories);
	    
	    List<User> users = topPageService.findAllGetUser();
        model.addAttribute("users", users);
     
        
        List<Item> items = topPageService.findAll();
        model.addAttribute("items", items);
        return "shuppin";
    }   
	
	
	@PostMapping(path = "create")
	String create(@Validated ItemForm form, BindingResult result, Model model,
			@AuthenticationPrincipal LoginUserDetails userDatails ,UriComponentsBuilder builder) {
		
		if (result.hasErrors()) {
			return "redirect:../";
		}
		 // check upload distination directory.If there was no directory, make
	      // func.
		
		/*image画像のパス*/
	      Path imageMainPath = Paths.get("src/main/resources/static/image_main/");
	    
	      if (!Files.exists(imageMainPath)) {
	        try {
	          Files.createDirectory(imageMainPath);
	        } catch (NoSuchFileException ex) {
	          System.err.println(ex);
	        } catch (IOException ex) {
	          System.err.println(ex);
	        }
	      }
	      /*@@@main画像の時の処理*/
	      int dotMain = form.getFile().getOriginalFilename().lastIndexOf(".");
	      String extention = "";
	      if (dotMain > 0) {
	        extention = form.getFile().getOriginalFilename().substring(dotMain).toLowerCase();
	      }
	      String filename = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
	      Path uploadfile = Paths
	          .get("src/main/resources/static/image_main/" + filename + extention);
	      
	      try (OutputStream os = Files.newOutputStream(uploadfile, StandardOpenOption.CREATE)) {
	        byte[] bytes = form.getFile().getBytes();
	        os.write(bytes);
	      } catch (IOException ex) {
	        System.err.println(ex);
	      }
	      form.setPicture_main(filename + extention);
	      
	      /*sub1画像のパス*/
	      Path imageSubPath1 = Paths.get("src/main/resources/static/image_sub1/");
	      if (!Files.exists(imageSubPath1)) {
	        try {
	          Files.createDirectory(imageSubPath1);
	        } catch (NoSuchFileException ex) {
	          System.err.println(ex);
	        } catch (IOException ex) {
	          System.err.println(ex);
	        }
	      }
	      /*@@@sub1画像の時の処理*/
	      int dotSub1 = form.getFile().getOriginalFilename().lastIndexOf(".");
	      String extentionSub1 = "";
	      if (dotSub1 > 0) {
	        extentionSub1 = form.getFile().getOriginalFilename().substring(dotSub1).toLowerCase();
	      }
	      String filenameSub1 = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
	      Path uploadfileSub1 = Paths
	          .get("src/main/resources/static/image_sub1/" + filenameSub1 + extentionSub1);
	      
	      try (OutputStream os = Files.newOutputStream(uploadfileSub1, StandardOpenOption.CREATE)) {
	        byte[] bytes = form.getFile().getBytes();
	        os.write(bytes);
	      } catch (IOException ex) {
	        System.err.println(ex);
	      }
	      form.setPicture_sub1(filenameSub1 + extentionSub1);
	    
	      /*sub2画像のパス*/
	      Path imageSubPath2 = Paths.get("src/main/resources/static/image_sub2/");
	      if (!Files.exists(imageSubPath2)) {
		        try {
		          Files.createDirectory(imageSubPath2);
		        } catch (NoSuchFileException ex) {
		          System.err.println(ex);
		        } catch (IOException ex) {
		          System.err.println(ex);
		        }
		      }
		      /*@@@sub2画像の時の処理*/
		      int dotSub2 = form.getFile().getOriginalFilename().lastIndexOf(".");
		      String extentionSub2 = "";
		      if (dotSub2 > 0) {
		        extentionSub2 = form.getFile().getOriginalFilename().substring(dotSub2).toLowerCase();
		      }
		      String filenameSub2 = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
		      Path uploadfileSub2 = Paths
		          .get("src/main/resources/static/image_sub1/" + filenameSub2 + extentionSub2);
		      
		      try (OutputStream os = Files.newOutputStream(uploadfileSub2, StandardOpenOption.CREATE)) {
		        byte[] bytes = form.getFile().getBytes();
		        os.write(bytes);
		      } catch (IOException ex) {
		        System.err.println(ex);
		      }
		      form.setPicture_sub2(filenameSub2 + extentionSub2);
		      
		      /*sub2画像のパス*/
		      Path imageSubPath3 = Paths.get("src/main/resources/static/image_sub3/");
		      if (!Files.exists(imageSubPath3)) {
			        try {
			          Files.createDirectory(imageSubPath3);
			        } catch (NoSuchFileException ex) {
			          System.err.println(ex);
			        } catch (IOException ex) {
			          System.err.println(ex);
			        }
			      }
			      /*@@@sub2画像の時の処理*/
			      int dotSub3 = form.getFile().getOriginalFilename().lastIndexOf(".");
			      String extentionSub3 = "";
			      if (dotSub3 > 0) {
			        extention = form.getFile().getOriginalFilename().substring(dotSub3).toLowerCase();
			      }
			      String filenameSub3 = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
			      Path uploadfileSub3 = Paths
			          .get("src/main/resources/static/image_sub1/" + filenameSub3 + extentionSub3);
			      
			      try (OutputStream os = Files.newOutputStream(uploadfileSub3, StandardOpenOption.CREATE)) {
			        byte[] bytes = form.getFile().getBytes();
			        os.write(bytes);
			      } catch (IOException ex) {
			        System.err.println(ex);
			      }
			      form.setPicture_sub3(filenameSub3 + extentionSub3);
	      
	    if (result.hasErrors()) {
	        return "redirect:../";
	    }
	    
	    
	      
	    
	    Item item = new Item();
	    //Date date = new Date();
	    //item.setTime(date);
	    item.setUser(user);
	    
	    BeanUtils.copyProperties(form, item);
	    topPageService.create(item,userDatails.getUser());
	    return "redirect:../";
	}

}
	

