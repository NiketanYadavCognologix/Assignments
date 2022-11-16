package com.cognologix.bankingApplication.dto;

import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.entities.Customer;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountDto {

    private Integer accountNumber;
    private String accountType;
    private Double balence;

}
