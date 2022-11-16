package com.cognologix.bankingApplication.services;

import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface BankOperationsSevice {

    void saveObject(Account account);

    List<Account> getAllCustomers();

    void deleteCustomer(Integer accountId);

    List<Account> getByCustomerId(Integer accountId);

    void deposit(Integer accountId, Double ammount);

    void withdraw(Integer accountId, Double ammount);

    void moneyTransfer(Integer customerIdWhoSendMoney,Integer customerIdWhoRecieveMoney,Double ammountForTransfer);
}
