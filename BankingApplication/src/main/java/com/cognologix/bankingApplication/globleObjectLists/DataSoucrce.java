package com.cognologix.bankingApplication.globleObjectLists;

import com.cognologix.bankingApplication.entities.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class DataSoucrce {
    List<Customer> customers;

    //save customer
    public void saveObject(Customer customer){
        try {
            customers.add(customer);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //get all customers
    public List<Customer> getCustomers() {
        return customers;
    }

    //delete customer
    public void deleteCustomer(Integer customerId){
       customers= customers.stream()
               .filter(customer -> customer.getCustomerId()!=customerId)
               .collect(Collectors.toList());
    }

    //get customer by id
    public List<?> getById(Integer customerId){
       return customers.stream()
               .filter(customer -> customer.getCustomerId()==customerId)
               .collect(Collectors.toList());
    }

    //deposite
    public void deposite(Integer customerId, Double ammount){
        List<Customer> customerForDeposite=customers.stream()
                .filter(customer1 -> customer1.getCustomerId()==customerId).collect(Collectors.toList());

        Customer customerUpdated=customerForDeposite.get(0);
        Double currentBalance=customerUpdated.getAccount().getBalence();
        Double updatedBalence=currentBalance+ammount;
        customerForDeposite.get(0).getAccount().setBalence(updatedBalence);

        List<Customer> customersFinal=customers.stream()
                .filter(customer1 -> customer1.getCustomerId()!=customerId).collect(Collectors.toList());
        customersFinal.add(customerUpdated);

    }
}
