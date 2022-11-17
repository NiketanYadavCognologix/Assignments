package com.cognologix.bankingApplication.services;

import com.cognologix.bankingApplication.dto.CustomerDto;
import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.entities.Customer;
import com.cognologix.bankingApplication.globleObjectLists.DataSouceForCustomer;
import com.cognologix.bankingApplication.globleObjectLists.DataSoucrce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerOperationServiceImplementation implements CustomerOperationService {
    @Autowired
    private DataSouceForCustomer dataSouceForCustomer;

    @Autowired
    private DataSoucrce dataSoucrce;

    @Override
    public Customer createNewCustomer(Customer customer) {
        return dataSouceForCustomer.saveCustomer(customer);
    }

    @Override
    public CustomerDto getCustomerById(Integer customerId) {
        Customer customer=dataSouceForCustomer.getCustomerById(customerId);
        Account account=dataSoucrce.getById(customerId);
        CustomerDto customerDto=new CustomerDto();
        customerDto.setCustomerName(customer.getCustomerName());
        customerDto.setAccountNumber(account.getAccountNumber());
        customerDto.setBalance(account.getBalance());
    return customerDto;
    }

    @Override
    public Double getAccountBalance(Integer custumerId) {
        return dataSoucrce.getCurrentBalance(custumerId);
    }
}
