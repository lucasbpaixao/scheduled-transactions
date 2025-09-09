package com.lucasbpaixao.scheduled_transactions.controller;

import com.lucasbpaixao.scheduled_transactions.model.Transaction;
import com.lucasbpaixao.scheduled_transactions.model.dto.TransactionDto;
import com.lucasbpaixao.scheduled_transactions.model.form.TransactionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.lucasbpaixao.scheduled_transactions.repository.TransactionRepository;
import com.lucasbpaixao.scheduled_transactions.service.TransactionService;

@RestController
@RequestMapping("api")
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

    @DeleteMapping("/delete-transaction/{id}")
    public ResponseEntity<TransactionDto> deleteTransaction(@PathVariable("id") Long id){
        return transactionRepository.findById(id).map(transaction -> {
            transactionRepository.deleteById(transaction.getId());
            return new ResponseEntity<>(new TransactionDto(transaction), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("update-transaction/{id}")
    @Transactional
    public ResponseEntity<TransactionDto> updateAuthor(@PathVariable("id") Long id, @RequestBody TransactionForm transactionForm) {
        return transactionRepository.findById(id).map(transaction -> {
            transaction.update(transactionForm);
            transaction.setTax(transactionService.calculateTax(transaction));
            transactionRepository.saveAndFlush(transaction);
            return new ResponseEntity<>(new TransactionDto(transaction), HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
