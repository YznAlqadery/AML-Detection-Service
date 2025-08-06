package com.yzn.SAML.scheduler;


import com.yzn.SAML.kafka.TransactionProducer;
import com.yzn.SAML.model.Transaction;
import com.yzn.SAML.repository.TransactionRepository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;


@Component
public class TransactionScheduler {

    private final TransactionRepository transactionRepository;
    private final TransactionProducer transactionProducer;

    // Constructor Injection
    public TransactionScheduler(TransactionRepository transactionRepository, TransactionProducer transactionProducer) {
        this.transactionRepository = transactionRepository;
        this.transactionProducer = transactionProducer;
    }



    @Scheduled(cron = "0 */1 * * * *")
    public void publishTransactionsToKafka() {

        List<Transaction> transactions = transactionRepository.findByCreatedAtAfter(LocalDateTime.now().minusMinutes(2));
            transactions.forEach(transactionProducer::publishTransaction);
    }

}