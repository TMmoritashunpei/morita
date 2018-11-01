package techma.web.topPage;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import techma.domain.categories.Category;
import techma.domain.items.Item;
import techma.service.topPage.TopPageService;
import techma.web.ItemDetailForm;
import techma.web.ItemForm;

@Controller
@RequestMapping("item")
public class TopPageController {
    @Autowired
    TopPageService topPageService;

    @ModelAttribute
    ItemForm detailItemForm() {
      return new ItemForm();
    }

    @GetMapping
    public String getItemList(@PageableDefault(size = 8, sort="id") Pageable pageable, Model model){
    	
		Page<Item> itemList = topPageService.findAll(pageable)	;
   	    int itemListFlg = 1; //商品一覧を表示する
   	    model.addAttribute("itemListFlg", itemListFlg);
		model.addAttribute("itemList", itemList);
		model.addAttribute("url", "/item");
    	
        List<Category> categories = topPageService.findAllGetCategory();
        model.addAttribute("categories", categories);
		return "/top/toppage";
	}

    //Item Detail
    @GetMapping(path = "detail", params = "form")
    String detailForm(@RequestParam Integer id, ItemDetailForm form) {
    	Item item = topPageService.findOne(id);
    	BeanUtils.copyProperties(item, form);
    	return "item/item";
    }

 //Keyword Search
   @GetMapping(value="/search/keyword")
   public ModelAndView search(@RequestParam("keyword") String keyword, Pageable pageable, Model model){
   	   Page<Item> itemList = topPageService.findAll(pageable);
   	   int itemListFlg = 0; //商品一覧を非表示する
   	   model.addAttribute("itemList", itemList);
   	   model.addAttribute("url", "/item");
       ModelAndView mv = new ModelAndView();
       mv.setViewName("top/toppage.html");
       mv.addObject("title","検索商品一覧");
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
           	mv.addObject("msg","該当する商品がありません");
           }else {
               mv.addObject("value",results);
               mv.addObject("itemListFlg", itemListFlg);
           }
       }
   return mv;
   }
   

    //Category Search
    @GetMapping(value="/search/category")
    public ModelAndView searchCategory(@RequestParam("search") int keyword,
 		   @PageableDefault(size = 8, sort="id") Pageable pageable, Model model){
    	Page<Item> itemList = topPageService.findAll(pageable);
    	int itemListFlg = 0; //商品一覧を非表示する
    	model.addAttribute("itemList", itemList);
    	model.addAttribute("url", "/item");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("top/toppage.html");
        mv.addObject("title","カテゴリ商品一覧");
       List<Item> results = topPageService.searchCategory(keyword);
       if(results.isEmpty()) {
       	mv.addObject("msg","該当する商品がありません");
       }else {
           mv.addObject("value",results);
           mv.addObject("itemListFlg", itemListFlg);
       }
       return mv;
    }

//    //Category Link Search
    @GetMapping("/itemId2")
    @ResponseBody
    public ModelAndView redirectCategory(@RequestParam("id") Integer keyword){
    	ModelAndView mv = new ModelAndView();
    	List<Item> results = topPageService.searchCategory(keyword);
    	mv.addObject("value",results);
    	mv.setViewName("top/toppage.html");
    	return mv;
    }

    @GetMapping(value="/syuppin")
    public ModelAndView a(){
    	ModelAndView mv = new ModelAndView();
    	mv =new ModelAndView("syuppin");
    	return mv;
    }
    
    
    //Buy Item
    @PostMapping(path="/buy")
    String itemBuy(@RequestParam Integer id, @Validated ItemDetailForm form,
    	BindingResult result) {
    	Item item = new Item();
    	BeanUtils.copyProperties(form, item);
    	item.setId(id);
    	topPageService.update(item);
    	return "redirect:/item";
    }

}
