package com.chen.services;

import java.util.List;

import com.chen.domain.Student;


public interface StudentService {
	int addStudent(Student student);
	List<Student> queryStudent();
}
