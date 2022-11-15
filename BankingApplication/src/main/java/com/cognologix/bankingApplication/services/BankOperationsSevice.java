package com.cognologix.bankingApplication.services;

import com.cognologix.bankingApplication.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface BankOperationsSevice {

    Integer createAccount(Customer customer);

    Integer deposite(Double ammountForDeposite, Integer customerId);

    Integer withdrawal(Double ammountForWithdraw, Integer customerId);

    Double balenceInquiry(Integer customerId);

    Customer updateInformation(Customer customerForUpdate);

    Customer showCustomerDetails(Integer accountId);

}
