package ro.sda.spring.service;

import org.springframework.stereotype.Service;
import ro.sda.spring.model.Product;
import ro.sda.spring.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product p) {
        System.out.println("Adding product " + p + " to the database");
        productRepository.addProduct(p.getName(), p.getPrice());
    }

    public List<Product> getAllProducts() {
        System.out.println("Getting all the products from the database");
        return productRepository.getAllProducts();
    }

    public void addWithoutTransaction(List<Product> products) {
        System.out.println("Adding multiple products to database without transaction!");
        productRepository.addWithoutTransaction(products);
    }

    public void addWithTransaction(List<Product> products) {
        System.out.println("Adding multiple products to the database with transaction!");
        productRepository.addWithTransaction(products);
    }
}
