package com.student.specs;

import com.student.tests.TestBase;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.*;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecificationFactory extends TestBase{
	
	public static ResponseSpecification getGenericResponseSpec() {
		ResponseSpecBuilder responseSpec;
		ResponseSpecification responseSpecification;
		
		responseSpec = new ResponseSpecBuilder();
		responseSpec.expectHeader("Content-Type","application/json;charset=UTF-8");
													
		responseSpec.expectHeader("Transfer-Encoding", "chunked");
		responseSpec.expectResponseTime(lessThan(7L), TimeUnit.SECONDS);
		
		responseSpecification = responseSpec.build();
		
		return responseSpecification;
		
	} 
	
	public static RequestSpecification getGenericRequest() {
		RequestSpecBuilder requestSpec;
		RequestSpecification requestSpecification;
		
		requestSpec = new RequestSpecBuilder();
		requestSpec.addFilter(new AllureRestAssured());
		
		requestSpecification = requestSpec.build();
		
		return requestSpecification;
		
	} 
}
