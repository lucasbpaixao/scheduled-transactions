package com.lucasbpaixao.scheduled_transactions.model;

import jakarta.persistence.*;
import com.lucasbpaixao.scheduled_transactions.model.form.TransactionForm;

import java.time.LocalDate;

@Entity
@Table(name = "scheduled_transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String originAccount;
    private String destinationAccount;
    private LocalDate scheduleDate;
    private LocalDate registrationDate;
    private Double transactionValue;
    private Double tax;
    private Double total;

    public Transaction() {
    }

    public Transaction(TransactionForm transactionForm) {
        this.originAccount = transactionForm.getOriginAccount();
        this.destinationAccount = transactionForm.getDestinationAccount();
        this.scheduleDate = transactionForm.getScheduleDate();
        this.registrationDate = LocalDate.now();
        this.transactionValue = transactionForm.getTransactionValue();
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
        return this.transactionValue + this.tax;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
