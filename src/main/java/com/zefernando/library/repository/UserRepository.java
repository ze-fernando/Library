package com.zefernando.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zefernando.library.models.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    List<User> findByName(String name);
}
