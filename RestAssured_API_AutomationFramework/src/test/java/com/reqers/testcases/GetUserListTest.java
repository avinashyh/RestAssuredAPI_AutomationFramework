
package com.reqers.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.reqers.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

public class GetUserListTest extends BaseTest {

	@BeforeClass

	void getAllUsers() {

		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		response = httpRequest.request(Method.GET, "/employees");

	}

	@Test
	void checkResponseBody() {
		String responseBody = response.getBody().toString();
		Reporter.log("Response Body is => " + responseBody, true);
		Assert.assertTrue(responseBody != null);

	}

	@Test
	void checkStatusCode() {
		int statusCode = response.getStatusCode();
		Reporter.log("Status Code is => " + statusCode, true);
		Assert.assertEquals(statusCode, 200);

	}

	@Test
	void checkStatusLine() {
		String statusLine = response.getStatusLine();
		Reporter.log("Status Line is => " + statusLine, true);
		Assert.assertTrue(statusLine != null);

	}

	@Test
	void checkResponseTime() {
		long responseTime = response.getTime();
		Reporter.log("Response Time is => " + responseTime, true);

		if (responseTime < 2000)
			Reporter.log("Response Time is < 2000 ", true);
		Assert.assertTrue(responseTime < 2000);

	}

	@Test
	void checkContentType() {
		String contentType = response.getContentType();
		Reporter.log("Content Type is => " + contentType, true);
		Assert.assertTrue(contentType != null);

	}

	@Test
	void checkServerType() {
		String serverType = response.getHeader("Server");
		Reporter.log("Server Type is => " + serverType, true);
		Assert.assertTrue(serverType != null);

	}
}
