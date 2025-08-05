package com.yzn.SAML.repository;

import com.yzn.SAML.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

    List<Transaction> findByCreatedAtAfter(LocalDateTime time);
}
