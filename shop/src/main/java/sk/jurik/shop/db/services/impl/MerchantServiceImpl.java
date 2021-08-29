package sk.jurik.shop.db.services.impl;

import sk.jurik.shop.db.repositories.MerchantRepository;
import sk.jurik.shop.db.services.api.MerchantService;
import sk.jurik.shop.domain.Merchant;

import java.util.List;

public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;

    public MerchantServiceImpl(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public List<Merchant> getAllMerchants() {
        return merchantRepository.getAllMerchants();
    }

    @Override
    public Merchant getMerchant(int id) {
        return merchantRepository.getMerchant(id);
    }

    @Override
    public Integer addMerchant(Merchant merchant) {
        return merchantRepository.addMerchant(merchant);
    }
}
