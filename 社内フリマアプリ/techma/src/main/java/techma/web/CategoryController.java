package techma.web;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import techma.domain.categories.Category;
import techma.domain.items.Item;
import techma.service.categoryService.CategoryService;
import techma.service.topPage.TopPageService;



@Controller
@RequestMapping("categories")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	TopPageService topPageService;
	@ModelAttribute
	CategoryForm setUpForm() {
		return new CategoryForm();
	}
	
	@GetMapping
	String list(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories",categories);
		return "categories/list";
	}
	
	//カテゴリー追加フォームを表示
	@GetMapping("add")
	String addForm(){
		return "categories/add";
	}
	
	@PostMapping("add")
	String add(@Validated CategoryForm form,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "categories/add";
		}
		Category category = new Category();
		BeanUtils.copyProperties(form, category);
		categoryService.add(category);
		return "redirect:/categories";
	}
	
	//編集フォームを表示する
	@GetMapping(path = "edit" ,params = "form")
	String editForm(@RequestParam Integer id,CategoryForm form) {
		Category category = categoryService.findOne(id);
		BeanUtils.copyProperties(category, form);
		return "categories/edit";
	}
	
	@PostMapping(path = "edit")
	String edit(@RequestParam Integer id, @Validated CategoryForm form
			, BindingResult result) {
		if(result.hasErrors()) {
			return editForm(id, form);
		}
		Category category = new Category();
		BeanUtils.copyProperties(form, category);
		category.setId(id);
		categoryService.update(category);
		return "redirect:/categories";
	}
	
	@RequestMapping(path = "edit",params = "goToTop")
	String goToTop() {
		return "redirect:/categories";
	}
	
//	@RequestMapping(path = "add",params = "goToTop")
//	String goToTop1() {
//		return "redirect:/categories";
//	}
	
	@RequestMapping(path = "add",params = "goToTop")
	String goToTop1() {
		return "redirect:/categories";
	}
	
	@PostMapping(path = "delete")
	String delete(@RequestParam int keyword) {
//	       List<Item> results = topPageService.searchCategory(keyword);
//	    
//		if(results == null || results.isEmpty()) {
			categoryService.delete(keyword);
			return "redirect:/categories";
//		}else {
//			return "redirect:/categories";
//		}
	}
}
