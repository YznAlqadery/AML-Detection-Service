package com.yzn.SAML.config;

import com.yzn.SAML.model.Transaction;
import com.yzn.SAML.model.enums.PaymentType;
import com.yzn.SAML.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ImportCSVToDB implements CommandLineRunner {

    private final TransactionRepository transactionRepository;

    public ImportCSVToDB(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        String filePath = "C:\\Users\\yazan\\Desktop\\Backend\\SpringBoot\\SAML\\SAML-D.csv";

        if(transactionRepository.count() > 0){
            return;
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            // Skip the first row, headers
            bufferedReader.readLine();

            String line;
            List<Transaction> batch = new ArrayList<>();
            int batchSize = 5000;

            while ((line = bufferedReader.readLine()) != null){
                String[] columns = line.split(",",-1);

                Transaction transaction = new Transaction();
                transaction.setTime(LocalTime.parse(columns[0]));
                transaction.setDate(LocalDate.parse(columns[1]));
                transaction.setSenderAccount(Integer.parseInt(columns[2]));
                transaction.setReceiverAccount(Integer.parseInt(columns[3]));
                transaction.setAmount(Double.parseDouble(columns[4]));
                transaction.setPaymentCurrency(columns[5]);
                transaction.setReceivedCurrency(columns[6]);
                transaction.setSenderBankLocation(columns[7]);
                transaction.setReceiverBankLocation(columns[8]);
                transaction.setPaymentType(
                        PaymentType.valueOf(columns[9].toUpperCase().replaceAll("[\\s-]", "_"))
                );

            }
        }
    }
}
