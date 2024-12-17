package com.api.base;

import com.api.models.requests.AccountControllerRequest;
import com.api.models.requests.LoginRequest;

import io.restassured.response.Response;

public class AccountControllerService extends BaseService{
	
	private static final String BASE_PATH="/api/accounts";
	
	public Response postaccountController(String token,AccountControllerRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH);
	}
	
	public Response getAccountNumber(String token,String accountNumber) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"/"+accountNumber);
	}
	
	public Response getUser(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"/user");
	}

}
