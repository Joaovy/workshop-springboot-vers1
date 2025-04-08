package com.projectWebService.webService.resource;

import com.projectWebService.webService.entities.Category;
import com.projectWebService.webService.entities.Order;
import com.projectWebService.webService.services.CategoryServices;
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
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryServices services;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){

        List<Category> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostConstruct
    public void init() {
        System.out.println("UserResource carregado com sucesso!");
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = services.findById(id);

        return  ResponseEntity.ok().body(obj);
    }


}
