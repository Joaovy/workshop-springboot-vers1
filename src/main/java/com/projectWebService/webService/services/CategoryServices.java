package com.projectWebService.webService.services;

import com.projectWebService.webService.entities.Category;
import com.projectWebService.webService.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Para que você use o useResource a classe userServices precisa ser um componente
@Service
public class CategoryServices {

    @Autowired
    //dependecia
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){

        Optional<Category> obj = repository.findById(id);
        return obj.get();

    }


}
