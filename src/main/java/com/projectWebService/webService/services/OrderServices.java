package com.projectWebService.webService.services;

import com.projectWebService.webService.entities.Order;
import com.projectWebService.webService.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Para que você use o useResource a classe userServices precisa ser um componente
@Service
public class OrderServices {

    @Autowired
    //dependecia
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){

        Optional<Order> obj = repository.findById(id);
        return obj.get();

    }


}
