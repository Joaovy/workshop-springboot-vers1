package com.projectWebService.webService.services;

import com.projectWebService.webService.entities.User;
import com.projectWebService.webService.repositories.UserReposiory;
import com.projectWebService.webService.services.exceptions.DatabaseException;
import com.projectWebService.webService.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Date;
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

        // Tenta buscar um objeto do tipo User no banco de dados, usando o ID fornecido.
        // O metodo findById retorna um Optional, que pode ou não conter um valor.
        Optional<User> obj = repository.findById(id);
        // oElseThrow ele procuara pelo id caso não exista ele lança a exeção ResourceNotFoundException passando o ID como argumento.
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public User insert(User obj){
        return repository.save((obj));
    }

    public void delete(Long id){

        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);

        } catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName((obj.getName()));
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());

    }


}
