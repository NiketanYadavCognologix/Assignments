package com.cognologix.bankingApplication.globleObjectLists;

import com.cognologix.bankingApplication.entities.Customer;
import com.cognologix.bankingApplication.exceptions.CustomerNotFoundException;
import com.cognologix.bankingApplication.exceptions.DuplicateCustomerIDException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//this is DAO for global object for customer
@Component
public class DataSouceForCustomer {

    //this list save all the customers details
    List<Customer> customers = new ArrayList<>();

    //method save and return customer
    public Customer saveCustomer(Customer customer) {
        Integer idOfCustomer = customer.getCustomerId();
      List<Customer> matchingCustomers =  customers.stream()
              .filter(avialableCustomer -> avialableCustomer.getCustomerId()==customer.getCustomerId())
              .collect(Collectors.toList());
        if(matchingCustomers.size()==0) {
            customers.add(customer);
        }else{
            throw new DuplicateCustomerIDException("Given Id customer is already exist...");
        }
        return customer;
    }

    //get customer by customer id and returns to UI
    public Customer getCustomerById(Integer customerId) {
        List<Customer> matchingCustumers = customers.stream()
                .filter(customer -> customer.getCustomerId() == customerId)
                .collect(Collectors.toList());
        if (matchingCustumers.isEmpty()) {
            throw new CustomerNotFoundException("Given id customer is not available...");
        }
        return matchingCustumers.get(0);
    }

    //return all customers having into list
    public List<Customer> getAllCustomers() {
        return customers;
    }
}
