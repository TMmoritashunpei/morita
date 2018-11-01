//package techma.web;
//
//import java.util.List;
//
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.util.CollectionUtils;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import techma.domain.categories.Category;
//import techma.domain.items.Item;
//import techma.service.categoryService.CategoryService;
//import techma.service.passChangeService.PassChangeService;
//import techma.service.topPage.TopPageService;
//
//
//
//@Controller
//@RequestMapping("login")
//public class PassChangeController {
//	@Autowired
//	PassChangeService passChangeService;
//
//	@ModelAttribute
//	CategoryForm setUpForm() {
//		return new CategoryForm();
//	}
//	
//	@GetMapping
//	String list(Model model) {
//		List<Category> categories = PassChangeService.findAll();
//		model.addAttribute("categories",categories);
//		return "categories/list";
//	}
//	
//	//パスワード変更画面を表示
//	@GetMapping("passchange")
//	String addForm(){
//		return "login/passchange";
//	}
//	
//	@PostMapping(path = "edit")
//	String edit(@RequestParam Integer id, @Validated CategoryForm form
//			, BindingResult result) {
//		if(result.hasErrors()) {
//			return editForm(id, form);
//		}
//		Category category = new Category();
//		BeanUtils.copyProperties(form, category);
//		category.setId(id);
//		PassChangeService.update(category);
//		return "redirect:/categories";
//	}
//	
//	@RequestMapping(path = "add",params = "goToTop")
//	String goToTop1() {
//		return "redirect:/categories";
//	}
//}
