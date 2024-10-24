package ro.sda.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.spring.model.Product;
import ro.sda.spring.repository.ProductRepository;

import java.util.List;

@Slf4j
@Service
public class ProductService {
    private ProductRepository productRepository;

    // injection by setter (@Autowired is required)
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product p) {
        log.info("Attempt to add product {} to the database", p);
        productRepository.addProduct(p);
    }

    public List<Product> getAllProducts() {
        log.info("Attempt to retrieve all the products from the database");
        return productRepository.getAllProducts();
    }
}
