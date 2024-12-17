package com.zefernando.library.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.zefernando.library.models.dtos.BookDto;
import com.zefernando.library.models.entities.Book;
import com.zefernando.library.models.enums.AgeGroup;
import com.zefernando.library.models.enums.Status;
import com.zefernando.library.services.BookService;

@Controller
public class BookController {
    
    @Autowired
    private BookService service;

    @QueryMapping
    public List<Book> getAllBooks(){
        return service.getAll();
    }

    @QueryMapping
    public Book getBookById(@Argument Long id){
        return service.getById(id);
    }

    @QueryMapping
    public List<Book> getBooksByAuthor(@Argument String author){
        return service.getByAuthor(author);
    }

    @QueryMapping
    public List<Book> getBooksByCategory(@Argument String category){
        return service.getByCategory(category);
    }

    @QueryMapping
    public List<Book> getBooksByAgeGroup(@Argument AgeGroup ageGroup){
        return service.getByAgeGroup(ageGroup);
    }

    @QueryMapping
    public List<Book> getBooksByYear(@Argument Integer year){
        return service.getByYear(year);
    }

    
    @MutationMapping
    public Book createBook(@Argument String title, @Argument Integer year,
    @Argument Status status, @Argument String author,
    @Argument String category, @Argument AgeGroup ageGroup){
        
        BookDto book = new BookDto(
            title,
            year,
            status,
            author,
            category,
            ageGroup
        );

        return service.create(book);
    }

    @MutationMapping
    public Book updateBook(@Argument Long id, @Argument String title, @Argument Integer year,
    @Argument Status status, @Argument String author,
    @Argument String category, @Argument AgeGroup ageGroup){
        
        BookDto book = new BookDto(
            title,
            year,
            status,
            author,
            category,
            ageGroup
        );

        return service.update(id, book);
    }

    @MutationMapping
    public void deleteBook(@Argument Long id){
        service.delete(id);
    }
}
