package com.cognologix.bankingApplication.services;

import com.cognologix.bankingApplication.dto.CustomerDto;
import com.cognologix.bankingApplication.entities.Customer;

public interface CustomerOperationService {
    Customer createNewCustomer(Customer customer);

    CustomerDto getCustomerById(Integer customerId);

    Double getAccountBalance(Integer custumerId);
}
