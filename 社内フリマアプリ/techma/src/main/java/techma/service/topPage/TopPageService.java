package techma.service.topPage;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import techma.domain.categories.Category;
import techma.domain.items.Item;
import techma.domain.users.User;
import techma.repository.repositoryUser.RepositoryUser;
import techma.repository.repositorycategories.RepositoryCategory;
import techma.repository.topPage.TopPageRepository;

@Service
@Transactional
public class TopPageService {
    @Autowired
    TopPageRepository topPageRepository;
    
    @Autowired
    RepositoryCategory repositoryCategory;
    
    @Autowired
    RepositoryUser repositoryUser;

    public List<Item> findAll() {
        return topPageRepository.findAllOrderByName();
    }
    
    public Page<Item> findAll(Pageable pageable) {
        return topPageRepository.findAllOrderByName(pageable);
    }
    
    public Item findOne(Integer id) {
	    return topPageRepository.getOne(id);
	}  
	public Item create(Item item, User user) {
		item.setUser(user);
		
	    return topPageRepository.save(item);
    }

	public Item update(Item item) {
	    return topPageRepository.save(item);
    }

    public void delete(Integer id) {
    	topPageRepository.deleteById(id);
	    }
    
    //KeyWord Search
    public List<Item> search(String itemName){
    	List<Item> results = topPageRepository.search(itemName);
    	return results;
    }
    
    //Category All Get
    public List<Category> findAllGetCategory() {
        return topPageRepository.findAllCategory();
    }
    
    //Category Search
    public List<Item> searchCategory(int itemCategory) {
    	List<Item> results = topPageRepository.searchcatogory(itemCategory);
    	return results;
    }
    public List<User> findAllGetUser() {
        return repositoryUser.findAllUser();
    }
    
    public User create(User user) {
	    return repositoryUser.save(user);
    }
}
