package com.example.demo;

import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.studentservice.demo.beans.Students;
import com.studentservice.demo.controller.StudnetController;
import com.studentservice.demo.services.StudentsService;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes=ControllerMockitoTest.class)
public class ControllerMockitoTest {
	
	@Mock
	StudentsService sS;
	
	@InjectMocks
	StudnetController sC;
	
	List<Students> student;
	
	@Test @Order(1)
	public void test_getStudnets() {
		student = new ArrayList<>();
		student.add(new Students(1,"Amar","ECE"));
		student.add(new Students(2,"Sphoorthi","CSE"));
		
		when(sS.getStudents()).thenReturn(student);
		ResponseEntity<List<Students>> res = sC.getStudnets();
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(2, res.getBody().size());
	}
	
	@Test @Order(2)
	public void test_getStudentById() {
		Students student = new Students(1,"Amar","ECE");
		
		int studentid =1;
		when(sS.getStudentsById(studentid)).thenReturn(student);
		ResponseEntity<Students> res = sC.getStudentById(studentid);
		assertEquals(studentid, res.getBody().getId());
		assertEquals(HttpStatus.OK, res.getStatusCode());
		
	}
	
	@Test @Order(3)
	public void test_getStudentByName() {
		Students student = new Students(1,"Amar","ECE");
		
		String name ="Amar";
		when(sS.getStudentsByName(name)).thenReturn(student);
		ResponseEntity<Students> res = sC.getStudentById(name);
		assertEquals(name, res.getBody().getName());
		assertEquals(HttpStatus.OK, res.getStatusCode());
		
	}
	
	@Test @Order(4)
	public void test_addCountry() {
		Students student = new Students(1,"Amar","ECE");
		
		when(sS.addStudent(student)).thenReturn(student);
		ResponseEntity<Students> res = sC.addStudent(student);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(student, res.getBody());
		
	}
	
	
	@Test @Order(5)
	public void test_updateStudnet() {
		Students student = new Students(1,"Amar","ECE");
		int id = 1;
		when(sS.getStudentsById(id)).thenReturn(student);
		when(sS.updateStudent(student)).thenReturn(student);
		ResponseEntity<Students> res = sC.updateStudent(id, student);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals("Amar", res.getBody().getName());
		
	}
	
	
	@Test @Order(6)
	public void test_deleteStudnet() {
		
		Students student = new Students(1,"Amar","ECE");
		int id =1;
		when(sS.getStudentsById(id)).thenReturn(student);
		ResponseEntity<Students> res = sC.deleteStudent(id);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		
		
	}

}
