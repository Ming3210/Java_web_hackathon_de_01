package ra.java_web_13_hackathon_de_01.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ra.java_web_13_hackathon_de_01.model.Category;
import ra.java_web_13_hackathon_de_01.model.Product;
import ra.java_web_13_hackathon_de_01.service.CategoryService;
import ra.java_web_13_hackathon_de_01.service.ProductService;

import java.util.List;
import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    Cloudinary cloudinary;

     @GetMapping("/products")
     public String listProducts(Model model) {
         List<Product> products = productService.findAll();
         List<Category> categories = categoryService.findAll();
         model.addAttribute("products", products);
         model.addAttribute("categories", categories);
         return "product-list";
     }

    @GetMapping("/products/add")
    public String showAddProductForm(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new Product());
        return "product-add";
    }


    @PostMapping("/products/add")
    public String addProductAndUploadImg(Product product){
        if (product.getImageFile() != null && !product.getImageFile().isEmpty()) {
            try {
                Map uploadResult = cloudinary.uploader().upload(product.getImageFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                String imageUrl = (String) uploadResult.get("secure_url");
                product.setImageUrl(imageUrl);
                System.out.println(product.getImageUrl());

            } catch (Exception e) {
                e.getMessage();
            }
        }
        productService.save(product);
        return "redirect:/products";

    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/products";
    }



    @GetMapping("/product/edit/{id}")
    public String showEditCategoryForm(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "product-edit";
        } else {
            return "redirect:/product";
        }
    }

    @PostMapping("/product/edit/{id}")
    public String editCategory(@PathVariable("id") int id, Product product) {
        product.setProductId(id);
        productService.update(product);
        return "redirect:/product";
    }


}
