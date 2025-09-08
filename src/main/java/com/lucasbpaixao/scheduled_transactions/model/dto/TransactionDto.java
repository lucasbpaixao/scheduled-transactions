package com.lucasbpaixao.scheduled_transactions.model.dto;


import com.lucasbpaixao.scheduled_transactions.model.Transaction;
import java.time.LocalDate;

public class TransactionDto {
    private Long id;
    private String originAccount;
    private String destinationAccount;
    private LocalDate scheduleDate;
    private LocalDate registrationDate;
    private Double transactionValue;
    private Double tax;
    private Double total;

    public TransactionDto(Transaction transaction) {
        this.id = transaction.getId();
        this.originAccount = transaction.getOriginAccount();
        this.destinationAccount = transaction.getDestinationAccount();
        this.scheduleDate = transaction.getScheduleDate();
        this.registrationDate = transaction.getRegistrationDate();
        this.transactionValue = transaction.getTransactionValue();
        this.tax = transaction.getTax();
        this.total = transaction.getTotal();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(String originAccount) {
        this.originAccount = originAccount;
    }

    public String getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Double getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(Double transactionValue) {
        this.transactionValue = transactionValue;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
