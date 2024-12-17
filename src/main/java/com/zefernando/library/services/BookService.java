package com.zefernando.library.services;

import com.zefernando.library.models.dtos.BookDto;
import com.zefernando.library.models.entities.Book;
import com.zefernando.library.models.enums.AgeGroup;
import com.zefernando.library.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book createBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.title());
        book.setYear(bookDto.year());
        book.setStatus(bookDto.status());
        book.setAuthor(bookDto.author());
        book.setCategory(bookDto.category());
        book.setAgeGroup(bookDto.ageGroup());

        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public List<Book> getBooksByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public List<Book> getBooksByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Book> getBooksByAgeGroup(AgeGroup ageGroup) {
        return repository.findByAgeGroup(ageGroup);
    }

    public List<Book> getBooksByYear(Integer year) {
        return repository.findByYear(year);
    }

    public Book updateBook(Long id, BookDto bookDto) {
        Book dbBook = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        dbBook.setTitle(bookDto.title());
        dbBook.setYear(bookDto.year());
        dbBook.setStatus(bookDto.status());
        dbBook.setAuthor(bookDto.author());
        dbBook.setCategory(bookDto.category());
        dbBook.setAgeGroup(bookDto.ageGroup());

        return repository.save(dbBook);
    }

    public void deleteBook(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Book not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
