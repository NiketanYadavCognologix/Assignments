package com.cognologix.bankingApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
@XmlRootElement
public class Account {
    @Id
    @NotNull(message = "Account Id cannot null")
    private Integer accountID;

    @NotNull(message = "Type of account cannot null")
    private String accountType;

    @NotEmpty
    private Double balance;

    @NotNull(message = "Type of account cannot null")
    private Customer customer;


}
