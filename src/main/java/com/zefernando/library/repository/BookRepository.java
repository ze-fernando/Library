package com.zefernando.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zefernando.library.models.entities.Book;
import com.zefernando.library.models.enums.AgeGroup;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByCategory(String category);
    List<Book> findByAgeGroup(AgeGroup ageGroup);
    List<Book> findByLoans_User_Id(Long userId);
    List<Book> findByYear(int year);
}