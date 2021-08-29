package sk.jurik.shop.db.services.api;

import org.springframework.lang.Nullable;
import sk.jurik.shop.domain.CustomerAccount;

public interface CustomerAccountService {

    void addCustomerAccount(CustomerAccount customerAccount);

    @Nullable
    Double getMoney(int customerId);

    void setMoney(int customerId, double money);
}
