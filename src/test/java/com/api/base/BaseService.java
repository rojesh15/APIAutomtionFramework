package com.api.base;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
 * Acts as a wrapper for RestAssured
 * Responsible for BaseUri
 * Responsible for creating request
 * Responsible for handling the response
 */
public class BaseService {
	
	private static final String BASE_URL="http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	public BaseService() {
		requestSpecification= given().baseUri(BASE_URL);
	}
	/*
	 * We are using Object class here since it is superclass .
	 */
	protected Response postRequest(Object payload,String endpoint) {
		return requestSpecification
			.contentType(ContentType.JSON)
			.body(payload)
			.post(endpoint);
	}
	
	protected void setAuthToken(String token) {
		 requestSpecification.header("Authorization","Bearer "+token);
	}
	
	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}
	
	protected Response putRequest(Object payload,String endpoint) {
		return requestSpecification
			.contentType(ContentType.JSON)
			.body(payload)
			.put(endpoint);
	}

}
