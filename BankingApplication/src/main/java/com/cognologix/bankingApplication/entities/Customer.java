package com.cognologix.bankingApplication.entities;

import java.util.Date;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@NotBlank(message = "Customer id cannot blank")
	private Integer customerId;

	@NotBlank(message = "Account holder name cannot blank")
	private String customerName;

	@NotBlank(message = "Account number cannot blank")
	@Size(min = 10, max = 12, message = "Account number should be 10-12 character")
	private String accountNumber;

	@NotBlank(message = "Date of birth cannot blank")
	private String dateOfBirth;

	@NotBlank(message = "Adhar number cannot blank")
	@Size(min = 12, max = 12, message = "Adhar number should be 12 character")
	private String adharNumber;

	@NotBlank(message = "PAN number cannot blank")
	private String panCardNumber;

	@NotBlank(message = "Email id cannot blank")
	private String emailId;

	@NotBlank(message = "Gender cannot blank")
	private String gender;

//	@OneToOne(cascade= CascadeType.ALL)

	@Override
	public String toString() {
		String messageBody = "customerName={0} | accountNumber={1} | dateOfBirth={2} | " +
				"adharNumber={3} | PanNumber={4} | EmailId={5} | gender={6}";
		return java.text.MessageFormat.format(messageBody, customerName, accountNumber,
				dateOfBirth, adharNumber,panCardNumber,emailId,gender);
	}

}
