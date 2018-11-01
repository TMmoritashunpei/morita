package techma.web.admin;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import techma.domain.categories.Category;
import techma.domain.items.Item;
import techma.service.topPage.TopPageService;
import techma.web.ItemDetailForm;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    TopPageService topPageService;

    @GetMapping
    String list(Model model) {
        List<Item> items = topPageService.findAll();
        model.addAttribute("items", items);
        
        //About Category
        List<Category> categories = topPageService.findAllGetCategory();
        model.addAttribute("categories", categories);
        return "kanri_kensaku";
    }
    
    //Item Detail
    @GetMapping(path="detail", params="detail")
    String itemDetail(@RequestParam Integer id, ItemDetailForm detail, Model model) {
    	Item item = topPageService.findOne(id);
    	model.addAttribute("item", item);
    	BeanUtils.copyProperties(item, detail);
    	return "item/kanri_item";
    }
    
    //Keyword Search
    @GetMapping(path="search/keyword")
    public ModelAndView search(@RequestParam("keyword") String keyword){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("kanri_kensaku.html");
    	//if:About keyword
        if(keyword ==""){
        	mv.addObject("msg","キーワードを入力してください。");
        }else if(keyword.length() > 30){
        	mv.addObject("msg","30字以内で入力してください。");
        }
        else{
        	//if:About results
            List<Item> results = topPageService.search(keyword);
            if(results.isEmpty()) {
            	mv.addObject("msg","該当する商品はありません。");
            }else {
                mv.addObject("value",results);
            }
        }
    return mv;
    }    
    
    //Category Search
    @GetMapping(value="search/category")
    public ModelAndView searchCategory(@RequestParam("search") int keyword){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("kanri_kensaku.html");
    	List<Item> results = topPageService.searchCategory(keyword);
    	
    	if(results.isEmpty()) {
        	mv.addObject("msg","検索結果はありません。");
        }else {
            mv.addObject("value",results);
        }
    return mv;
    }
    
    
    //Keyword or Category Search
    @GetMapping(path="search")
    public ModelAndView searchKeywordOrCategory(@RequestParam("keyword") String keyword1,@RequestParam("category") int keyword2){
    	ModelAndView mv = new ModelAndView();
        mv.setViewName("kanri_kensaku.html");
        
    	//if:About keyword or category
        if(keyword1 == "") {
        	List<Item> results = topPageService.searchCategory(keyword2);
        	
        	if(results.isEmpty()){
            	mv.addObject("msg","検索結果はありません。");
            }else {
                mv.addObject("value",results);
            }
        	
        }else if(keyword2 == -1 ){
        	String keyword = keyword1;
        	if(keyword ==""){
            	mv.addObject("msg","キーワードを入力してください。");
            }else if(keyword.length() > 30){
            	mv.addObject("msg","30字以内で入力してください。");
            }
            else{
            	//if:About results
                List<Item> results = topPageService.search(keyword);
                if(results.isEmpty()) {
                	mv.addObject("msg","検索結果はありません。");
                }else {
                    mv.addObject("value",results);
                }
            }
        }
    return mv;
    }
    
    //Hide Item
    @PostMapping(path="detail/hide")
    String itemHide(@RequestParam Integer id, @Validated ItemDetailForm form,
    		BindingResult result, Model model) {
    	Item item = new Item();
    	BeanUtils.copyProperties(form, item);
    	item.setId(id);
    	topPageService.update(item);
    	model.addAttribute("item", item);
    	return "redirect:/admin";
    }
    
    //Delete Item
    @PostMapping(path="detail/delete")
    String deleteItem(@RequestParam Integer id) {
    	topPageService.delete(id);
    	return "redirect:/admin";
    }
}

