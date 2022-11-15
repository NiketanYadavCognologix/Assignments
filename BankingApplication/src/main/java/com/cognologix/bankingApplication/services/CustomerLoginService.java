package com.cognologix.bankingApplication.services;

import java.util.Map;

public interface CustomerLoginService {

	public Integer login(Map<String, String> loginCredentials);
}
