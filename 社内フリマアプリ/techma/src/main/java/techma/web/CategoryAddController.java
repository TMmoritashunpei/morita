package techma.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import techma.domain.categories.Category;
import techma.service.category.CategoryService;




//@Controller
//@RequestMapping("categories/add")
public class CategoryAddController {
	@Autowired
	CategoryService categoryService;
	
	@ModelAttribute
	CategoryForm setUpForm() {
		return new CategoryForm();
	}
	
//	@GetMapping
//	String list(Model model) {
//		List<Category> categories = categoryService.findAll();
//		model.addAttribute("categories",categories);
//		return "categories/add";
//	}
	
	//編集フォームを表示する
	@GetMapping
	String addForm() {
		return "categories/add";
	}
	
//	@PostMapping(path = "add")
//	String add(@Validated CategoryForm form,BindingResult result,Model model) {
//		if(result.hasErrors()) {
//			return list(model);
//		}
//		Category category = new Category();
//		BeanUtils.copyProperties(form, category);
//		categoryService.add(category);
//		return "redirect:categories";
//	}

	
	
//	@RequestMapping(path = "add",params = "goToTop")
//	String goToTop1() {
//		return "redirect:/categories";
//	}
	

}
