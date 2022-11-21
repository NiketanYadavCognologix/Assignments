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
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

//    @NotEmpty(message = "Account holder name cannot blank")
    private String customerName;

    private Map<Long,Double> accountDetails;

    @Override
    public String toString() {
        String message="CustomerName --> {0} | Account Details --> {1}";
        return java.text.MessageFormat.format(message,customerName,accountDetails);
    }
}
