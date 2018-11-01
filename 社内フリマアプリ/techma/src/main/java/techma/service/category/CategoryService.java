package techma.service.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import techma.domain.categories.Category;
import techma.domain.items.Item;
import techma.repository.repositorycategories.RepositoryCategory;


public class CategoryService {

	@Autowired
	RepositoryCategory repositoryCategory;
	
	public Category findOne(Integer id) {
	    return repositoryCategory.getOne(id);
	}  
	public Category create(Category category) {
	    return repositoryCategory.save(category);
    }

	public Category update(Category category) {
	    return repositoryCategory.save(category);
    }

    public void delete(Integer id) {
    	repositoryCategory.deleteById(id);
	    }
    
    //Category All Get
    public List<Category> findAllGetCategory() {
        return repositoryCategory.findAllCategory();
    }
    
    //Category Search
    public List<Item> searchCategory(int itemCategory) {
    	List<Item> results = repositoryCategory.searchcatogory(itemCategory);
    	return results;
    }
}
