package sk.jurik.shop.db.services.impl;

import org.springframework.stereotype.Service;
import sk.jurik.shop.db.repositories.CustomerRepository;
import sk.jurik.shop.db.services.api.CustomerService;
import sk.jurik.shop.domain.Customer;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    @Override
    public Customer getCustomer(int id) {
        return customerRepository.getCustomer(id);
    }

    @Override
    public Integer addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }
}
