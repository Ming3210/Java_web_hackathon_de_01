package ra.java_web_13_hackathon_de_01.service;

import ra.java_web_13_hackathon_de_01.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
    boolean addCategory(Category category);
    boolean deleteCategory(int id);
    boolean updateCategory(Category category);
}
