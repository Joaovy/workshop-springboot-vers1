package com.projectWebService.webService.resource;

import com.projectWebService.webService.entities.User;
import com.projectWebService.webService.services.UserServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserServices services;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        List<User> list = services.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostConstruct
    public void init() {
        System.out.println("UserResource carregado com sucesso!");
    }
    // Recuperando recurso do banco de dados
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = services.findById(id);

        return  ResponseEntity.ok().body(obj);
    }

    //Inserindo um novo recurso
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = services.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }


}
