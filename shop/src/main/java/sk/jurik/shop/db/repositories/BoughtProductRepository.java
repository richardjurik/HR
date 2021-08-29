package sk.jurik.shop.db.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import sk.jurik.shop.db.mappers.BoughtProductMapper;
import sk.jurik.shop.domain.BoughtProduct;

import java.util.List;

@Component
public class BoughtProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final BoughtProductMapper boughtProductMapper = new BoughtProductMapper();

    public BoughtProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBoughtProduct(BoughtProduct boughtProduct) {
        final String sql = "INSERT INTO bought_product(product_id,customer_id, quantity, bought_at) values(?,?,?,?)";
        jdbcTemplate.update(sql,boughtProduct.getProductId(),boughtProduct.getCustomerId(),boughtProduct.getQuantity(),boughtProduct.getBought_at());
    }

    public List<BoughtProduct> getAllByCustomerId(int customerId){
        final String sql = "SELECT * FROM bought_product WHERE customer_id = " + customerId;
        return jdbcTemplate.query(sql, boughtProductMapper);
    }
}
