package com.cognologix.bankingApplication.globleObjectLists;

import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.exceptions.AccountNotAvailableException;
import com.cognologix.bankingApplication.exceptions.InsufficientBalanceException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class DataSoucrce {
    List<Account> accounts=new ArrayList<>();

    //save customer
    public void saveObject(Account account){
        try {
            accounts.add(account);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //get all customers
    public List<Account> getCustomers() {
        return accounts;
    }

    //delete customer
    public void deleteCustomer(Integer accountId){
       accounts= accounts.stream()
               .filter(account -> account.getAccountID()!=accountId)
               .collect(Collectors.toList());
    }

    //get customer by id
    public List<Account> getById(Integer accountId){
       List<Account> account= accounts.stream()
               .filter(customer -> customer.getAccountID()==accountId)
               .collect(Collectors.toList());
       if(account.isEmpty())
           throw new AccountNotAvailableException("Please enter correct account information, Account for your entered account id is not found...");
        else return account;
    }

    //deposite
    public void deposite(Integer accountId, Double ammount){

        List<Account> accountForDeposite=accounts.stream()
                .filter(account -> account.getAccountID()==accountId).collect(Collectors.toList());

        if(accountForDeposite.isEmpty())
            throw new AccountNotAvailableException("Please enter correct account information, Account for your entered account id is not found...");

        Account updatedAccount=accountForDeposite.get(0);
        Double currentBalance=updatedAccount.getBalence();
        Double updatedBalence=currentBalance+ammount;
        accountForDeposite.get(0).setBalence(updatedBalence);

        List<Account> finalAccount=accounts.stream()
                .filter(account -> account.getAccountID()!=accountId).collect(Collectors.toList());
        finalAccount.add(updatedAccount);

    }

    public void withdraw(Integer accountId, Double ammount){
        List<Account> accountForWithdraw=accounts.stream()
                .filter(account -> account.getAccountID()==accountId).collect(Collectors.toList());

        if(accountForWithdraw.isEmpty())
            throw new AccountNotAvailableException("Please enter correct account information, Account for your entered account id is not found...");

        Account updatedAccount=accountForWithdraw.get(0);
        Double currentBalance=updatedAccount.getBalence();
        if(currentBalance>=ammount) {
            Double updatedBalence = currentBalance - ammount;
            accountForWithdraw.get(0).setBalence(updatedBalence);
        }else {
            throw new InsufficientBalanceException("oop's your account has insufficient balance.....");
        }

        List<Account> finalAccount=accounts.stream()
                .filter(account -> account.getAccountID()!=accountId).collect(Collectors.toList());
        finalAccount.add(updatedAccount);

    }

    public void transferMoney(Integer customerIdWhoSendMoney, Integer customerIdWhoRecieveMoney, Double ammountForTransfer) {
       withdraw(customerIdWhoSendMoney,ammountForTransfer);
       deposite(customerIdWhoRecieveMoney,ammountForTransfer);

    }
}
