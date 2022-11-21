package com.cognologix.bankingApplication.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
@XmlRootElement
public class Account extends Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountID;

//    @NotEmpty(message = "Type of account cannot null")
    private String accountType;

//    @NotBlank(message = "Account number cannot blank")
    @Size(min = 10, max = 12, message = "Account number should be 10-12 character")
    private Long accountNumber;

//    @NotNull(message = "Balence cannot null")
    private Double balance;

//    @NotBlank(message = "Customer cannot blank")
    private Integer customerId;

}
