package com.studentservice.demo.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentservice.demo.beans.Students;
import com.studentservice.demo.services.StudentsService;

@RestController
public class StudnetController {


	@Autowired
	StudentsService sS;

	@GetMapping("/getstudents")
	public ResponseEntity<List<Students>> getStudnets() {
		try {
			List<Students> students = sS.getStudents();
			return new ResponseEntity<List<Students>>(students,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getstudents/{id}")
	public ResponseEntity<Students> getStudentById(@PathVariable(value="id") int id ){
		try
		{
			Students student = sS.getStudentsById(id);
			return new ResponseEntity<Students>(student,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}


	}

	@GetMapping("/getstudents/studentname")
	public ResponseEntity<Students> getStudentById(@RequestParam(value="name") String name){
		try {
			Students student = sS.getStudentsByName(name);
			return new ResponseEntity<Students>(student,HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@PostMapping("/addstudent")
	public ResponseEntity<Students> addStudent(@RequestBody Students student) {
		try {
			Students student1 = sS.addStudent(student);
			return new ResponseEntity<Students>(student1,HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	@PutMapping("/updatestudent/{id}")
	public ResponseEntity<Students> updateStudent(@PathVariable(value="id")int id, @RequestBody Students student) {
		try {

			Students existing = sS.getStudentsById(id);
			existing.setName(student.getName());
			existing.setDept(student.getDept());
			Students updatedStudent = sS.updateStudent(existing);

			return new ResponseEntity<Students>(updatedStudent,HttpStatus.OK);
		}
		catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}


	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<Students> deleteStudent(@PathVariable(value="id")int id) {
		Students student =null;		
				try {
					student=sS.getStudentsById(id);
					sS.deleteStudent(student);
				}
				catch(Exception e) {
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}
				return new ResponseEntity<Students>(student,HttpStatus.OK);
	}

}
