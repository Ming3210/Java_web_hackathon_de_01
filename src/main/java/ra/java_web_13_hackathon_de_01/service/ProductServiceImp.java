package ra.java_web_13_hackathon_de_01.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.java_web_13_hackathon_de_01.model.Product;
import ra.java_web_13_hackathon_de_01.repository.ProductRepository;

import java.util.List;
@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean delete(int id) {
        return productRepository.delete(id);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }
}
