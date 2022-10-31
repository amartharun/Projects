package com.amar.learnspringboot.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amar.learnspringboot.bean.Course;
import com.amar.learnspringboot.repository.CourseRepository;

@RestController
public class CourseController {
	
	
	@Autowired
	private CourseRepository repository;
	
	@GetMapping("/courses")
	public List<Course> getallcourses(){
		repository.count();
		return repository.findAll();
		//return Arrays.asList(new Course(1,"Spring","amar"),new Course(2,"Framework","amar"));
	}
	
//GET METHOD
	
	@GetMapping("/courses/{id}")
	public  Optional<Course> getCourse(@PathVariable long id) {
		Optional<Course> course =repository.findById(id);
		if(course.isEmpty()) {
			throw new RuntimeException("Course not found with id "+ id);
		}
		return course;
	}
	
//POST- Create a new Course
	@PostMapping("/courses")
	public void createCourse(@RequestBody Course course) {
		repository.save(course);
		
	}
	
//PUT - Update/Replace 
	@PutMapping("/courses/{id}")
	public void updateCourse(@PathVariable long id, @RequestBody Course course) {
		repository.save(course);
	}
	
//Delete 
	@DeleteMapping("/courses/{id}")
	public void updateCourse(@PathVariable long id) {
		repository.deleteById(id);
	}
	
//	@GetMapping("/courses/1")
//	public Course getcourse() {
//		return new Course(3,"Selenium","Amar");
//	}
}