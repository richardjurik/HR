package sk.jurik.shop.db.services.impl;

import org.springframework.stereotype.Service;
import sk.jurik.shop.db.repositories.ProductRepository;
import sk.jurik.shop.db.services.api.ProductService;
import sk.jurik.shop.db.services.api.request.UpdateProductRequest;
import sk.jurik.shop.domain.Product;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }

    @Override
    public Integer addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public void updateProduct(int id, UpdateProductRequest request) {
        productRepository.updateProduct(id, request);
    }

    @Override
    public void updateAvailableInternal(int id, int newAvailable) {
        productRepository.updateAvailable(id, newAvailable);
    }
}
