package com.cognologix.bankingApplication.controllers;

import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.services.BankOperationsSevice;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/customer")
public class CustomerServiceController {

    @Autowired
    BankOperationsSevice bankOperationsSevice;
    JSONObject resultObject;
    @PostMapping("/save")
    public ResponseEntity<?> createNewAccount(@RequestBody Account account) {
        Account createdAcocount = bankOperationsSevice.saveObject(account);
        resultObject = new JSONObject();
        resultObject.put("Save successfully..", createdAcocount);
        return new ResponseEntity<JSONObject>(resultObject, HttpStatus.CREATED);
    }
    @GetMapping("/getById")
    public ResponseEntity<?> getAccountById(@PathParam(value = "id") Integer id) {
        Account foundAccount=bankOperationsSevice.getByCustomerId(id);
        resultObject=new JSONObject().put("Account found",foundAccount);
        return new ResponseEntity<JSONObject>(resultObject, HttpStatus.OK);
    }

    @GetMapping("/balance")
    public ResponseEntity<String> checkBAlence(@PathParam(value = "id") Integer id){
        Double currentBalance=bankOperationsSevice.getCurrentBalance(id);
        return new ResponseEntity<String>("Current balance is ---> "+currentBalance,HttpStatus.OK);
    }
}