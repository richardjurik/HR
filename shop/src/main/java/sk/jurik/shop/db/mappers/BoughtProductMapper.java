package sk.jurik.shop.db.mappers;

import org.springframework.jdbc.core.RowMapper;
import sk.jurik.shop.domain.BoughtProduct;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoughtProductMapper implements RowMapper<BoughtProduct> {
    @Override
    public BoughtProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
        BoughtProduct boughtProduct = new BoughtProduct();
        boughtProduct.setProductId(rs.getInt("product_id"));
        boughtProduct.setCustomerId(rs.getInt("customer_id"));
        boughtProduct.setQuantity(rs.getInt("quantity"));
        boughtProduct.setBought_at(rs.getTimestamp("bought_at"));

        return boughtProduct;
    }
}
