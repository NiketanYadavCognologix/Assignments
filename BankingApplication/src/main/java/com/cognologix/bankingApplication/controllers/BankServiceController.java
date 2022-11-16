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

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/banking")
public class BankServiceController {

    @Autowired
    BankOperationsSevice bankOperationsSevice;

    @PostMapping("/save")
    public ResponseEntity<?> saveAccount(@RequestBody Account account){
        bankOperationsSevice.saveObject(account);
        return new ResponseEntity<>("Save successfully..",HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCustomerById(@PathParam(value = "id") Integer id){
        bankOperationsSevice.deleteCustomer(id);
        return new ResponseEntity<>("Customer deleted successdully....",HttpStatus.OK);
    }

    @PutMapping(value = "/deposite")
    public ResponseEntity<?> depositeAmmount(@PathParam(value = "ammount") Double ammountToDeposite,@PathParam(value = "id") Integer id) {
         bankOperationsSevice.deposit( id,ammountToDeposite);
            return new ResponseEntity<String>("Ammount deposite sucessfully...", HttpStatus.OK);
    }

    @PutMapping(value = "/withdrawsave")
    public ResponseEntity<?> withdrawalAmmount(@PathParam(value = "ammount") Double ammountToWithdraw,@PathParam(value = "id") Integer id) {
        bankOperationsSevice.withdraw( id,ammountToWithdraw);
        return new ResponseEntity<String>("Ammount withdraw sucessfully...", HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllAccounts()
    {
        return new ResponseEntity<List<Account>>(bankOperationsSevice.getAllCustomers(),HttpStatus.OK);
    }

    @PutMapping("/transfer")
    public ResponseEntity<?> moneyTransfer(@PathParam(value = "senderId") Integer senderId,@PathParam(value = "recieverId") Integer recieverId,@PathParam(value = "ammount") Double ammount){
        bankOperationsSevice.moneyTransfer(senderId,recieverId,ammount);
        return new ResponseEntity<>("Ammount successfully transfer...",HttpStatus.OK);
    }


//    @PutMapping(value = "/deposite")
//    public ResponseEntity<?> depositeAmmount(@PathParam(value = "id") Integer id, @PathParam(value = "ammount") Double ammountToDeposite) {
//        Integer result = bankOperationsSevice.deposite(ammountToDeposite, id);
//        if (result != 0)
//            return new ResponseEntity<String>("Ammount deposite sucessfully...", HttpStatus.OK);
//        else
//            return new ResponseEntity<String>("Ammount not deposited...", HttpStatus.ACCEPTED);
//
//    }


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
