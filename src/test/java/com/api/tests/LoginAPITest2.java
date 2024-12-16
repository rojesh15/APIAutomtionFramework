package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class LoginAPITest2 {
	
	@Test(description = "Verify your login is working")
	public void loginTest() {
	
		Response res=given()
				.baseUri("http://64.227.160.186:8080")
				.header("Content-Type", "application/json")
				.body("{\r\n"
				+ "  \"username\": \"uday1234\",\r\n"
				+ "  \"password\": \"uday1234\"\r\n"
				+ "}")
				.post("/api/auth/login");
		System.out.println(res.asPrettyString());
		Assert.assertEquals(res.getStatusCode(), 200);
	}
}
