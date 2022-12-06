package com.example.demo;

import org.json.JSONException;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.studentservice.demo.beans.Students;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes= {ControllerIntegrationTesting.class})
public class ControllerIntegrationTesting {


	@Test @Order(1)
	public void getStudents() throws JSONException {
		String expected="[\n"
				+ "{\n"
				+ "\"id\": 1,\n"
				+ "\"dept\": \"ECE\",\n"
				+ "\"name\": \"Amar\"\n"
				+ "},\n"
				+ "{\n"
				+ "\"id\": 2,\n"
				+ "\"dept\": \"CSE\",\n"
				+ "\"name\": \"Sphoorthi\"\n"
				+ "}\n"
				+ "]";

		TestRestTemplate resttemplate = new TestRestTemplate();
		ResponseEntity<String> res =resttemplate.getForEntity("http://localhost:8080/getstudents", String.class);
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody());

		JSONAssert.assertEquals(expected,res.getBody(), false);
	}

	@Test @Order(2)
	public void addStudents() throws JSONException {
		Students student = new Students(3,"Padma","House");
		String expected="{\n"
				+"\"id\":3,\n"
				+ "	\"name\":\"Padma\",\n"
				+ "	\"dept\":\"House\"\n"
				+ "}";
		TestRestTemplate resttemplate = new TestRestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Students> request = new HttpEntity<Students>(student,headers);

		ResponseEntity<String> res =resttemplate.postForEntity("http://localhost:8080/addstudent",request, String.class);
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody());

		JSONAssert.assertEquals(expected,res.getBody(), false);
	}
	
	@Test @Order(3)
	public void updateStudents() throws JSONException {
		Students student = new Students(3,"Padmaaaa","House");
		String expected="{\n"
				+"\"id\":3,\n"
				+ "	\"name\":\"Padmaaaa\",\n"
				+ "	\"dept\":\"House\"\n"
				+ "}";

		TestRestTemplate resttemplate = new TestRestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Students> request = new HttpEntity<Students>(student,headers);

		ResponseEntity<String> res =resttemplate.exchange("http://localhost:8080/updatestudent/3",HttpMethod.PUT,request, String.class);
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody());

		JSONAssert.assertEquals(expected,res.getBody(), false);
	}
	
	@Test @Order(4)
	public void deleteStudents() throws JSONException {
		Students student = new Students(3,"Padmaaaa","House");
		String expected="{\n"
				+"\"id\":3,\n"
				+ "	\"name\":\"Padmaaaa\",\n"
				+ "	\"dept\":\"House\"\n"
				+ "}";
		TestRestTemplate resttemplate = new TestRestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Students> request = new HttpEntity<Students>(student,headers);

		ResponseEntity<String> res =resttemplate.exchange("http://localhost:8080/deletestudent/3",HttpMethod.DELETE,request, String.class);
		System.out.println(res.getStatusCode());

		JSONAssert.assertEquals(expected,res.getBody(), false);
	}
}
