package com.cognologix.bankingApplication.controllers;

import java.util.Map;

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

    @PostMapping(value = "/deposite")
    public ResponseEntity<?> depositeAmmount(@PathParam(value = "ammount") Double ammountToDeposite,@PathParam(value = "id") Integer id) {
        Integer result = bankOperationsSevice.deposite(ammountToDeposite, id);
        bankOperationsSevice.deposite(ammountToDeposite, id);
        if (result != 0)
            return new ResponseEntity<String>("Ammount deposite sucessfully...", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Ammount not deposited...", HttpStatus.ACCEPTED);

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
