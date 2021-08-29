package sk.jurik.shop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.jurik.shop.db.services.api.MerchantService;
import sk.jurik.shop.domain.Merchant;

import java.util.List;

@RestController
@RequestMapping("merchant")
public class MerchantController {

    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Merchant merchant){
        Integer id = merchantService.addMerchant(merchant);
        if(id != null) {
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("{id}")
    public ResponseEntity get(@PathVariable("id") int id){
        Merchant merchant = merchantService.getMerchant(id);

        if (merchant == null){
            return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(merchant, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity getAll(){
        List<Merchant> merchantList = merchantService.getAllMerchants();
        return new ResponseEntity<>(merchantList, HttpStatus.OK);
    }
}
