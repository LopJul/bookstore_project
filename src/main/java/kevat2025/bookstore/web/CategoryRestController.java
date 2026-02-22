package kevat2025.bookstore.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kevat2025.bookstore.domain.Category;
import kevat2025.bookstore.domain.CategoryRepository;

@RestController
public class CategoryRestController {

  private final CategoryRepository categoryRepository;

  // Construction Injection
  public CategoryRestController(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;


  }

  @GetMapping("/categories")
  public Iterable<Category> findAllCategories() {
    return categoryRepository.findAll();
  }

  @GetMapping("/categories/{id}")
  public Optional<Category> findById(@PathVariable("id") Long categoryId) {
    return categoryRepository.findById(categoryId);
  }

  @PostMapping("/categories")
  public Category saveCategory (@RequestBody Category category) {
    return categoryRepository.save(category);
  }

  @PutMapping("categories/{id}")
  public Category saveEditedCategory(@RequestBody Category editedCategory, @PathVariable Long id) {
    editedCategory.setCategoryid(id);
    return categoryRepository.save(editedCategory);
  }

  @DeleteMapping("/categories/{id}")
  public Iterable<Category> deleteCategory (@PathVariable Long id) {
    categoryRepository.deleteById(id);
    return categoryRepository.findAll();
  }

  
}
