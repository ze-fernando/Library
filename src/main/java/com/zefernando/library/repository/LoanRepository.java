package com.zefernando.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zefernando.library.models.entities.Loan;
import com.zefernando.library.models.enums.Status;

import java.util.List;


@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByBookId(Long bookId);
    List<Loan> findByUserId(Long userId);
    List<Loan> findByStatus(Status status);
}