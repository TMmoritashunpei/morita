package techma.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import techma.domain.users.User;
import techma.service.topPage.TopPageService;


@Controller
@RequestMapping("item/user")
public class UserController {
	@Autowired
	TopPageService topPageService;
	
	@ModelAttribute
	UserForm setUpForm() {
		return new UserForm();
	}
	
	@GetMapping
	String list(Model model) {
//		List<User> users = topPageService.findAllGetUser();
//		model.addAttribute("users", users);
		return "UserCreate";
	}
	
	@PostMapping(path = "create")
	String create(@Validated UserForm form, BindingResult result, Model model,String password) {
		if (result.hasErrors()) {
			return "UserCreate";
	}
		User user = new User();
		BeanUtils.copyProperties(form, user);
		
		//password change to hash
		password = user.getPassword();
		password = new Pbkdf2PasswordEncoder().encode(password);
		user.setPassword(password);
		topPageService.create(user);
		return "loginForm";
	}	
}

