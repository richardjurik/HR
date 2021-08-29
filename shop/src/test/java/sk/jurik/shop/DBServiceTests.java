package sk.jurik.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import sk.jurik.shop.db.services.api.CustomerService;
import sk.jurik.shop.db.services.api.MerchantService;
import sk.jurik.shop.db.services.api.ProductService;
import sk.jurik.shop.db.services.api.request.UpdateProductRequest;
import sk.jurik.shop.domain.Customer;
import sk.jurik.shop.domain.Merchant;
import sk.jurik.shop.domain.Product;

import java.util.List;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
public class DBServiceTests {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private ProductService productService;

    private Merchant merchant;

    @BeforeEach
    public void createMerchant(){
        if (merchant == null){
            merchant = new Merchant("Jan","jan@email","Janov");
            Integer id = merchantService.addMerchant(merchant);
            assert id != null;
            merchant.setId(id);
        }
    }

    @Test
    public void customer(){
        Customer customer = new Customer("Jan","Sur","jan@email","Janov",20,"999");
        Integer id = customerService.addCustomer(customer);
        assert id != null;

        customer.setId(id);
        Customer fromDb = customerService.getCustomer(id);
        Assertions.assertEquals(customer,fromDb);

        List<Customer> customers = customerService.getAllCustomers();
        Assertions.assertEquals(1,customers.size());
        Assertions.assertEquals(customer,customers.get(0));
    }

    @Test
    public void merchant(){
        //already created merchant in createMerchant function

        Merchant fromDb = merchantService.getMerchant(merchant.getId());
        Assertions.assertEquals(merchant,fromDb);

        List<Merchant> merchants = merchantService.getAllMerchants();
        Assertions.assertEquals(1,merchants.size());
        Assertions.assertEquals(merchant,merchants.get(0));
    }

    @Test
    public void product(){
        Product product = new Product(merchant.getId(),"name","desc",5,1);
        Integer id = productService.addProduct(product);
        assert id != null;

        product.setId(id);
        Product fromDb = productService.getProduct(id);
        Assertions.assertEquals(product,fromDb);

        List<Product> products = productService.getAllProducts();
        Assertions.assertEquals(1,products.size());
        Assertions.assertEquals(product,products.get(0));

        product.setAvailable(10);
        UpdateProductRequest productRequest = new UpdateProductRequest(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAvailable()
        );

        productService.updateProduct(id,productRequest);
        Product fromDbAfterUpdate = productService.getProduct(id);
        Assertions.assertEquals(product,fromDbAfterUpdate);
        Assertions.assertNotEquals(fromDbAfterUpdate,fromDb);

        productService.deleteProduct(id);
        Assertions.assertEquals(0, productService.getAllProducts().size());
    }

}
