package com.cognologix.bankingApplication.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;

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
	private Integer customerId;

//	@NotEmpty(message = "Account holder name cannot blank")
	private String customerName;

//	@NotEmpty(message = "Date of birth cannot blank")
	private String dateOfBirth;

//	@NotEmpty(message = "Adhar number cannot blank")
//	@Size(min = 12, max = 12, message = "Adhar number should be 12 character")
	private String adharNumber;

//	@NotEmpty(message = "PAN number cannot blank")
	private String panCardNumber;

//	@Email(message = "Email id cannot blank")
	private String emailId;

//	@NotEmpty(message = "Gender cannot blank")
	private String gender;

//	@OneToOne(cascade= CascadeType.ALL)

	@Override
	public String toString() {
		String messageBody = "customerName={0} | dateOfBirth={1} | " +
				"adharNumber={2} | PanNumber={3} | EmailId={4} | gender={5}";
		return java.text.MessageFormat.format(messageBody, customerName,
				dateOfBirth, adharNumber,panCardNumber,emailId,gender);
	}

}
