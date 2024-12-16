package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {
	
	@Test(description = "Getting profile details working properly")
	public void getProfileInfo() {
		/*
		 * Since we can not get the bearer token directly, hence we are calling auth service
		 * Then we can use it in UserProfileManagementService class
		 * 
		 */
		AuthService auth=new AuthService();
		Response response= auth.login(new LoginRequest("uday1234", "uday1234"));
		LoginResponse logResponse=response.as(LoginResponse.class);
		String bearToken=logResponse.getToken();
		System.out.println(bearToken);
		
		UserProfileManagementService userProfile=new UserProfileManagementService();
		response=userProfile.getUserProfile(logResponse.getToken());
		System.out.println(response.asPrettyString());
		System.out.println("-------------------");
		
		UserProfileResponse userResponse=response.as(UserProfileResponse.class);
		System.out.println(userResponse.getFirstName());
		
		
	}

}
