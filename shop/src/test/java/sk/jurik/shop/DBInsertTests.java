package sk.jurik.shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import sk.jurik.shop.domain.Customer;
import sk.jurik.shop.domain.Merchant;
import sk.jurik.shop.domain.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

@SpringBootTest
public class DBInsertTests {

    private final String insertCustomer = "INSERT INTO customer(name, surname, email, address, age, phone_number) values(?, ?, ?, ?, ?, ?)";
    private final String insertMerchant = "INSERT INTO merchant(name, email, address) values(?, ?, ?)";
    private final String insertProduct = "INSERT INTO product(merchant_id, name, description, price, created_at, available) values(?, ?, ?, ?, ?, ?)";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void createProduct(){
        Product product = new Product();
        product.setMerchantId(7);
        product.setName("Pohar");
        product.setDescription("Velmi dobry");
        product.setPrice(21.5);
        product.setCreatedAt(Timestamp.from(Instant.now()));
        product.setAvailable(10);

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertProduct);
                ps.setInt(1,product.getMerchantId());
                ps.setString(2,product.getName());
                ps.setString(3,product.getDescription());
                ps.setDouble(4,product.getPrice());
                ps.setTimestamp(5,product.getCreatedAt());
                ps.setInt(6,product.getAvailable());
                return ps;
            }
        });
    }

    @Test
    public void createCustomer() {
        Customer customer = new Customer();
        customer.setName("Jan");
        customer.setSurname("Hrach");
        customer.setEmail("email");
        customer.setAddress("address");
        customer.setAge(28);
        customer.setPhoneNumber("999");

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertCustomer);
                ps.setString(1,customer.getName());
                ps.setString(2,customer.getSurname());
                ps.setString(3,customer.getEmail());
                ps.setString(4,customer.getAddress());
                ps.setInt(5,customer.getAge());
                ps.setString(6,customer.getPhoneNumber());

                return ps;
            }
        });
    }

    @Test
    public void createMerchant() {
        Merchant merchant = new Merchant();
        merchant.setName("Anna");
        merchant.setEmail("emailA");
        merchant.setAddress("AddressA");

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(insertMerchant);
                ps.setString(1, merchant.getName());
                ps.setString(2, merchant.getEmail());
                ps.setString(3, merchant.getAddress());

                return ps;
            }
        });

    }
}
