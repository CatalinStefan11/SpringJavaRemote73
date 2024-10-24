package ro.sda.spring.repository;


import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.sda.spring.model.Product;

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


//    static class ProductRowMapper implements RowMapper<Product> {
//        @Override
//        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
//            return new Product(rs.getInt("id"), rs.getString("name"),
//                    rs.getString("description"), rs.getDouble("price"));
//        }
//    }
}
