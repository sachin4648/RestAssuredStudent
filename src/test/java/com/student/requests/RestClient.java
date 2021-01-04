package com.student.requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Map;

import com.student.specs.SpecificationFactory;

import io.restassured.response.Response;

public class RestClient {

	/**
	 * 
	 * @param requestPath
	 * @return
	 */
	public Response doGetRequest(String requestPath) {
		return given()
				.when()
				.get(requestPath);
	}	
	
	/**
	 * 
	 * @param requestPath
	 * @param map
	 * @return
	 */
	public Response doGetRequestWithQueryParam(String requestPath, 
													Map<String, String> map) {
		return given()
					.queryParams(map)
				.when()
				.get(requestPath);
	}	
	
	/**
	 * 
	 * @param res
	 * @param body
	 * @return
	 */
	public Response doPostRequest(String res, Object body) {
		return given()
					.contentType(ContentType.JSON)
					.spec(SpecificationFactory.getGenericRequest())
				.when()
					.body(body)
					.post(res);
	}
	
	/**
	 * 
	 * @param res
	 * @param headers
	 * @return
	 */
	public Response doGetRequestWithHeader(String res,
										  Map<String, String> headers) {

		return given()
					.headers(headers)
				.when()
					.get(res);

	}
	
	/**
	 * 
	 * @param res
	 * @param body
	 * @return
	 */
	public Response doPatchRequest(String res, Object body) {
		return given()
					.contentType(ContentType.JSON)
				.when()
					.body(body)
						.patch(res);
	}
	
	/**
	 * 
	 * @param res
	 * @param body
	 * @return
	 */
	public Response doPutRequest(String res, Object body) {
		return given()
					.contentType(ContentType.JSON)
				.when()
					.body(body)
					.put(res);
	}
	
	/**
	 * 
	 * @param res
	 * @return
	 */
	public Response doDeleteRequest(String res) {
		return given()
			   .when()
			       .delete(res);
	}
	
	
}
