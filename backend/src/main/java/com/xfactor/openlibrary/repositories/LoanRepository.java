package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.domain.Loan;

public interface LoanRepository extends JpaRepository<Loan,Long> {

    List<Loan> findByReturnDateAndCheckoutDate(String returnDate,String checkoutDate);
    List<Loan> findByCheckoutDate(String checkoutDate);
    List<Loan> findByDueDate(String dueDate);
    List<Loan> findByReturnDate(String returnDate);
}
