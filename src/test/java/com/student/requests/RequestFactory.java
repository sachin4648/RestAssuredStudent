package com.student.requests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.student.pojo.StudentPOJO;
import com.student.tests.TestBase;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class RequestFactory extends TestBase{
	RestClient restClient = new RestClient();
	
	@Step("Getting all the student information from the database")
	public Response getAllStudent(String res) {
		Response response = restClient.doGetRequest(res);
		return response;
	}
	
	@Step("Getting student information based on params")
	public Response getQueryParamStudents(Map<String, String> map) {
		Response response = restClient.doGetRequestWithQueryParam("/list", map);
		return response;
	}
	
	@Step("Create new student")
	public Response createNewStudents(String res, String firstName, String lastName, String email, 
							String programme, List<String> course) {
		StudentPOJO body = new StudentPOJO();
		body.setFirstName(firstName);
		body.setLastName(lastName);
		body.setEmail(email);
		body.setProgramme(programme);
		body.setCourses(course);
		
		Response response = restClient.doPostRequest(res, body);
		return response;
	}
	
}
