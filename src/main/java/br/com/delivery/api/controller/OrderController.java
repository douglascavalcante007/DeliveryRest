package br.com.delivery.api.controller;

import br.com.delivery.api.domain.Order;
import br.com.delivery.api.usecases.CrudOrder;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("v1/delivery/order")
public class OrderController {
    private final CrudOrder crudOrder;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody Order order){

        crudOrder.createOrder(order);

        return ResponseEntity.ok(order);
    }
}