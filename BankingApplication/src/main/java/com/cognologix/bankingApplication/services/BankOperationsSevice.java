package com.cognologix.bankingApplication.services;

import com.cognologix.bankingApplication.entities.Account;

import java.util.List;

public interface BankOperationsSevice {

    Account saveObject(Account account);

    List<Account> getAllCustomers();

    Account deleteCustomer(Integer accountId);

    Account getByCustomerId(Integer accountId);

    void deposit(Integer accountId, Double ammount);

    void withdraw(Integer accountId, Double ammount);

    void moneyTransfer(Integer customerIdWhoSendMoney,Integer customerIdWhoRecieveMoney,Double ammountForTransfer);

    Double getCurrentBalance(Integer id);
}
