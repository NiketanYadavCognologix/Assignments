package com.cognologix.bankingApplication;

import com.cognologix.bankingApplication.dto.AccountDto;
import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.entities.Customer;
import com.cognologix.bankingApplication.globleObjectLists.DataSoucrce;
import com.cognologix.bankingApplication.services.BankOperationsSevice;
import com.cognologix.bankingApplication.services.CustomerOperationService;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class BankOperationServiceTest {

    @Autowired
    private BankOperationsSevice bankOperationsSevice;

    @Autowired
    private CustomerOperationService customerOperationService;

    @Getter
            private DataSoucrce dataSoucrce;

    Customer customer=new Customer(1,"Niketan","20/03/2009",
            "123456789012","123456789","niketanyadav@gmail.com","Male");

    Account account=new Account(1,"savings",1000L ,1000.0,customer );

    Account accountInStance=new Account(2,"saavings",1001L,1000.00,customer);
    AccountDto accountDto=new AccountDto(account.getAccountID(),
            account.getAccountType(), account.getBalance(), account.getCustomer().getCustomerId());

    AccountDto accountDto2=new AccountDto(accountInStance.getAccountID(),
            accountInStance.getAccountType(), accountInStance.getBalance(), accountInStance.getCustomer().getCustomerId());
    @Test
    public void testCreateAccount(){
      Customer customer1 =  customerOperationService.createNewCustomer(customer);
       Account account1 = bankOperationsSevice.saveObject(accountDto);
       assertEquals(account,account1,"Successful");
    }

    @Test
    public void testDeposit(){
        Customer customer1 =  customerOperationService.createNewCustomer(customer);
        Account account1 = bankOperationsSevice.saveObject(accountDto);
        bankOperationsSevice.deposit(1000L,500.00);
        Double currentBalance= account.getBalance();
        assertEquals(currentBalance+500,account1.getBalance(),"Deposit successfully");

    }

    @Test
    public void testWithdraw(){
        Customer customer1 =  customerOperationService.createNewCustomer(customer);
        Account account1 = bankOperationsSevice.saveObject(accountDto);
        bankOperationsSevice.withdraw(1000L,500.00);
        Double currentBalance= account.getBalance();
        assertEquals(currentBalance-500,account1.getBalance(),"Withdraw successfully");
    }

    @Test
    public void testTransferAmount(){
        Customer customer1 =  customerOperationService.createNewCustomer(customer);
        Account account1 = bankOperationsSevice.saveObject(accountDto);
        Account account2 = bankOperationsSevice.saveObject(accountDto2);
        bankOperationsSevice.moneyTransfer(1000L,1001L,500.00);
        Double currentBalanceForAccount1= account.getBalance();
        Double currentBalanceForAccount2= accountInStance.getBalance();

        assertEquals(currentBalanceForAccount2+500,account2.getBalance(),"transfer successfully");
        assertEquals(currentBalanceForAccount1-500,account1.getBalance(),"transfer successfully");


    }
}
