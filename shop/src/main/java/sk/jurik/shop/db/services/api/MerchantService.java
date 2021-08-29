package sk.jurik.shop.db.services.api;

import org.springframework.lang.Nullable;
import sk.jurik.shop.domain.Merchant;

import java.util.List;

public interface MerchantService {

    List<Merchant> getAllMerchants();

    @Nullable
    Merchant getMerchant(int id);

    @Nullable
    Integer addMerchant(Merchant merchant); //returns generated id
}
