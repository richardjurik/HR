package sk.jurik.shop.db.services.api;

import org.springframework.lang.Nullable;
import sk.jurik.shop.db.services.api.request.UpdateProductRequest;
import sk.jurik.shop.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    @Nullable
    Product getProduct(int id);

    @Nullable
    Integer addProduct(Product product); //returns generated id

    void deleteProduct(int id);

    void updateProduct(int id, UpdateProductRequest request);
}
