package com.chen.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.chen.exception.AgeException;
import com.chen.exception.NameException;

/*
 * ����������ǿ�쳣������
 * �����ÿ��֪�����ע�����ڵ�λ�ã���Ҫ�������ļ����������ɨ����ָ��
 * @ControllerAdvice���ڵ�λ��
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	//���巽�������쳣
	
	/*
	 * �����쳣�������������Ķ���Ϳ������ķ�������һ��
	 * �β�Exception��ʾcontroller���׳����쳣����ͨ�����βο��Ի�ȡ�쳣��Ϣ
	 * @ExceptionHandler(value = NameException.class)��ʾ����NameException�쳣ʱ�ɸ÷�������
	 */
	@ExceptionHandler(value = NameException.class)
	public ModelAndView doNameException(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "����������zhangsan�������û����ܷ���");
		mv.addObject("ex",exception);
		mv.setViewName("erro");
		return mv;
	}
	
	@ExceptionHandler(value = AgeException.class)
	public ModelAndView doAgeException(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "���䲻��Ϊ�ջ��ߴ���150");
		mv.addObject("ex",exception);
		mv.setViewName("erro");
		return mv;
	}
	
	//@ExceptionHandler���治��value��ʾ���������쳣���Ҳ���valueֻ����һ��
	@ExceptionHandler
	public ModelAndView doOtherException(Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "");
		mv.addObject("ex",exception);
		mv.setViewName("erro");
		return mv;
	}
}
