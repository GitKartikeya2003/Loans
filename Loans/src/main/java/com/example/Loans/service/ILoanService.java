package com.example.Loans.service;


import com.example.Loans.dto.LoansDto;
import org.springframework.beans.factory.annotation.Autowired;

public interface ILoanService {

    void createLoan(String mobileNumber);


    LoansDto fetchLoan(String mobileNumber);


//    boolean updateLoan(LoansDto loansDto);
//
//    /**
//     *
//     * @param mobileNumber - Input Mobile Number
//     * @return boolean indicating if the delete of loan details is successful or not
//     */
//    boolean deleteLoan(String mobileNumber);

}