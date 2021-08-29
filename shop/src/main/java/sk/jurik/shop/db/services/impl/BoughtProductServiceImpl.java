package sk.jurik.shop.db.services.impl;

import org.springframework.stereotype.Service;
import sk.jurik.shop.db.repositories.BoughtProductRepository;
import sk.jurik.shop.db.services.api.BoughtProductService;
import sk.jurik.shop.domain.BoughtProduct;

import java.util.List;

@Service
public class BoughtProductServiceImpl implements BoughtProductService {

    private final BoughtProductRepository boughtProductRepository;

    public BoughtProductServiceImpl(BoughtProductRepository boughtProductRepository) {
        this.boughtProductRepository = boughtProductRepository;
    }

    @Override
    public void addBoughtProduct(BoughtProduct boughtProduct) {
        boughtProductRepository.addBoughtProduct(boughtProduct);
    }

    @Override
    public List<BoughtProduct> getAllByCustomerId(int customerId) {
        return boughtProductRepository.getAllByCustomerId(customerId);
    }
}
