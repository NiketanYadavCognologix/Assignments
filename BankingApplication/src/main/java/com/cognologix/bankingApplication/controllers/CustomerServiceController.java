package com.cognologix.bankingApplication.controllers;

import com.cognologix.bankingApplication.dto.CustomerDto;
import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.entities.Customer;
import com.cognologix.bankingApplication.services.BankOperationsSevice;
import com.cognologix.bankingApplication.services.CustomerOperationService;
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
    CustomerOperationService customerOperationService;
    JSONObject resultObject;
    @PostMapping("/save")
    public ResponseEntity<Customer> createNewAccount(@RequestBody Customer customer) {
        Customer createdCustomer = customerOperationService.createNewCustomer(customer);
        return new ResponseEntity<Customer>(createdCustomer, HttpStatus.CREATED);
    }
    @GetMapping("/getById")
    public ResponseEntity<?> getAccountById(@PathParam(value = "id") Integer id) {
        CustomerDto foundCustomer=customerOperationService.getCustomerById(id);
        return new ResponseEntity<CustomerDto>(foundCustomer, HttpStatus.OK);
    }

    @GetMapping("/balance")
    public ResponseEntity<String> checkBAlence(@PathParam(value = "id") Integer id){
        Double currentBalance=customerOperationService.getAccountBalance(id);
        return new ResponseEntity<String>("Current balance is ---> "+currentBalance,HttpStatus.OK);
    }
}