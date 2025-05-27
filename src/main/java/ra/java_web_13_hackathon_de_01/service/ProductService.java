package ra.java_web_13_hackathon_de_01.service;

import ra.java_web_13_hackathon_de_01.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean save(Product product);
    boolean delete(int id);
    boolean update(Product product);
    Product findById(int id);


}
