package com.cognologix.bankingApplication.dto;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

//    @NotEmpty(message = "Account holder name cannot blank")
    private String customerName;

//    @NotBlank(message = "Account number cannot blank")
//    @Size(min = 10, max = 12, message = "Account number should be 10-12 character")
    private String accountNumber;

//    @NotNull(message = "Balence cannot null")
    private Double balance;

    @Override
    public String toString() {
        String message="CustomerName --> {0} | AccountNumber --> {1} | CurrentBalance --> {2}";
        return java.text.MessageFormat.format(message,customerName,accountNumber,balance);
    }
}
