package techma.service.categoryService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import techma.domain.categories.Category;
import techma.repository.categoryRepository.CategoryRepository;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    
    public List<Category> findAll() {
        return categoryRepository.findAllOrderByName();
    }

    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAllOrderByName(pageable);
    }

    public Category findOne(Integer id) {
        return categoryRepository.getOne(id);
    }

    public Category add(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(Integer id) {
        categoryRepository.deleteById(id);
    }
}
