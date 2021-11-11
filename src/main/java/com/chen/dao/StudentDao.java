package com.chen.dao;

import java.util.List;

import com.chen.domain.Student;


public interface StudentDao {
	int insertStudent(Student student);
	List<Student> selectStudent();
}
