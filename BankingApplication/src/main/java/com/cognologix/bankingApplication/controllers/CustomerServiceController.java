package com.cognologix.bankingApplication.controllers;

import com.cognologix.bankingApplication.entities.Customer;
import com.cognologix.bankingApplication.services.CustomerOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerServiceController {

    //customer related operations
    @Autowired
    CustomerOperationService customerOperationService;

    //create and return created customer by giving parameter to customer
    @PostMapping("/save")
    public ResponseEntity<Customer> createNewAccount(@RequestBody Customer customer) {
        Customer createdCustomer = customerOperationService.createNewCustomer(customer);
        return new ResponseEntity<Customer>(createdCustomer, HttpStatus.CREATED);
    }

    //checking balance by giving account number
    @GetMapping("/balance")
    public ResponseEntity<String> checkBalence(@PathParam(value = "accountNumber") Long accountNumber){
        Double currentBalance=customerOperationService.getAccountBalance(accountNumber);
        return new ResponseEntity<String>("Current balance is ---> "+currentBalance,HttpStatus.OK);
    }

    //returning all customers which is saved in database
    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<List<Customer>>(customerOperationService.getAllCustomers(),HttpStatus.OK);
    }
}