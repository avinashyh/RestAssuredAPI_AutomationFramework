package com.reqers.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.reqers.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class PATCH_UpdateUser_TestCase extends BaseTest {
	@SuppressWarnings("unchecked")
	@BeforeClass
	void updateUsers() throws InterruptedException {

		RestAssured.baseURI = "https://reqres.in";

		RequestSpecification httpRequest = RestAssured.given();

		// Request Payload sending along with POST request
		JSONObject requestParameters = new JSONObject();

		requestParameters.put("name", "morpheus");
		requestParameters.put("job", "leader");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParameters.toJSONString());

		response = httpRequest.request(Method.PATCH, "/api/users/2" + empID);

		Thread.sleep(5000);

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
		Assert.assertEquals(statusCode, 200);
	}
	// Assert.assertEquals(responseBody.contains(name), true);
	// Assert.assertEquals(responseBody.contains(job), true);

	@Test
	void checkStatusLine() {
		String statusLine = response.getStatusLine();
		Reporter.log("Status Line is => " + statusLine);
		System.out.println("Status Line is => " + statusLine);
	}

//					@Test
//					void checkSuccessCode() {
//						// Success code validation
//						String successCode = response.body().jsonPath().get("Success Code");
//						Reporter.log("SuccessCode is => " + successCode);
	//
//					}
}