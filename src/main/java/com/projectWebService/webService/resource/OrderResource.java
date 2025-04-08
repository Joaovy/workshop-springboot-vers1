package com.projectWebService.webService.resource;

import com.projectWebService.webService.entities.Order;
import com.projectWebService.webService.services.OrderServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderServices services;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){

        List<Order> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostConstruct
    public void init() {
        System.out.println("UserResource carregado com sucesso!");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order obj = services.findById(id);

        return  ResponseEntity.ok().body(obj);
    }


}
