package com.zefernando.library.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.zefernando.library.models.dtos.LoanDto;
import com.zefernando.library.models.entities.Book;
import com.zefernando.library.models.entities.Loan;
import com.zefernando.library.models.entities.User;
import com.zefernando.library.models.enums.Status;
import com.zefernando.library.services.BookService;
import com.zefernando.library.services.LoanService;
import com.zefernando.library.services.UserService;

@Controller
public class LoanController {
    
    @Autowired
    private LoanService loanService;
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;


    @QueryMapping
    List<Loan> getAllLoans(){
        return loanService.getAll();
    }

    @QueryMapping
    Loan getLoanById(@Argument Long id){
        return loanService.getById(id);
    }

    @QueryMapping
    List<Loan> getLoansByBookId(@Argument Long bookId){
        return loanService.getByBookId(bookId);
    }

    @QueryMapping
    List<Loan> getLoansByUserId(@Argument Long userId){
        return loanService.getByUserId(userId);
    }

    @QueryMapping
    List<Loan> getLoansByStatus(@Argument Status status){
        return loanService.getByStatus(status);
    }

    @MutationMapping
    Loan createLoan(@Argument Long bookId, @Argument Long userId, @Argument Status status,
        @Argument LocalDate returnDate){

        Book book = bookService.getById(bookId);
        User user = userService.getById(userId);
            
        LoanDto loan = new LoanDto(book, status, user, returnDate);

        return loanService.create(loan);
    }

    @MutationMapping
    Loan updateLoan(@Argument Long bookId, @Argument Long userId, @Argument Status status,
    @Argument LocalDate returnDate){
        Book book = bookService.getById(bookId);
        User user = userService.getById(userId);
            
        LoanDto loan = new LoanDto(book, status, user, returnDate);

        return loanService.update(userId, loan);
    }

    @MutationMapping
    void delete(@Argument Long id){
        loanService.delete(id);
    }
}
