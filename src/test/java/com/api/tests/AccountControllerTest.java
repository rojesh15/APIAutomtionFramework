package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AccountControllerService;
import com.api.base.AuthService;
import com.api.models.requests.AccountControllerRequest;
import com.api.models.requests.LoginRequest;
import com.api.models.response.AccountControllerResponse;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class AccountControllerTest {
	
	@Test(description = "verify post Account controller works fine")
	public void accountControllerTest() {
		
		AuthService auth=new AuthService();
		Response response= auth.login(new LoginRequest("uday1234", "uday1234"));
		LoginResponse logResponse=response.as(LoginResponse.class);
		String bearToken=logResponse.getToken();
		
		//post accountController
		AccountControllerRequest accRequest=new AccountControllerRequest("SAVINGS", "xyz");
		
		AccountControllerService accService=new AccountControllerService();
		response=accService.postaccountController(bearToken,accRequest);
		AccountControllerResponse accResponse=response.as(AccountControllerResponse.class);
		System.out.println(accResponse.getAccountNumber());
		
		//get account account Controller
		response=accService.getAccountNumber(bearToken, accResponse.getAccountNumber());
		System.out.println(response.asPrettyString());
		System.out.println("----------");
		
		//get account user
		response=accService.getUser(bearToken);
		System.out.println(response.asPrettyString());
	}
	
}
