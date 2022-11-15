package com.cognologix.bankingApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognologix.bankingApplication.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
