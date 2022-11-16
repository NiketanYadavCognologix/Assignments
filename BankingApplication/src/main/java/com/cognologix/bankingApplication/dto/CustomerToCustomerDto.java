package com.cognologix.bankingApplication.dto;

import com.cognologix.bankingApplication.entities.Customer;

public class CustomerToCustomerDto {

    public CustomerDto customerToDto(Customer customer){
        CustomerDto customerDto=new CustomerDto();
        customerDto.setCustomerId(customer.getCustomerId());
        customerDto.setCustomerName(customer.getCustomerName());
        customerDto.setAccountNumber(customer.getAccountNumber());
        return customerDto;
    }

}
