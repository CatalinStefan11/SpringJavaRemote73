package ro.sda.spring.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.spring.mapper.ProductRowMapper;
import ro.sda.spring.model.Product;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    void init() {
        String sql = "CREATE TABLE IF NOT EXISTS product(id bigint auto_increment, name varchar(255), price double)";
        jdbcTemplate.update(sql);
    }

    public void addProduct(String name, double price) {
        String sql = "INSERT INTO product(name, price) VALUES (?, ?)";
        jdbcTemplate.update(sql, name, price);
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    public void addWithoutTransaction(List<Product> products) {
        String sql = "INSERT INTO product(name, price) VALUES (?, ?)";

        for (var p : products) {
            jdbcTemplate.update(sql, p.getName(), p.getPrice());
            throw new RuntimeException("Something wrong occurred");
        }
    }

    @Transactional
    public void addWithTransaction(List<Product> products) {
        String sql = "INSERT INTO product(name, price) VALUES (?, ?)";

        for (var p : products) {
            jdbcTemplate.update(sql, p.getName(), p.getPrice());
            throw new RuntimeException("Something wrong occurred");
        }
    }
}
