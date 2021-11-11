package com.chen.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chen.dao.StudentDao;
import com.chen.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao dao;

	public int addStudent(Student student) {
		return dao.insertStudent(student);
	}

	public List<Student> queryStudent() {
		List<Student> student = dao.selectStudent();
		return student;
	}

}
