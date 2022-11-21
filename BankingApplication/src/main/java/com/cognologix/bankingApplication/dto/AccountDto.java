package com.cognologix.bankingApplication.dto;

import com.cognologix.bankingApplication.entities.Account;
import com.cognologix.bankingApplication.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//this account dto is taken by bank and return created account of customer
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountID;

    //    @NotEmpty(message = "Type of account cannot null")
    private String accountType;


    //    @NotNull(message = "Balence cannot null")
    private Double balance;

    //    @NotBlank(message = "Customer cannot blank")
    private Integer customerId;

}
