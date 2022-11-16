package com.cognologix.bankingApplication.services;

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
    public void saveObject(Account account) {
        dataSoucrce.saveObject(account);
    }

    @Override
    public List<Account> getAllCustomers() {
        return dataSoucrce.getCustomers();
    }

    @Override
    public void deleteCustomer(Integer accountId) {
        dataSoucrce.deleteCustomer(accountId);
    }

    @Override
    public List<Account> getByCustomerId(Integer accountId) {
        return dataSoucrce.getById(accountId);
    }

    @Override
    public void deposit(Integer accountId, Double ammount) {
        dataSoucrce.deposite(accountId, ammount);
    }

    @Override
    public void withdraw(Integer accountId, Double ammount) {
        dataSoucrce.withdraw(accountId, ammount);
    }

    @Override
    public void moneyTransfer(Integer customerIdWhoSendMoney, Integer customerIdWhoRecieveMoney, Double ammountForTransfer) {
        dataSoucrce.transferMoney(customerIdWhoSendMoney, customerIdWhoRecieveMoney, ammountForTransfer);
    }
}
