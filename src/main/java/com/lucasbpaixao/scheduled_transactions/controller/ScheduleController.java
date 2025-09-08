package com.lucasbpaixao.scheduled_transactions.controller;

import com.lucasbpaixao.scheduled_transactions.model.Transaction;
import com.lucasbpaixao.scheduled_transactions.model.dto.TransactionDto;
import com.lucasbpaixao.scheduled_transactions.model.form.TransactionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.lucasbpaixao.scheduled_transactions.repository.TransactionRepository;
import com.lucasbpaixao.scheduled_transactions.service.TransactionService;

@RestController
public class ScheduleController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/create-transaction")
    @Transactional
    public ResponseEntity<TransactionDto> createTransaction(@RequestBody final TransactionForm transactionForm){
        Transaction transaction = new Transaction(transactionForm);
        transaction.setTax(transactionService.calculateTax(transaction));
        transaction.setTotal(transaction.getTax() + transaction.getTransactionValue());

        transactionRepository.saveAndFlush(transaction);

        return new ResponseEntity<>(new TransactionDto(transaction), HttpStatus.CREATED);
    }
}
