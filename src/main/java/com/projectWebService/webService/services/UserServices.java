package com.projectWebService.webService.services;

import com.projectWebService.webService.entities.User;
import com.projectWebService.webService.repositories.UserReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Para que você use o useResource a classe userServices precisa ser um componente
@Service
public class UserServices {

    @Autowired
    //dependecia
    private UserReposiory reposiory;

    public List<User> findAll(){
        return reposiory.findAll();
    }

    public User findById(Long id){

        Optional<User> obj = reposiory.findById(id);
        return obj.get();

    }


}
