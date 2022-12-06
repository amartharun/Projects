package com.studentservice.demo.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.studentservice.demo.beans.Students;
import com.studentservice.demo.repository.StudentRepository;



@Component
@Service
public class StudentsService {


	@Autowired
	StudentRepository sR;


	public List<Students> getStudents() {
		return sR.findAll();
	}

	public Students getStudentsById(int id) {
		List<Students> students = sR.findAll();
		Students stud =null;
		for(Students i: students) {
			if(i.getId()==id) {
				stud=i;
			}
		}
		return stud;
	}


	public Students getStudentsByName(String name) {
		List<Students> students = sR.findAll();
		Students stud =null;
		for(Students i: students) {
			if(i.getName().equalsIgnoreCase(name))
				stud=i;
		}
		return stud;
	}


	public Students addStudent(Students student) {
		student.setId(getMaxId());
		sR.save(student);
		return student;
	}

	public Students updateStudent(Students student) {

		sR.save(student);
		return student;
	}

	public void deleteStudent(Students student) {
		sR.delete(student);
	}

	public int getMaxId() {

		return sR.findAll().size()+1;
	}

} 
