package ra.java_web_13_hackathon_de_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.java_web_13_hackathon_de_01.model.Category;
import ra.java_web_13_hackathon_de_01.repository.CategoryRepository;

import java.util.List;
@Service
public class CategoryServiceImp implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public boolean addCategory(Category category) {
        return categoryRepository.addCategory(category);
    }

    @Override
    public boolean deleteCategory(int id) {
        return categoryRepository.deleteCategory(id);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryRepository.updateCategory(category);
    }
}
