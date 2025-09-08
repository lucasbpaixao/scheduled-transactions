package model;

import jakarta.persistence.Entity;
import model.form.TransactionForm;

import java.time.LocalDate;

@Entity
public class Transaction {
    private Long id;
    private String originAccount;
    private String destinationAccount;
    private LocalDate scheduleDate;
    private LocalDate registrationDate;
    private Double value;
    private Double tax;
    private Double total;

    public Transaction() {
    }

    public Transaction(TransactionForm transactionForm) {
        this.originAccount = transactionForm.getOriginAccount();
        this.destinationAccount = transactionForm.getDestinationAccount();
        this.scheduleDate = transactionForm.getScheduleDate();
        this.registrationDate = LocalDate.now();
        this.value = transactionForm.getValue();
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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return this.value + this.tax;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
