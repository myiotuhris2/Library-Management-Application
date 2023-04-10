package com.xfactor.openlibrary.controllers;

import java.util.List;
import java.util.Optional;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xfactor.openlibrary.domain.Loan;
import com.xfactor.openlibrary.repositories.LoanRepository;

@RestController
@RequestMapping("loan")
public class LoanController {

    private LoanRepository loanRepository;
    public LoanController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @PutMapping("/updateloan")
    public Loan updateLoan(@RequestBody Loan loan)
    {
        if (loan.getId() != null) {
            Loan loan2 = loanRepository.save(loan);
            return loan2;
        }
        return null;

    }

    @PostMapping("/saveloan")
    public Loan saveLoan(@RequestBody Loan loan)
    {
        return loanRepository.save(loan);
    }

    @GetMapping("/getallloans")
    public List<Loan> getAllLoans()
    {
        return loanRepository.findAll();
    }

    @GetMapping("/loanbyid/{id}")
    public Loan getLoanById(@PathVariable Long id)
    {
        Optional<Loan> optional = loanRepository.findById(id);
        if(optional.isPresent())
            return optional.get();
        else
            return null;
    }

    @GetMapping("/getloanbycheckoutdate/{checkoutDate}")
    public List<Loan> getLoanByCheckoutDate(@PathVariable String checkoutDate)
    {
        return loanRepository.findByCheckoutDate(checkoutDate);
    }

    @GetMapping("/getloanbyduedate/{dueDate}")
    public List<Loan> getLoanByDueDate(@PathVariable String dueDate)
    {
        return loanRepository.findByDueDate(dueDate);
    }

    @GetMapping("/getloanbyreturndate/{returnDate}")
    public List<Loan> getLoanByReturnDate(@PathVariable String returnDate)
    {
        return loanRepository.findByReturnDate(returnDate);
    }

    @GetMapping("/getloanbyreturndateandcheckoutdate/{returnDate}/{checkoutDate}")
    public List<Loan> getLoanByReturnDateandCheckoutDate(@PathVariable String returnDate,@PathVariable String checkoutDate)
    {
        return loanRepository.findByReturnDateAndCheckoutDate(returnDate,checkoutDate);
    }

    @GetMapping("/getloancount")
    public long getLoanCount()
    {
        return loanRepository.count();
    }

    @DeleteMapping("/deleteloan/{id}")
    public void deleteLoan(@PathVariable Long id)
    {
        if(loanRepository.existsById(id))
            loanRepository.deleteById(id);
    }
}