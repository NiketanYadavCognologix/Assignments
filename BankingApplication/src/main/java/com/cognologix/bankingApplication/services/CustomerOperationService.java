package com.cognologix.bankingApplication.services;

import com.cognologix.bankingApplication.entities.Customer;

public interface CustomerOperationService {
    Customer createNewCustomer(Customer customer);

    Customer showCustomerDetails(Integer customerId);

    Double getAccountBalance(Integer custumerId);
}
