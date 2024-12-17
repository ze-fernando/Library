package com.zefernando.library.services;

import com.zefernando.library.models.dtos.UserDto;
import com.zefernando.library.models.entities.User;
import com.zefernando.library.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;


    public User create(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.firstName());
        user.setAge(userDto.age());
        user.setTel(userDto.tel());

        return repository.save(user);
    }

    public User getById(Long id){
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public List<User> getByName(String name) {
        return repository.findByName(name);
    }

    public User update(Long id, UserDto userDto) {
        User dbUser = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        dbUser.setFirstName(userDto.firstName());
        dbUser.setAge(userDto.age());
        dbUser.setTel(userDto.tel());

        return repository.save(dbUser);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
