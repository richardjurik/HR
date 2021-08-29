package sk.jurik.shop.db.services.impl;

import org.springframework.stereotype.Service;
import sk.jurik.shop.db.repositories.CustomerAccountRepository;
import sk.jurik.shop.db.services.api.CustomerAccountService;
import sk.jurik.shop.domain.CustomerAccount;

@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {

    private final CustomerAccountRepository customerAccountRepository;

    public CustomerAccountServiceImpl(CustomerAccountRepository customerAccountRepository) {
        this.customerAccountRepository = customerAccountRepository;
    }

    @Override
    public void addCustomerAccount(CustomerAccount customerAccount) {
        customerAccountRepository.addCustomerAccount(customerAccount);
    }

    @Override
    public Double getMoney(int customerId) {
        return customerAccountRepository.getMoney(customerId);
    }

    @Override
    public void setMoney(int customerId, double money) {
        customerAccountRepository.setMoney(customerId,money);
    }
}
