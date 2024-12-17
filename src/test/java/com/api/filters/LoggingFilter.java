package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter{

	/*
	 * This class is used to get the request and response and feed it to the logs.
	 * Filter means interception/interruption like before hitting end point it will filter the details.
	 * Similarly after getting the response it will filter the details you want .
	 */
	private static final Logger logger=LogManager.getLogger(LoggingFilter.class);
	
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		//This contains all the contents for request
		logRequest(requestSpec);
		Response response=ctx.next(requestSpec, responseSpec); //Request is going to be executed
		logResponse(response);
		return response; //test for assertion
	}
	
	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE_URI:"+requestSpec.getBaseUri());
		logger.info("Request Header:"+requestSpec.getHeaders());
		logger.info("Request Body:"+requestSpec.getBody());
	}
	
	public void logResponse(Response response) {
		logger.info("staus_code:"+response.getStatusCode());
		logger.info("Response_Header:"+response.getHeaders());
		logger.info("Response_body:"+response.getBody().asPrettyString());	
	}

}
