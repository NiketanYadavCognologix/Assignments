package com.cognologix.bankingApplication;

import com.cognologix.bankingApplication.controllers.BankServiceController;
import com.cognologix.bankingApplication.dto.AccountDto;
import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.globleObjectLists.DataSoucrce;
import com.cognologix.bankingApplication.services.BankOperationsSevice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class BankServiceControllerTest {

    @Autowired
    private DataSoucrce dataSoucrce;

    @Autowired
    BankServiceController bankServiceController;

    @Test
    public void testCreateAccout() {
        System.out.println("Testing object get created.....");
        //actual output
        AccountDto accountDto = new AccountDto(1, "Savings", 1000.0, 1);
        ResponseEntity<Account> createdAccount = bankServiceController.createNewAccount(accountDto);

        //expected output
//        ResponseEntity<Account> excpectedOutput = new ResponseEntity<>();
//        excpectedOutput.
//      Integer resultTocheck = bankOperationsSevice.createAccount(customer1);
//      Integer resultGetting= bankOperationsSevice.createAccount();
    }
}
