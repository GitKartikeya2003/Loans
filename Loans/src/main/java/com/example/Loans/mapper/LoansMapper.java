package com.example.Loans.mapper;

import com.example.Loans.dto.LoansDto;
import com.example.Loans.entity.Loans;
import org.springframework.stereotype.Component;


public class LoansMapper {


    public static LoansDto LoanstoLoansDto(Loans loans) {
        LoansDto loansDto = new LoansDto();
        loansDto.setLoanNumber(loans.getLoanNumber());
        loansDto.setLoanType(loans.getLoanType());
        loansDto.setTotalLoan(loans.getTotalLoan());
        loansDto.setAmountPaid(loans.getAmountPaid());
        loansDto.setMobileNumber(loans.getMobileNumber());
        loansDto.setOutstandingAmount(loans.getOutstandingAmount());

        return loansDto;
    }

    public static Loans mapToLoans(LoansDto loansDto, Loans loans) {
        loans.setLoanType(loansDto.getLoanType());
        loans.setTotalLoan(loansDto.getTotalLoan());
        loans.setAmountPaid(loansDto.getAmountPaid());
        loans.setOutstandingAmount(loans.getTotalLoan() - loans.getAmountPaid());
        loans.setLoanNumber(loansDto.getLoanNumber());
        loans.setMobileNumber(loansDto.getMobileNumber());
        return loans;
    }

}
