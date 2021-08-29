package sk.jurik.shop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.jurik.shop.db.services.api.ProductService;
import sk.jurik.shop.db.services.api.request.UpdateProductRequest;
import sk.jurik.shop.domain.Product;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Product product){
        Integer id = productService.addProduct(product);
        if(id != null) {
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id){
        Product product = productService.getProduct(id);

        if (product == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity getAll(){
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PatchMapping("{id}")
    public ResponseEntity updateProduct(@PathVariable("id") int id, @RequestBody UpdateProductRequest request){
        if (productService.getProduct(id) != null){
            productService.updateProduct(id, request);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Product with id: "+ id + " does not exist");
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id){
        if (productService.getProduct(id) != null){
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Product with id: "+ id + " does not exist");
        }
    }
}
