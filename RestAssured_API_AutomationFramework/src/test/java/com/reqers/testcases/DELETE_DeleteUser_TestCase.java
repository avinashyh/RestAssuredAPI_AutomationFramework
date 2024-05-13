package com.reqers.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.reqers.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class DELETE_DeleteUser_TestCase extends BaseTest {

	@BeforeClass
	void deleteUser() {

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification httpRequest = RestAssured.given();

		response = httpRequest.request(Method.GET, "/api/users/2");

		JsonPath jsonpathEvaluator = response.jsonPath();

		String empID = jsonpathEvaluator.get("[0].id");

		response = httpRequest.request(Method.DELETE, "/delete/" + empID);
	}

	@Test
	void checkResponseBody() {
		String responseBody = response.body().toString();
		Reporter.log("Response Body is => " + responseBody);
		System.out.println("Response Body is => " + responseBody);
	}

	@Test
	void checkStatusCode() {
		int statusCode = response.getStatusCode();
		Reporter.log("Status Code is => " + statusCode);
		System.out.println("Status Code is => " + statusCode);
		Assert.assertEquals(statusCode, 404);
	}
	// Assert.assertEquals(responseBody.contains(name), true);
	// Assert.assertEquals(responseBody.contains(job), true);

	@Test
	void checkStatusLine() {
		String statusLine = response.getStatusLine();
		Reporter.log("Status Line is => " + statusLine);
		System.out.println("Status Line is => " + statusLine);
	}

//				@Test
//				void checkSuccessCode() {
//					// Success code validation
//					String successCode = response.body().jsonPath().get("Success Code");
//					Reporter.log("SuccessCode is => " + successCode);
	//
//				}
}