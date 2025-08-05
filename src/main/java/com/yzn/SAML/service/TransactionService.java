package com.yzn.SAML.service;

import com.yzn.SAML.model.Transaction;
import com.yzn.SAML.model.enums.LaunderingType;
import com.yzn.SAML.model.enums.PaymentType;
import com.yzn.SAML.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;


    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Page<Transaction> getTransactions(int pageNumber){
        Pageable pageable = PageRequest.of(pageNumber,20);
        return transactionRepository.findAll(pageable);
    }

    public Transaction getTransactionById(Integer id){
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Transaction with this id found."));
    }

    public Transaction createTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    public Transaction updateTransaction(Integer id, Transaction updatedTransaction){
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No Transaction with this found."));

        transaction.setTime((LocalTime.now()));
        transaction.setDate(LocalDate.now());
        transaction.setSenderAccount(updatedTransaction.getSenderAccount() != null ? updatedTransaction.getSenderAccount(): transaction.getSenderAccount());
        transaction.setReceiverAccount(updatedTransaction.getReceiverAccount() != null ? updatedTransaction.getReceiverAccount(): transaction.getReceiverAccount());
        transaction.setAmount(updatedTransaction.getAmount() != null ? updatedTransaction.getAmount(): transaction.getAmount());
        transaction.setPaymentCurrency(updatedTransaction.getPaymentCurrency() != null ? updatedTransaction.getPaymentCurrency(): transaction.getPaymentCurrency());
        transaction.setReceivedCurrency(updatedTransaction.getReceivedCurrency() != null ? updatedTransaction.getReceivedCurrency(): transaction.getReceivedCurrency());
        transaction.setSenderBankLocation(updatedTransaction.getSenderBankLocation() != null ? updatedTransaction.getSenderBankLocation(): transaction.getSenderBankLocation());
        transaction.setReceiverBankLocation(updatedTransaction.getReceiverBankLocation() != null ? updatedTransaction.getReceiverBankLocation(): transaction.getReceiverBankLocation());
        transaction.setPaymentType(
                updatedTransaction.getPaymentType() != null
                        ? updatedTransaction.getPaymentType()
                        : transaction.getPaymentType()
        );
        transaction.setIsLaundering(
                updatedTransaction.getIsLaundering() != null
                        ? updatedTransaction.getIsLaundering()
                        : transaction.getIsLaundering()
        );

        transaction.setLaunderingType(
                updatedTransaction.getLaunderingType() != null
                        ? updatedTransaction.getLaunderingType()
                        : transaction.getLaunderingType()
        );

        return transaction;
    }

    public void deleteTransaction(Integer id){
        transactionRepository.deleteById(id);
    }

}
