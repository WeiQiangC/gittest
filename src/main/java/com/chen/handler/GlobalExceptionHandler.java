package com.chen.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.chen.exception.AgeException;
import com.chen.exception.NameException;

/*
 * 给控制器增强异常处理功能
 * 必须让框架知道这个注解所在的位置，需要在配置文件中配置组件扫描器指定
 * @ControllerAdvice所在的位置
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	//定义方法处理异常
	
	/*
	 * 定义异常处理方法，方法的定义和控制器的方法定义一样
	 * 形参Exception表示controller中抛出的异常对象，通过该形参可以获取异常信息
	 * @ExceptionHandler(value = NameException.class)表示发生NameException异常时由该方法处理
	 */
	@ExceptionHandler(value = NameException.class)
	public ModelAndView doNameException(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "姓名必须是zhangsan，其他用户不能访问");
		mv.addObject("ex",exception);
		mv.setViewName("erro");
		return mv;
	}
	
	@ExceptionHandler(value = AgeException.class)
	public ModelAndView doAgeException(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "年龄不能为空或者大于150");
		mv.addObject("ex",exception);
		mv.setViewName("erro");
		return mv;
	}
	
	//@ExceptionHandler后面不加value表示处理其他异常，且不加value只能有一个
	@ExceptionHandler
	public ModelAndView doOtherException(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "");
		mv.addObject("ex",exception);
		mv.setViewName("erro");
		return mv;
	}
}
