package com.chen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chen.domain.Student;
import com.chen.exception.AgeException;
import com.chen.exception.MyException;
import com.chen.exception.NameException;
import com.chen.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@RequestMapping("/addStudent.do")
	public ModelAndView addStudent(Student student) {
		ModelAndView mv = new ModelAndView();
		String tips  = "注册失败";
		int nums = service.addStudent(student);
		if(nums > 0) {
			tips = "学生：" + student.getName() + "注册成功";
		}
		mv.addObject("tips",tips);
		mv.setViewName("result");
		return mv;
	}


	@RequestMapping("/querystudent.do")
	@ResponseBody
	public List<Student> queryStudent(){
		return service.queryStudent();
	}
	
	@RequestMapping("/exception.do")
	public ModelAndView dealException(String name,Integer age) throws MyException {
		ModelAndView mv = new ModelAndView();
		if(!"zhangsan".equals(name)) {
			throw new NameException("姓名不正确");
		}
		if(age == null || age > 150) {
			throw new AgeException("年龄输入有误");
		}
		mv.addObject("name",name);
		mv.addObject("age",age);
		mv.setViewName("dealexceptionresult");
		return mv;
	}
}
