package sk.jurik.shop.db.services.impl;

import org.springframework.stereotype.Service;
import sk.jurik.shop.db.services.api.*;
import sk.jurik.shop.db.services.api.request.BuyProductRequest;
import sk.jurik.shop.db.services.api.response.BuyProductResponse;
import sk.jurik.shop.domain.BoughtProduct;
import sk.jurik.shop.domain.Customer;
import sk.jurik.shop.domain.Product;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    private final ProductService productService;
    private final CustomerService customerService;
    private final CustomerAccountService customerAccountService;
    private final BoughtProductService boughtProductService;

    public ShoppingServiceImpl(ProductService productService, CustomerService customerService, CustomerAccountService customerAccountService, BoughtProductService boughtProductService) {
        this.productService = productService;
        this.customerService = customerService;
        this.customerAccountService = customerAccountService;
        this.boughtProductService = boughtProductService;
    }

    @Override
    public BuyProductResponse buyProduct(BuyProductRequest request) {
        int productId = request.getProductId();
        int customerId = request.getCustomerId();

        Product product = productService.getProduct(productId);
        if (product == null){
            return new BuyProductResponse(false,"Product with id: "+ productId +" does not exist");
        }

        Customer customer = customerService.getCustomer(customerId);
        if (customer == null){
            return new BuyProductResponse(false,"Customer with id: "+ customerId +" does not exist");
        }

        if (product.getAvailable() < request.getQuantity()){
            return new BuyProductResponse(false,"Not enough products in stock");
        }

        Double customerMoney = customerAccountService.getMoney(customerId);
        if (customerMoney == null) {
            return new BuyProductResponse(false,"Customer with id: "+ customerId +" does not have account");
        } else {

            double totalPriceOfRequest = product.getPrice() * request.getQuantity();
            if (customerMoney >= totalPriceOfRequest) {

                productService.updateAvailableInternal(productId, product.getAvailable() - request.getQuantity());
                customerAccountService.setMoney(customerId, customerMoney - totalPriceOfRequest);
                boughtProductService.addBoughtProduct(new BoughtProduct(productId,customerId,request.getQuantity()));

                return new BuyProductResponse(true);

            } else {
                return new BuyProductResponse(false,"Customer with id: "+ customerId +" does not have enough money");
            }
        }
    }
}
