package com.cognologix.bankingApplication.controllers;

import com.cognologix.bankingApplication.entities.Customer;
import com.cognologix.bankingApplication.services.BankOperationsSevice;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/signUp")
public class SignUpController {
    @Autowired
    private BankOperationsSevice bankOperationsSevice;

    @PostMapping(value = "/newAccount",
            consumes = { "application/json", "application/xml" },
            produces = {"application/json", "application/xml" })
    public ResponseEntity<?> createAccount(@RequestBody Customer customer) {
        JSONObject signUpResult=new JSONObject();
        bankOperationsSevice.createAccount(customer);
        signUpResult.put("Account created successfully...",customer);
        System.out.println(signUpResult);
        return new ResponseEntity<JSONObject>(signUpResult, HttpStatus.CREATED);
    }
}
