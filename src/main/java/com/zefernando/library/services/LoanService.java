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

    public Loan createLoan(LoanDto loanDto) {
        Loan loan = new Loan();
        loan.setBook(loanDto.book());
        loan.setUser(loanDto.user());
        loan.setStatus(loanDto.status());
        loan.setReturnDate(loanDto.returnDate());

        return repository.save(loan);
    }

    public List<Loan> getAllLoans() {
        return repository.findAll();
    }

    public List<Loan> getLoansByBookId(Long bookId) {
        return repository.findByBookId(bookId);
    }

    public List<Loan> getLoansByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public List<Loan> getLoansByStatus(Status status) {
        return repository.findByStatus(status);
    }

    public Loan updateLoan(Long id, LoanDto loanDto) {
        Loan dbLoan = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Loan not found with id: " + id));

        dbLoan.setBook(loanDto.book());
        dbLoan.setUser(loanDto.user());
        dbLoan.setStatus(loanDto.status());
        dbLoan.setReturnDate(loanDto.returnDate());

        return repository.save(dbLoan);
    }

    public void deleteLoan(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Loan not found with id: " + id);
        }
        repository.deleteById(id);
    }
}