package com.yzn.SAML.model;


import com.yzn.SAML.model.enums.LaunderingType;
import com.yzn.SAML.model.enums.PaymentType;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalTime time;

    private LocalDate date;

    @Column(name="sender_account")
    private Long senderAccount;
    @Column(name = "receiver_account")
    private Long receiverAccount;

    private Double amount;

    @Column(name = "payment_currency")
    private String paymentCurrency;
    @Column(name = "received_currency")
    private String receivedCurrency;

    @Column(name = "sender_bank_location")
    private String senderBankLocation;
    @Column(name = "receiver_bank_location")
    private String receiverBankLocation;

    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(name = "is_laundering")
    private Integer isLaundering;

    @Column(name = "laundering_type", length = 50)
    @Enumerated(EnumType.STRING)
    private LaunderingType launderingType;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Transaction() {
    }

    public Transaction(LocalTime time, LocalDate date, Long senderAccount, Long receiverAccount,
                       Double amount, String paymentCurrency, String receivedCurrency,
                       String senderBankLocation, String receiverBankLocation,
                       PaymentType paymentType, Integer isLaundering, LaunderingType launderingType) {
        this.time = time;
        this.date = date;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.paymentCurrency = paymentCurrency;
        this.receivedCurrency = receivedCurrency;
        this.senderBankLocation = senderBankLocation;
        this.receiverBankLocation = receiverBankLocation;
        this.paymentType = paymentType;
        this.isLaundering = isLaundering;
        this.launderingType = launderingType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Long senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Long getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Long receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    public void setPaymentCurrency(String paymentCurrency) {
        this.paymentCurrency = paymentCurrency;
    }

    public String getReceivedCurrency() {
        return receivedCurrency;
    }

    public void setReceivedCurrency(String receivedCurrency) {
        this.receivedCurrency = receivedCurrency;
    }

    public String getSenderBankLocation() {
        return senderBankLocation;
    }

    public void setSenderBankLocation(String senderBankLocation) {
        this.senderBankLocation = senderBankLocation;
    }

    public String getReceiverBankLocation() {
        return receiverBankLocation;
    }

    public void setReceiverBankLocation(String receiverBankLocation) {
        this.receiverBankLocation = receiverBankLocation;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getIsLaundering() {
        return isLaundering;
    }

    public void setIsLaundering(Integer isLaundering) {
        this.isLaundering = isLaundering;
    }

    public LaunderingType getLaunderingType() {
        return launderingType;
    }

    public void setLaunderingType(LaunderingType launderingType) {
        this.launderingType = launderingType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", time=" + time +
                ", date=" + date +
                ", senderAccount=" + senderAccount +
                ", receiverAccount=" + receiverAccount +
                ", amount=" + amount +
                ", paymentCurrency='" + paymentCurrency + '\'' +
                ", receivedCurrency='" + receivedCurrency + '\'' +
                ", senderBankLocation='" + senderBankLocation + '\'' +
                ", receiverBankLocation='" + receiverBankLocation + '\'' +
                ", paymentType=" + paymentType +
                ", isLaundering=" + isLaundering +
                ", launderingType=" + launderingType +
                '}';
    }
}
