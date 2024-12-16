package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileRequestTest {

	@Test(description = "update profile details working properly")
	public void updateProfileInfo() {
		
		AuthService auth=new AuthService();
		Response response= auth.login(new LoginRequest("uday1234", "uday1234"));
		LoginResponse logResponse=response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println("------------");
		
		UserProfileManagementService userProfile=new UserProfileManagementService();
		System.out.println(logResponse.getToken());
		response=userProfile.getUserProfile(logResponse.getToken());
		System.out.println(response.asPrettyString());	
		UserProfileResponse userResponse=response.as(UserProfileResponse.class);
		Assert.assertEquals(userResponse.getFirstName(), "Raj");
		System.out.println("-----------");
		
		ProfileRequest profileRequest=new ProfileRequest.Builder()
												.firstName("Hari")
												.lastName("Biswas")
												.email("abc@gmail.com")
												.mobileNumber("7777777717")
												.build();
		
		response=userProfile.updateUserProfile(logResponse.getToken(),profileRequest);
		System.out.println(response.asPrettyString());
		
	}
}
