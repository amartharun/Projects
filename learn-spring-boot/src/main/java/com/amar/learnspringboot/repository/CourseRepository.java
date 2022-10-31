package com.amar.learnspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amar.learnspringboot.bean.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
