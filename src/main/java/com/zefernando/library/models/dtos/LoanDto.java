package com.zefernando.library.models.dtos;

import java.time.LocalDate;

import com.zefernando.library.models.entities.Book;
import com.zefernando.library.models.entities.User;
import com.zefernando.library.models.enums.Status;


public record LoanDto(
    Book book,
    Status status,
    User user,
    LocalDate returnDate
) {}
