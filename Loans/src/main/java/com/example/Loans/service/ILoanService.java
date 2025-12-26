package com.example.Loans.service;


import com.example.Loans.dto.LoansDto;
import org.springframework.beans.factory.annotation.Autowired;

public interface ILoanService {

    void createLoan(String mobileNumber);


    LoansDto fetchLoan(String mobileNumber);


    boolean updateLoan(LoansDto loansDto);

  boolean deleteLoan(String mobileNumber);

}