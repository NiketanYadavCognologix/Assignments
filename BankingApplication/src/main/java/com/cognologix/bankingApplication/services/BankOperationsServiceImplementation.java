package com.cognologix.bankingApplication.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognologix.bankingApplication.dao.CustomerRepository;
import com.cognologix.bankingApplication.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class BankOperationsServiceImplementation implements BankOperationsSevice {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Integer createAccount(Customer customer) {
        if (customer != null) {
            customerRepository.save(customer);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Integer deposite(Double ammountForDeposite, Integer customerId) {
        if (customerId != null) {
            Optional<Customer> customerOpt = customerRepository.findById(customerId);
            Customer customer=customerOpt.get();
            System.out.println("Hiiiiiiiiiiiiiiii0"+ammountForDeposite);

//            Double balanceAfterDeposite = (customer.getAccount().getBalence()) + ammountForDeposite;
//            System.out.println("Hiiiiiiiiiiiiiiii0"+balanceAfterDeposite);
//            customer.getAccount().setBalence(balanceAfterDeposite);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Integer withdrawal(Double ammountForWithdraw, Integer customerId) {
        if (customerId != null) {
            Customer customer = customerRepository.getById(customerId);
            Double balanceAfterWithdrawal = (customer.getAccount().getBalence()) - ammountForWithdraw;
            customer.getAccount().setBalence(balanceAfterWithdrawal);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public Double balenceInquiry(Integer customerId) {
        if (customerId != null) {
            Customer customer = customerRepository.getById(customerId);
            Double availableBalance = (customer.getAccount().getBalence());

            return availableBalance;
        } else {
            return 0.0;
        }
    }

    @Override
    public Customer updateInformation(Customer customerForUpdate) {
        return customerRepository.save(customerForUpdate);
    }

    @Override
    public Customer showCustomerDetails(Integer customerId) {
        Optional<Customer> custOptional= customerRepository.findById(customerId);

        return custOptional.get();
    }

}
