package com.zefernando.library.services;

import com.zefernando.library.models.dtos.LoanDto;
import com.zefernando.library.models.entities.Loan;
import com.zefernando.library.models.enums.Status;
import com.zefernando.library.repository.LoanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    public Loan getById(Long id){
        return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Loan not found with id: " + id));
    }

    public Loan create(LoanDto loanDto) {
        Loan loan = new Loan();
        loan.setBook(loanDto.book());
        loan.setUser(loanDto.user());
        loan.setStatus(loanDto.status());
        loan.setReturnDate(loanDto.returnDate());

        return repository.save(loan);
    }

    public List<Loan> getAll() {
        return repository.findAll();
    }

    public List<Loan> getByBookId(Long bookId) {
        return repository.findByBookId(bookId);
    }

    public List<Loan> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<Loan> getByStatus(Status status) {
        return repository.findByStatus(status);
    }

    public Loan update(Long id, LoanDto loanDto) {
        Loan dbLoan = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Loan not found with id: " + id));

        dbLoan.setBook(loanDto.book());
        dbLoan.setUser(loanDto.user());
        dbLoan.setStatus(loanDto.status());
        dbLoan.setReturnDate(loanDto.returnDate());

        return repository.save(dbLoan);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Loan not found with id: " + id);
        }
        repository.deleteById(id);
    }

}