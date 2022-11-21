package com.cognologix.bankingApplication.globleObjectLists;


import com.cognologix.bankingApplication.dto.AccountDto;
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

//DAO for banking operations
@Component
public class DataSoucrce {
    //list stores all the information of accounts
    List<Account> accounts = new ArrayList<>();

    @Autowired
    DataSouceForCustomer dataSouceForCustomer;

    //save account for customer, create account and return accountDetails
    public Account saveObject(AccountDto accountDto) {
        Account account = new Account();

        try {
            Customer customer = dataSouceForCustomer.getCustomerById(accountDto.getCustomerId());
//            customers.s
            account.setAccountNumber(generateAccountNumber());
            account.setAdharNumber(customer.getAdharNumber());
            account.setCustomerId(customer.getCustomerId());
            account.setCustomerName(customer.getCustomerName());
            account.setDateOfBirth(customer.getDateOfBirth());
            account.setPanCardNumber(customer.getPanCardNumber());
            account.setEmailId(customer.getEmailId());
            account.setGender(customer.getGender());
            account.setAccountID(accountDto.getAccountID());
            account.setAccountType(accountDto.getAccountType());
            account.setBalance(accountDto.getBalance());

            accounts
            accounts.add(account);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return account;
    }

    //generate account number for new customer
    public Long generateAccountNumber() {
        Random random = new Random();
      String accountNumberInString = String.valueOf(Math.round(random.nextFloat() * Math.pow(10, 12)));
      Long accountNumber=Long.parseLong(accountNumberInString);
        return accountNumber;
    }

    //get all Accounts related to one customer by giving customerID
//    public List<Account> getAcountsByCustomerId(Integer customerId) {
//        List<Account> accountsByCustomerId=accounts.stream()
//                .filter(account -> account.getCustomerId()==customerId)
//                .collect(Collectors.toList());
//        return accountsByCustomerId;
//    }

    //get Accounts for single customer by giving CustomerId
    public List<Account> getAcountsByCustomerId(Integer customerId) {
        List<Account> matchingAccounts = accounts.stream()
                .filter(customer -> customer.getAccountID() == customerId)
                .collect(Collectors.toList());

        if (matchingAccounts.isEmpty())
            throw new AccountNotAvailableException("Please enter correct account information, Account for your entered account id is not found...");
        else
            return matchingAccounts;
    }

    //delete customer by giving customerID
    public List<Account> deleteCustomer(Integer customerId) {
        accounts = accounts.stream()
                .filter(account -> account.getCustomerId() != customerId)
                .collect(Collectors.toList());
        List<Account> deletedAccounts = getAcountsByCustomerId(customerId);
        if (deletedAccounts == null) {
            throw new AccountNotAvailableException("Please enter correct account information, Account for your entered account id is not found...");
        } else {
            return deletedAccounts;
        }
    }

    //get account details by giving account number
    public Account getByAccountNumber(Long accountNumber) {
        List<Account> matchingAccount = accounts.stream()
                .filter(customer -> customer.getAccountNumber() .equals( accountNumber))
                .collect(Collectors.toList());

        if (matchingAccount.isEmpty())
            throw new AccountNotAvailableException("Please enter correct account information, Account for your entered account id is not found...");
        else
            return matchingAccount.get(0);
    }

    //deposit to the account
    public void deposit(Long accountNumber, Double amount) {

        List<Account> accountForDeposite = accounts.stream()
                .filter(account -> account.getAccountNumber() == accountNumber).collect(Collectors.toList());

        if (accountForDeposite.isEmpty())
            throw new AccountNotAvailableException("Please enter correct account information, Account for your entered account id is not found...");

        Account updatedAccount = accountForDeposite.get(0);
        Double currentBalance = updatedAccount.getBalance();
        Double updatedBalance = currentBalance + amount;
        accountForDeposite.get(0).setBalance(updatedBalance);

        List<Account> finalAccount = accounts.stream()
                .filter(account -> account.getAccountNumber() != accountNumber).collect(Collectors.toList());
        finalAccount.add(updatedAccount);

    }

    //withdraw from the account
    public void withdraw(Long accountNumber, Double amount) {
        List<Account> accountForWithdraw = accounts.stream()
                .filter(account -> account.getAccountNumber() == accountNumber).collect(Collectors.toList());

        if (accountForWithdraw.isEmpty())
            throw new AccountNotAvailableException("Please enter correct account information, Account for your entered account id is not found...");

        Account updatedAccount = accountForWithdraw.get(0);
        Double currentBalance = updatedAccount.getBalance();
        if (currentBalance >= amount) {
            Double updatedBalance = currentBalance - amount;
            accountForWithdraw.get(0).setBalance(updatedBalance);
        } else {
            throw new InsufficientBalanceException("oop's your account has insufficient balance.....");
        }

        List<Account> finalAccount = accounts.stream()
                .filter(account -> account.getAccountNumber() != accountNumber).collect(Collectors.toList());
        finalAccount.add(updatedAccount);

    }

    //transfer amount from one account to another account
    public void transferMoney(Long accountNumberWhoSendMoney,Long accountNumberWhoRecieveMoney, Double ammountForTransfer) {
        withdraw(accountNumberWhoSendMoney, ammountForTransfer);
        deposit(accountNumberWhoRecieveMoney, ammountForTransfer);

    }

    //get current balance from given account
    public Double getCurrentBalance(Long accountNumber) {
        Account accountForCheckingBalance = getByAccountNumber(accountNumber);
        return accountForCheckingBalance.getBalance();
    }
}
