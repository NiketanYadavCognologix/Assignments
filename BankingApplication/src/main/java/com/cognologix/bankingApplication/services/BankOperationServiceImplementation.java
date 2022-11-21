package com.cognologix.bankingApplication.services;

import com.cognologix.bankingApplication.dto.AccountDto;
import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.globleObjectLists.DataSoucrce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankOperationServiceImplementation implements BankOperationsSevice {

    @Autowired
    DataSoucrce dataSoucrce;

    @Override
    public Account saveObject(AccountDto accountDto) {
        Account account = dataSoucrce.saveObject(accountDto);
        return account;
    }

    @Override
    public List<Account> getAllAccountsForCustomers(Integer customerId) {
        return dataSoucrce.getAcountsByCustomerId(customerId);
    }

    @Override
    public List<Account> deleteCustomer(Integer customerId) {
        return dataSoucrce.deleteCustomer(customerId);
    }

    @Override
    public Account getAccountByAccountNumber(Long accountNumber) {
        return dataSoucrce.getByAccountNumber(accountNumber);
    }

    @Override
    public void deposit(Long accountNumber, Double amount) {
        dataSoucrce.deposit(accountNumber, amount);
    }

    @Override
    public void withdraw(Long accountNumber, Double amount) {
        dataSoucrce.withdraw(accountNumber, amount);
    }

    @Override
    public void moneyTransfer(Long accountNumberWhoSendMoney, Long accountNumberWhoReceiveMoney, Double amountForTransfer) {
        dataSoucrce.transferMoney(accountNumberWhoSendMoney, accountNumberWhoReceiveMoney, amountForTransfer);
    }

    @Override
    public Double getCurrentBalance(Long accountNumber) {
        return dataSoucrce.getCurrentBalance(accountNumber);
    }
}
