package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.SignupRequest;

import io.restassured.response.Response;

public class AccountCreationTest {

	@Test(description = "Verify your Account Creation is working")
	public void createAccount() {
		
		SignupRequest signupRequest = new SignupRequest.Builder()
									.userName("Rajib1234")
									.email("rajib1234@yahoo.com")
									.firstName("Rajib")
									.lastName("meher")
									.mobileNumber("8907890783")
									.password("Rajib1234")
									.build();
		
		
		AuthService auth=new AuthService();
		Response response=auth.signUp(signupRequest);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		Assert.assertEquals(response.statusCode(), 200);
	}
}
