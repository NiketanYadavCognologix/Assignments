package com.cognologix.bankingApplication.controllers;

import java.util.List;
import java.util.Map;

import com.cognologix.bankingApplication.entities.Account;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cognologix.bankingApplication.entities.Customer;
import com.cognologix.bankingApplication.services.BankOperationsSevice;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/banking")
public class BankServiceController {

    @Autowired
    BankOperationsSevice bankOperationsSevice;
    JSONObject resultSet;

    @PostMapping("/save")
    public ResponseEntity<Account> createNewAccount(@Valid @RequestBody Account account) {
        Account createdAccount = bankOperationsSevice.saveObject(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);

    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCustomerById(@PathParam(value = "id") Integer id) {
      Account deletedAccount=  bankOperationsSevice.deleteCustomer(id);
        resultSet=new JSONObject();
        resultSet.put("Customer deleted successdully....",deletedAccount);
        return new ResponseEntity<>(resultSet, HttpStatus.OK);
    }

    @PutMapping(value = "/deposite")
    public ResponseEntity<?> depositeAmmount(@PathParam(value = "ammount") Double ammountToDeposite, @PathParam(value = "id") Integer id) {
        bankOperationsSevice.deposit(id, ammountToDeposite);
        return new ResponseEntity<String>("Ammount deposite sucessfully...", HttpStatus.OK);
    }

    @PutMapping(value = "/withdrawsave")
    public ResponseEntity<?> withdrawalAmmount(@PathParam(value = "ammount") Double ammountToWithdraw, @PathParam(value = "id") Integer id) {
        bankOperationsSevice.withdraw(id, ammountToWithdraw);
        return new ResponseEntity<String>("Ammount withdraw sucessfully...", HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllAccounts() {

        return new ResponseEntity<List<Account>>(bankOperationsSevice.getAllCustomers(), HttpStatus.OK);
    }


    @PutMapping("/transfer")
    public ResponseEntity<?> moneyTransfer(@PathParam(value = "senderId") Integer senderId, @PathParam(value = "recieverId") Integer recieverId, @PathParam(value = "ammount") Double ammount) {
        bankOperationsSevice.moneyTransfer(senderId, recieverId, ammount);
        return new ResponseEntity<String >("Ammount successfully transfer...", HttpStatus.OK);
    }



//	public Integer deposite(Double ammountForDeposite, Integer customerId);
//
//	public Integer withdrawal(Double ammountForWithdraw, Integer customerId);
//
//	public Double balenceInquiry(Integer customerId);
//
//	public Customer updateInformation(Customer customerForUpdate);
//
//	public Customer showCustomerDetails(Integer accountId);
}
