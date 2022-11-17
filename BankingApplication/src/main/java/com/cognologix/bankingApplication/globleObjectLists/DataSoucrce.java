package com.cognologix.bankingApplication.globleObjectLists;


import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.entities.Customer;
import com.cognologix.bankingApplication.exceptions.AccountNotAvailableException;
import com.cognologix.bankingApplication.exceptions.InsufficientBalanceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
public class DataSoucrce {
    List<Account> accounts=new ArrayList<>();

    @Autowired
        DataSouceForCustomer dataSouceForCustomer;
    //save customer
    public void saveObject(Account account){
        try {
            account.setAccountNumber(generateAccountNumber());
       Customer customer= dataSouceForCustomer.getCustomerById(account.getCustomerId());
       account.setAdharNumber(customer.getAdharNumber());
       account.setCustomerId(customer.getCustomerId());
       account.setCustomerName(customer.getCustomerName());
       account.setDateOfBirth(customer.getDateOfBirth());
       account.setPanCardNumber(customer.getPanCardNumber());
       account.setEmailId(customer.getEmailId());
       account.setGender(customer.getGender());

            accounts.add(account);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public String generateAccountNumber() {
        Random random = new Random();
        return String.valueOf(Math.round(random.nextFloat() * Math.pow(10,12)));
    }

    //get all customers
    public List<Account> getCustomers() {
        return accounts;
    }

    //delete customer
    public Account deleteCustomer(Integer accountId){
       accounts= accounts.stream()
               .filter(account -> account.getAccountID()!=accountId)
               .collect(Collectors.toList());
     Account account=getById(accountId);
       if(account==null){
           throw new AccountNotAvailableException("Please enter correct account information, Account for your entered account id is not found...");
       }else {
           return account;
       }
    }

    //get customer by id
    public Account getById(Integer accountId){
       List<Account> matchingAccount= accounts.stream()
               .filter(customer -> customer.getAccountID()==accountId)
               .collect(Collectors.toList());

       if(matchingAccount.isEmpty())
           throw new AccountNotAvailableException("Please enter correct account information, Account for your entered account id is not found...");
        else
            return matchingAccount.get(0);
    }

    //deposite
    public void deposite(Integer accountId, Double ammount){

        List<Account> accountForDeposite=accounts.stream()
                .filter(account -> account.getAccountID()==accountId).collect(Collectors.toList());

        if(accountForDeposite.isEmpty())
            throw new AccountNotAvailableException("Please enter correct account information, Account for your entered account id is not found...");

        Account updatedAccount=accountForDeposite.get(0);
        Double currentBalance=updatedAccount.getBalance();
        Double updatedBalence=currentBalance+ammount;
        accountForDeposite.get(0).setBalance(updatedBalence);

        List<Account> finalAccount=accounts.stream()
                .filter(account -> account.getAccountID()!=accountId).collect(Collectors.toList());
        finalAccount.add(updatedAccount);

    }

    //withdraw method
    public void withdraw(Integer accountId, Double ammount){
        List<Account> accountForWithdraw=accounts.stream()
                .filter(account -> account.getAccountID()==accountId).collect(Collectors.toList());

        if(accountForWithdraw.isEmpty())
            throw new AccountNotAvailableException("Please enter correct account information, Account for your entered account id is not found...");

        Account updatedAccount=accountForWithdraw.get(0);
        Double currentBalance=updatedAccount.getBalance();
        if(currentBalance>=ammount) {
            Double updatedBalence = currentBalance - ammount;
            accountForWithdraw.get(0).setBalance(updatedBalence);
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

    public Double getCurrentBalance(Integer id) {
        Account accountForCheckingBalance=getById(id);
        return accountForCheckingBalance.getBalance();
    }
}
