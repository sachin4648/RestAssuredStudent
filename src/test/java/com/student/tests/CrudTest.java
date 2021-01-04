package com.student.tests;

import static org.hamcrest.Matchers.equalTo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Test;
import com.github.javafaker.Faker;
import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;
import com.student.tags.Smoke;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;

@Story("This is Crud Testing story")
public class CrudTest extends TestBase{

	RequestFactory requestFactory = new RequestFactory();
	
	@Category(Smoke.class)
	@Story("This is Crud Testing story")
	@DisplayName("This is a test to get all students from database")
	@Feature("This is a test to get all students from database")
	@Test
	public void getAllStudentsTest() {
		requestFactory.getAllStudent("/list").then().statusCode(200);
	}
	

	@Story("This is Crud Testing story")
	@DisplayName("This is a test to get Computer Science students from database")
	@Feature("This is a test to get Computer Science from database")
	@Test
	public void getParamStudentsTest() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("programme", "Computer Science");
		
		requestFactory.getQueryParamStudents(map).then().statusCode(200);
	}
	
	@Story("This is Crud Testing story")
	@DisplayName("This is a test to get students By ID")
	@Feature("This is a test to get  By ID")
	@Test
	public void getStudentByID() {
		requestFactory.getAllStudent("1")
		.then()
			.body("firstName", equalTo("Vernon"));
	}
	
	@Story("This is Crud Testing story")
	@DisplayName("This is a test to create new Student")
	@Feature("This is a test to create new Student")
	@Test
	public void createNewTest() {
		Faker faker = new Faker(new Locale("en-IND"));
		
		String firstName = faker.name().firstName();
		String lastName= faker.name().lastName();
		String email = faker.internet().emailAddress();
		String programme = "Financial Analysis";
		List<String> course= new ArrayList<String>();
		course.add("C");
		course.add("C++");
		
		requestFactory.createNewStudents("", firstName, lastName, email, programme, course)
		.then()
		.spec(SpecificationFactory.getGenericResponseSpec())
		.body("msg", equalTo("Student added"));
	}
}
