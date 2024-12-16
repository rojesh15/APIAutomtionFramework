package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {

	@Test(description = "Verify forgot password functionality is working")
	public void forgotPassord() {
		
		AuthService auth=new AuthService();
		Response response=auth.forgotPassword("rajib1234@yahoo.com");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
}
