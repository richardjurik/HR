package sk.jurik.shop.db.services.api;

import sk.jurik.shop.db.services.api.request.BuyProductRequest;
import sk.jurik.shop.db.services.api.response.BuyProductResponse;

public interface ShoppingService {

    BuyProductResponse buyProduct(BuyProductRequest request);
}
