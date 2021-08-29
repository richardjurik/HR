package sk.jurik.shop.db.services.api;

import sk.jurik.shop.domain.BoughtProduct;

import java.util.List;

public interface BoughtProductService {

    void addBoughtProduct(BoughtProduct boughtProduct);

    List<BoughtProduct> getAllByCustomerId(int customerId);
}
