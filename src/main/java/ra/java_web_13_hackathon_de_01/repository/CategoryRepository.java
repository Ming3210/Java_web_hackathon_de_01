package ra.java_web_13_hackathon_de_01.repository;

import ra.java_web_13_hackathon_de_01.model.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    Category findById(int id);
    boolean addCategory(Category category);
    boolean deleteCategory(int id);
    boolean updateCategory(Category category);
}
