package com.zefernando.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.zefernando.library.models.dtos.UserDto;
import com.zefernando.library.models.entities.User;
import com.zefernando.library.services.UserService;

@Controller
public class UserController {
    
    @Autowired
    private UserService service;


    @QueryMapping
    List<User> getAllUsers(){
        return service.getAll();
    }

    @QueryMapping
    List<User> getUsersByName(@Argument String name){
        return service.getByName(name);
    }

    @MutationMapping
    User createUser(@Argument String firstName, @Argument Integer age, @Argument String tel){
        UserDto user = new UserDto(
            firstName,
            age,
            tel);

        return service.create(user);
    }

    @MutationMapping
    User updateUser(@Argument UserDto user, Long id){
        return service.update(id, user);
    }

    @MutationMapping
    void deleteUser(@Argument Long id){
        service.delete(id);
    }
}
