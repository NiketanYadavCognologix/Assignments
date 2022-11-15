package com.cognologix.bankingApplication;

import com.cognologix.bankingApplication.entities.Customer;
import com.cognologix.bankingApplication.services.BankOperationsSevice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public class CreateAccount {
    @Autowired
    private BankOperationsSevice bankOperationsSevice;

    @Test
    public void testCreateAccout(){
        System.out.println("Testing object get created.....");

        Customer customer1=new Customer();
        customer1.set
        customer1.set
        customer1.set
        customer1.set
        customer1.set
        customer1.set
        customer1.set
        customer1.set

      Integer resultTocheck = bankOperationsSevice.createAccount(customer1);
      Integer resultGetting= bankOperationsSevice.createAccount();
    }
}
