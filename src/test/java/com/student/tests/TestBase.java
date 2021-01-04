package com.student.tests;

import org.junit.jupiter.api.BeforeAll;
import io.restassured.RestAssured;

public class TestBase {

	@BeforeAll
	public static void init() {
		RestAssured.baseURI=RestAssured.DEFAULT_URI; // "http://localhost";
		RestAssured.port=RestAssured.DEFAULT_PORT; //8080;
		RestAssured.basePath="/student";


	}
}
