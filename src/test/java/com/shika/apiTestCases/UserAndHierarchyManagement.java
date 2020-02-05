package com.shika.apiTestCases;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserAndHierarchyManagement {
	
	String apiUserKey =  "ab51ea57457df274b53b0cf2d02f53b9";
	String baseURL = "http://vowel.uniteframework.io/api";


	@Test
	public void GetListOfAllUsers() {
		RestAssured.baseURI = baseURL;
		RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/x-www-form-urlencoded").header("Authorization","Bearer"+apiUserKey);
		Response response = httpRequest.request(Method.GET, "/users/users");
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
	}
	
	
	/*
	 * @Test public void PostCreateUser() { Response response =
	 * given().header("Content-Type",
	 * "application/x-www-form-urlencoded").header("Authorization","Bearer"+
	 * apiUserKey). contentType(ContentType.JSON) .accept(ContentType.JSON)
	 * .body("{\"username\": \"jamima\",\"name\": \"test020\",\"email\": \"kaustubh+098@vowellms.com\"}"
	 * ) .when() .post(baseURL + "/users/user");
	 * System.out.println("POST Response\n" + response.asString()); // tests
	 * response.then().body("id", Matchers.any(Integer.class));
	 * response.then().body("message", Matchers.is("Congratulations")); }
	 */
	 

}
