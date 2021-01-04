package com.student.tests;

import io.restassured.RestAssured;

public class TestUtils extends TestBase{

	public static void main(String[] args) {

		System.out.println(RestAssured.baseURI);
		System.out.println(RestAssured.port);
		System.out.println(RestAssured.basePath);
	}
}
