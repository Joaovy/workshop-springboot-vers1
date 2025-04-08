package com.projectWebService.webService.services;

import com.projectWebService.webService.entities.Category;
import com.projectWebService.webService.entities.Product;
import com.projectWebService.webService.repositories.CategoryRepository;
import com.projectWebService.webService.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Para que você use o useResource a classe userServices precisa ser um componente
@Service
public class ProductServices {

    @Autowired
    //dependecia
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){

        Optional<Product> obj = repository.findById(id);
        return obj.get();

    }


}
