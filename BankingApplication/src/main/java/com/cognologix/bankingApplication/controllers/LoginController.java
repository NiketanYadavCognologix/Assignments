package com.cognologix.bankingApplication.controllers;

import com.cognologix.bankingApplication.services.BankOperationsSevice;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    BankOperationsSevice bankOperationsSevice;
    public ResponseEntity<?> loginToAccount(@RequestBody Map<String, String> loginCredentials) {
        JSONObject signInResult = new JSONObject();
//		signInResult.put("Sucessfully login..,",bankOperationsSevice.loginByCustomer(loginCredentials));
        return new ResponseEntity<JSONObject>(signInResult, HttpStatus.OK);
    }
}
