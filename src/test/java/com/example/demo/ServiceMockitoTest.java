package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.studentservice.demo.beans.Students;
import com.studentservice.demo.repository.StudentRepository;
import com.studentservice.demo.services.StudentsService;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest(classes = {ServiceMockitoTest.class})
public class ServiceMockitoTest {

	@Mock
	StudentRepository sR;


	@InjectMocks
	StudentsService sS;

	public List<Students> mystudnets;

	@Test
	public void test_getStudents() {
		mystudnets = new ArrayList<>();
		mystudnets.add(new Students(1,"Amar","ECE"));
		mystudnets.add(new Students(1,"Sphoorthi","CSE"));
		mystudnets.add(new Students(1,"Aadhya","LKG"));

		when(sR.findAll()).thenReturn(mystudnets);
		assertEquals(3, sS.getStudents().size());
	}

	@Test
	public void test_getStudentsById() {

		mystudnets = new ArrayList<>();
		mystudnets.add(new Students(1,"Amar","ECE"));
		mystudnets.add(new Students(1,"Sphoorthi","CSE"));
		mystudnets.add(new Students(1,"Aadhya","LKG"));

		int id =1;
		when(sR.findAll()).thenReturn(mystudnets);
		assertEquals(id, sS.getStudentsById(id).getId());

	}

	@Test
	public void test_getStudentsByName() {
		mystudnets = new ArrayList<>();
		mystudnets.add(new Students(1,"Amar","ECE"));
		mystudnets.add(new Students(1,"Sphoorthi","CSE"));
		mystudnets.add(new Students(1,"Aadhya","LKG"));

		String studentName="Amar";
		when(sR.findAll()).thenReturn(mystudnets);
		assertEquals(studentName, sS.getStudentsByName(studentName).getName());
	}

	@Test
	public void test_addStudent() {
		Students student = new Students(3,"Padma","House");
		when(sR.save(student)).thenReturn(student);
		assertEquals(student, sS.addStudent(student));
	}
	
	@Test
	public void test_updateStudent() {
		Students student = new Students(3,"US","Washington");

		when(sR.save(student)).thenReturn(student);

		assertEquals(student, sS.updateStudent(student));
	}
	
//	@Test
//	public void test_deleteCountry() {
//
//		Students country = new Students(3,"US","Washington");
//	
//		sR.deleteStudent(country);
//		verify(sR,times(1)).delete(country);}


}

