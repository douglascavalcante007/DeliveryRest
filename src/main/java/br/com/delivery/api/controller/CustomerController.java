package br.com.delivery.api.controller;

import br.com.delivery.api.domain.Customer;
import br.com.delivery.api.usecases.CrudCustomer;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/delivery/customer")
public class CustomerController {

    private final CrudCustomer crudCustomer;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody Customer customer){

        crudCustomer.createCustomer(customer);

        return ResponseEntity.ok(customer);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/{phone}")
    public Customer find(@PathVariable("phone") String phone){
        return crudCustomer.findCustomerByPhone(phone);
    }

}