package techma.repository.categoryRepository;

import techma.domain.categories.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT x FROM Category x ORDER BY x.name")
    List<Category> findAllOrderByName();

    @Query("SELECT x FROM Category x ORDER BY x.name")
    Page<Category> findAllOrderByName(Pageable pageable);
}

