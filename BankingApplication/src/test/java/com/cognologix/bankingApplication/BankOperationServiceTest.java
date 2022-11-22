package com.cognologix.bankingApplication;

import com.cognologix.bankingApplication.dto.AccountDto;
import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.entities.Customer;
import com.cognologix.bankingApplication.globleObjectLists.DataSoucrce;
import com.cognologix.bankingApplication.services.BankOperationServiceImplementation;
import com.cognologix.bankingApplication.services.BankOperationsSevice;
import com.cognologix.bankingApplication.services.CustomerOperationService;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BankOperationServiceTest {

    @Autowired
    private BankOperationsSevice bankOperationsSevice;

    @Autowired
    private CustomerOperationService customerOperationService;

    @Getter
            private DataSoucrce dataSoucrce;

    Customer customer=new Customer(1,"Niketan","20/03/2009",
            "123456789012","123456789","niketanyadav@gmail.com","Male");

    Account account=new Account(1,"savings",623526632786L ,1000.0,customer );

    AccountDto accountDto=new AccountDto(account.getAccountID(),
            account.getAccountType(), account.getBalance(), account.getCustomerId());
    @Test
    public void testCreateAccount(){
        System.out.println(account);

//       Customer customer1= customerOperationService.createNewCustomer(customer);
        Account requiredOutput=account;
       Account accountGetting = dataSoucrce.saveObject(accountDto);
        Assertions.assertEquals(requiredOutput,accountGetting);
    }

    @Test
    public void testDeposite(){
        customerOperationService.createNewCustomer(customer);
        bankOperationsSevice.saveObject(accountDto);

    }
}
