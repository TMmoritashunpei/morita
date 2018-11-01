package techma.repository.repositorycategories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import techma.domain.categories.Category;
import techma.domain.items.Item;


public interface RepositoryCategory extends JpaRepository<Category, Integer>{
	//Category All get
    @Query("SELECT x FROM Category x")
    List<Category> findAllCategory();
    
  //Category search
    @Query("select x from Item x where x.category.id = :keyword")
    List<Item> searchcatogory(@Param("keyword") int keyword);

}
