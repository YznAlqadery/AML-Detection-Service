package com.yzn.SAML.kafka;


import com.yzn.SAML.model.Transaction;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class TransactionProducer {

    private final KafkaTemplate<String, Transaction> kafkaTemplate;


    // Constructor Injection
    public TransactionProducer(KafkaTemplate<String, Transaction> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishTransaction(Transaction transaction){
//        Message<Transaction> message = MessageBuilder
//                .withPayload(transaction)
//                .build();

        kafkaTemplate.send("transaction-topic",transaction);
    }
}
