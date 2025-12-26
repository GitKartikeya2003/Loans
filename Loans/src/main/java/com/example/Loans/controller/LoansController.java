package com.example.Loans.controller;


import com.example.Loans.constant.LoanConstants;
import com.example.Loans.dto.LoansDto;
import com.example.Loans.dto.ResponseDto;
import com.example.Loans.service.ILoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoansController {


    @Autowired
    private ILoanService iLoanService;


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(String mobileNumber) {
        iLoanService.createLoan(mobileNumber);
        return ResponseEntity.ok().body(new ResponseDto(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201));

    }

    @GetMapping("/fetch")
    public ResponseEntity<LoansDto> fetchLoan(String mobileNumber) {

        LoansDto loansDto = iLoanService.fetchLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDto);
    }


}
