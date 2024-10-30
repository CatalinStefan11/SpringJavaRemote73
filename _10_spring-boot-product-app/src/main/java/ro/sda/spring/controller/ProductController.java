package ro.sda.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.sda.spring.model.Product;
import ro.sda.spring.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    // injection by field (@Autowired required)
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product p) {
        productService.addProduct(p);
    }

    @GetMapping("/product")
    public List<Product> findAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product findById(@PathVariable("id") int id) {
        return productService.getById(id);
    }

    @PutMapping("/product/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable("id") int id, @RequestBody Product p) {
        productService.update(id, p);
    }

    @DeleteMapping("/product/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) {
        productService.delete(id);
    }

    @GetMapping("/filter-products")
    public List<Product> getProductsWithPriceGreaterThan(@RequestParam("price") int price) {
        return productService.getProductsWithPriceGraterThan(price);
    }
}
