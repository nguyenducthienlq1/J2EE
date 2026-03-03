package phattrienungdungvoi2ee.bai4_qlsp.Service;

import org.springframework.stereotype.Service;
import phattrienungdungvoi2ee.bai4_qlsp.Model.Category;
import phattrienungdungvoi2ee.bai4_qlsp.repositories.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }
    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }
}
