package com.lucasbpaixao.scheduled_transactions.service;

import com.lucasbpaixao.scheduled_transactions.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;

@Service
public class TransactionService {
    public Double calculateTax(Transaction transaction){
        long days = ChronoUnit.DAYS.between(transaction.getRegistrationDate(), transaction.getScheduleDate());
        Double value = transaction.getTransactionValue();
        if (days == 0) {
            return 3.0 + (value * 0.025);
        } else if (days >= 1 && days <= 10) {
            // Entre 1 e 10 dias
            return 12.0;
        } else if (days >= 11 && days <= 20) {
            return value * 0.082;
        } else if (days >= 21 && days <= 30) {
            return value * 0.069;
        } else if (days >= 31 && days <= 40) {
            return value * 0.047;
        } else if (days >= 41 && days <= 50) {
            return value * 0.017;
        } else {
            throw new IllegalArgumentException("Transfer date must be within 50 days from today");
        }
    }
}
