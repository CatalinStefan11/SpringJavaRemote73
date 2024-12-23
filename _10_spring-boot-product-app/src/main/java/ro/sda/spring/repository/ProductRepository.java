package ro.sda.spring.repository;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ro.sda.spring.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Repository
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;

    // injection by constructor (no @Autowired required)
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS product(id bigint auto_increment, " +
                "name varchar(255), description varchar(255), price double)";
        jdbcTemplate.update(sql);
        log.info("Database initialized with table product.");
    }

    public void addProduct(Product p) {
        String sql = "INSERT INTO product(name, description, price) VALUES(?,?,?)";
        jdbcTemplate.update(sql, p.getName(), p.getDescription(), p.getPrice());
        log.info("Product {} was added to the database!", p);
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Product(rs.getInt("id"), rs.getString("name"),
                rs.getString("description"), rs.getDouble("price")));
    }

    public Product getById(int id) {
        String sql = "SELECT * FROM product WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new ProductRowMapper(), id);
    }

    public void update(int id, Product p) {
        String sql = "UPDATE product SET name = ?, description = ?, price = ? WHERE id = ?";
        jdbcTemplate.update(sql, p.getName(), p.getDescription(), p.getPrice(), id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Product> queryPriceGraterThan(int price) {
        String sql = "SELECT * FROM product WHERE price >= ?";
        return jdbcTemplate.query(sql, new ProductRowMapper(), price);
    }

    static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Product(rs.getInt("id"), rs.getString("name"),
                    rs.getString("description"), rs.getDouble("price"));
        }
    }
}
