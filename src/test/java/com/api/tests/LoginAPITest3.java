package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class LoginAPITest3 {
	
	@Test(description = "Verify your login is working")
	public void loginTest() {
		LoginRequest login=new  LoginRequest("uday1234", "uday1234");
		
		AuthService auth=new AuthService();
		Response response=auth.login(login);
		
		LoginResponse loginResponse= response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getUsername());
		
		Assert.assertTrue(loginResponse.getToken()!=null);
		Assert.assertEquals(loginResponse.getEmail(), "raj@gmail.com");
		Assert.assertEquals(loginResponse.getId(), 3);
	}
}
