package com.cognologix.bankingApplication.services;

import com.cognologix.bankingApplication.dto.AccountDto;
import com.cognologix.bankingApplication.entities.Account;

import java.util.List;

public interface BankOperationsSevice {

    Account saveObject(AccountDto accountDto);

    List<Account> getAllAccountsForCustomers(Integer customerId);

    List<Account> deleteCustomer(Integer customerId);

    Account getAccountByAccountNumber(Long accountId);

    void deposit(Long accountNumber, Double ammount);

    void withdraw(Long accountNumber, Double ammount);

    void moneyTransfer(Long accountNumberWhoSendMoney,Long accountNumberWhoRecieveMoney,Double ammountForTransfer);

    Double getCurrentBalance(Long accountNumber);
}
