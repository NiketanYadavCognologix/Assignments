package com.cognologix.bankingApplication.controllers;

import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.services.BankOperationsSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerServiceController {

    @Autowired
    BankOperationsSevice bankOperationsSevice;

    @PostMapping("/save")
    public ResponseEntity<?> createNewAccount(@RequestBody Account account){
        bankOperationsSevice.saveObject(account);
        return new ResponseEntity<>("Save successfully..", HttpStatus.OK);
    }
}
