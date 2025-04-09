package com.projectWebService.webService.services;

import com.projectWebService.webService.entities.User;
import com.projectWebService.webService.repositories.UserReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Para que você use o useResource a classe userServices precisa ser um componente
@Service
public class UserServices {

    @Autowired
    //dependecia
    private UserReposiory repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){

        Optional<User> obj = repository.findById(id);
        return obj.get();

    }

    public User insert(User obj){
        return repository.save((obj));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }


}
