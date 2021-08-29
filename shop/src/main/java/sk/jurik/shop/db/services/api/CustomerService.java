package sk.jurik.shop.db.services.api;

import org.springframework.lang.Nullable;
import sk.jurik.shop.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    @Nullable
    Customer getCustomer(int id);

    @Nullable
    Integer addCustomer(Customer customer); //returns generated id
}
