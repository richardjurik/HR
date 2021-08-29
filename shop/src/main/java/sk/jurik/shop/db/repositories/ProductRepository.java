package sk.jurik.shop.db.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import sk.jurik.shop.db.mappers.CustomerRowMapper;
import sk.jurik.shop.db.mappers.ProductRowMapper;
import sk.jurik.shop.db.services.api.request.UpdateProductRequest;
import sk.jurik.shop.domain.Product;

import java.sql.*;
import java.time.Instant;
import java.util.List;

@Component
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ProductRowMapper productRowMapper = new ProductRowMapper();

    public ProductRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product getProduct(int id){
        final String sql = "select * from product where product.id = " + id;

        try {
            return jdbcTemplate.queryForObject(sql,productRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer addProduct(Product product){
        final String sql = "insert into product(merchant_id, name, description, price, created_at, available) values(?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setInt(1,product.getMerchantId());
                ps.setString(2,product.getName());
                ps.setString(3,product.getDescription());
                ps.setDouble(4,product.getPrice());
                if (product.getCreatedAt() == null){
                    product.setCreatedAt(Timestamp.from(Instant.now()));
                }
                ps.setTimestamp(5,product.getCreatedAt());
                ps.setInt(6,product.getAvailable());

                return ps;
            }
        },keyHolder);

        if (keyHolder.getKey() != null) {
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }
    }

    public List<Product> getAllProducts() {
        final String sql = "select * from product";
        return jdbcTemplate.query(sql, productRowMapper);
    }

    public void updateProduct(int id, UpdateProductRequest request){
        final String sql = "update product set name = ?, description = ?, price = ?, available = ? where id = ?";

        jdbcTemplate.update(sql, request.getName(),request.getDescription(),request.getPrice(),request.getAvailable(), id);
    }

    public void deleteProduct(int id) {
        final String sql = "delete from product where id = ?";
        jdbcTemplate.update(sql,id);
    }

    public void updateAvailable(int id, int newAvailable){
        final String sql = "UPDATE product SET available = ? WHERE id = ?";
        jdbcTemplate.update(sql,newAvailable,id);
    }
}
