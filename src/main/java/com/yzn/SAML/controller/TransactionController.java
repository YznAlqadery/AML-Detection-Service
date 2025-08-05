package com.yzn.SAML.controller;


import com.yzn.SAML.model.Transaction;
import com.yzn.SAML.service.TransactionService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @GetMapping("")
    public ResponseEntity<Page<Transaction>> getTransactions(@RequestParam Integer pageNumber){
        return ResponseEntity.ok(transactionService.getTransactions(pageNumber));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable Integer id){
        return ResponseEntity.ok(transactionService.getTransactionById(id));
    }

    @PostMapping("")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction){
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable Integer id, @RequestBody Transaction transaction){
        return ResponseEntity.ok(transactionService.updateTransaction(id,transaction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Integer id){
        transactionService.deleteTransaction(id);
        return ResponseEntity.noContent().build();
    }

}
