package sk.jurik.shop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.jurik.shop.db.services.api.CustomerAccountService;
import sk.jurik.shop.db.services.api.CustomerService;
import sk.jurik.shop.domain.Customer;
import sk.jurik.shop.domain.CustomerAccount;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerAccountService customerAccountService;

    public CustomerController(CustomerService customerService, CustomerAccountService customerAccountService) {
        this.customerService = customerService;
        this.customerAccountService = customerAccountService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Customer customer){
        Integer id = customerService.addCustomer(customer);
        if(id != null) {
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id){
        Customer customer = customerService.getCustomer(id);

        if (customer == null){
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity getAll(){
        List<Customer> customerList = customerService.getAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity addAccount(@RequestBody CustomerAccount customerAccount){
        customerAccountService.addCustomerAccount(customerAccount);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
