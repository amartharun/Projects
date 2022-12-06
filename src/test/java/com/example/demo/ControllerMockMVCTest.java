package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.studentservice.demo.beans.Students;
import com.studentservice.demo.controller.StudnetController;
import com.studentservice.demo.services.StudentsService;

@ComponentScan(basePackages="com.restservices.demo")
@AutoConfigureMockMvc
@ContextConfiguration
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {ControllerMockMVCTest.class})
public class ControllerMockMVCTest {

	@Autowired
	MockMvc mockMvc;

	@Mock
	StudentsService sS;

	@InjectMocks
	StudnetController sC;

	List<Students> student;

	@BeforeEach
	public void setup() {
		mockMvc=MockMvcBuilders.standaloneSetup(sC).build();

	}
	@Test @Order(1)
	public void test_getStudents() throws Exception {
		student = new ArrayList<>();
		student.add(new Students(1,"Amar","ECE"));
		student.add(new Students(2,"Sphoorthi","CSE"));

		when(sS.getStudents()).thenReturn(student);	

		this.mockMvc.perform(get("/getstudents"))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test @Order(2)
	public void test_getStudentById() throws Exception {
		Students student = new Students(1,"Amar","ECE");
		int id =1;
		when(sS.getStudentsById(id)).thenReturn(student);

		this.mockMvc.perform(get("/getstudents/{id}",id))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath(".id").value(1))
		.andExpect(MockMvcResultMatchers.jsonPath(".name").value("Amar"))
		.andDo(print());
	}

	@Test @Order(3)
	public void test_getStudentByName() throws Exception {
		Students student = new Students(1,"Amar","ECE");
		String name ="Amar";
		when(sS.getStudentsByName(name)).thenReturn(student);

		this.mockMvc.perform(get("/getstudents/studentname").param("name", "Amar"))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test @Order(4)
	public void test_addStudent() throws Exception {
		Students student = new Students(1,"Amar","ECE");
		when(sS.addStudent(student)).thenReturn(student);

		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = mapper.writeValueAsString(student);
		this.mockMvc.perform(post("/addstudent")
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andDo(print());

	}

	@Test @Order(5)
	public void test_updateStudent() throws Exception {
		Students student = new Students(1,"Amarr","ECE");
		int id =1;
		when(sS.getStudentsById(id)).thenReturn(student);
		when(sS.updateStudent(student)).thenReturn(student);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonBody = mapper.writeValueAsString(student);
		
		this.mockMvc.perform(put("/updatestudent/{id}",id)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print());
	}
	
	@Test @Order(6)
	public void test_deleteStudent() throws Exception {
		Students student = new Students(1,"Amarr","ECE");
		int id =1;
		when(sS.getStudentsById(id)).thenReturn(student);
		
		this.mockMvc.perform(delete("/deletestudent/{id}",id))
				.andExpect(status().isOk())
				.andDo(print());
	}
}

