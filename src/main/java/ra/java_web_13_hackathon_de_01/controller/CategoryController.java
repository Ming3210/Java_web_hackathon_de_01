package ra.java_web_13_hackathon_de_01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.java_web_13_hackathon_de_01.model.Category;
import ra.java_web_13_hackathon_de_01.model.Product;
import ra.java_web_13_hackathon_de_01.service.CategoryService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/categories")
    public String listProducts(Model model) {

        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "category-list";
    }


    @GetMapping("/categories/add")
    public String showAddCategoriesForm(Model model) {
        Category category = new Category();

        model.addAttribute("category", category);
        return "category-add";
    }


    @PostMapping("/categories/add")
    public String addCategory(@Valid Category category, Model model) {

        categoryService.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String showEditCategoryForm(@PathVariable("id") int id, Model model) {
        Category category = categoryService.findById(id);
        if (category != null) {
            model.addAttribute("category", category);
            return "category-edit";
        } else {
            return "redirect:/categories";
        }
    }

    @PostMapping("/categories/edit/{id}")
    public String editCategory(@PathVariable("id") int id, Category category) {
        category.setCategoryId(id);
        categoryService.updateCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }




}
