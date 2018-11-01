package techma.repository.topPage;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import techma.domain.categories.Category;
import techma.domain.items.Item;

public interface TopPageRepository extends JpaRepository<Item, Integer> {
	
    @Query("SELECT x FROM Item x ORDER BY x.date DESC")
    List<Item> findAllOrderByName();

   @Query("SELECT x FROM Item x ORDER BY x.date DESC")
   Page<Item> findAllOrderByName(Pageable pageable);

    //Keyword search
    @Query("select x from Item x where x.name like %:keyword% order by x.id asc")
    List<Item> search(@Param("keyword") String keyword);
    
    //Category All get
    @Query("SELECT x FROM Category x")
    List<Category> findAllCategory();
    
  //Category search
    @Query("select x from Item x where x.category.id = :keyword")
    List<Item> searchcatogory(@Param("keyword") int keyword);
}






