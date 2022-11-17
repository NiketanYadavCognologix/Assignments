package com.cognologix.bankingApplication.globleObjectLists;

import com.cognologix.bankingApplication.entities.Customer;
import com.cognologix.bankingApplication.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataSouceForCustomer {

    List<Customer> customers=new ArrayList<>();

    public Customer saveCustomer(Customer customer){
        customers.add(customer);
        return customer;
    }
    public Customer getCustomerById(Integer customerId){
     List<Customer> matchingCustumers = customers.stream()
             .filter(customer -> customer.getCustomerId()==customerId)
             .collect(Collectors.toList());
     if(matchingCustumers.isEmpty()){
         throw new CustomerNotFoundException("Given id customer is not available...");
     }
     return matchingCustumers.get(0);
    }
}
