package com.example.Loans.service.serviceImpl;

import com.example.Loans.constant.LoanConstants;
import com.example.Loans.dto.LoansDto;
import com.example.Loans.entity.Loans;
import com.example.Loans.exception.LoanAlreadyExistsException;
import com.example.Loans.exception.LoanNotFoundException;
import com.example.Loans.mapper.LoansMapper;
import com.example.Loans.repository.LoansRepository;
import com.example.Loans.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;


@Service
public class ServiceImpl implements ILoanService {

    @Autowired
    private LoansRepository loansRepository;

    @Override
    public void createLoan(String mobileNumber) {

        Optional<Loans> optional = loansRepository.findByMobileNumber(mobileNumber);
        if (optional.isPresent()) {
            throw new LoanAlreadyExistsException(mobileNumber);
        } else {
            Loans loan = new Loans();
            loan = createNewLoan(mobileNumber);
            loansRepository.save(loan);
        }


    }

    public Loans createNewLoan(String mobileNumber) {
        long randomLoanNumber = 100000000000L + new Random().nextInt(900000000);
        Loans loans = new Loans();
        loans.setMobileNumber(mobileNumber);

        loans.setLoanNumber(String.valueOf(randomLoanNumber));
        loans.setLoanType(LoanConstants.Personal);
        loans.setTotalLoan(100000);
        loans.setAmountPaid(0);
        loans.setOutstandingAmount(loans.getTotalLoan() - loans.getAmountPaid());
        return loans;
    }


    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        Optional<Loans> optionLoan = loansRepository.findByMobileNumber(mobileNumber);

        if (optionLoan.isPresent()) {
            Loans loans = optionLoan.get();
            return LoansMapper.LoanstoLoansDto(loans);

        } else {
            throw new LoanNotFoundException(mobileNumber);
        }
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {

        boolean updateLoan = false;

        if(loansDto != null) {

            Loans loan = loansRepository.findByMobileNumber(loansDto.getMobileNumber()).orElseThrow(
                    () -> new LoanNotFoundException(loansDto.getMobileNumber())
            );
            Loans updatedLoan = LoansMapper.mapToLoans(loansDto, loan);
            loansRepository.save(updatedLoan);
            updateLoan = true;

        }

        return updateLoan;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        Loans loans = loansRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new LoanNotFoundException(mobileNumber)
        );
        loansRepository.delete(loans);

        return true;
    }

}
