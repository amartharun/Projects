package com.studentservice.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentservice.demo.beans.Students;



public interface StudentRepository extends JpaRepository<Students,Integer> {

}
