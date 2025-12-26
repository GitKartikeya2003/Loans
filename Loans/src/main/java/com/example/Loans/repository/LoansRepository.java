package com.example.Loans.repository;


import com.example.Loans.entity.Loans;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository extends CrudRepository<Loans, Integer> {

    Optional<Loans> findByMobileNumber(String mobileNumber);
}
