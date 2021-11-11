package com.chen.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

public class MyInterceptor2 implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("22222-preHandle÷¥––");
		//request.getRequestDispatcher("/tips.jsp").forward(request, response);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("22222-postHandle÷¥––");
		if(modelAndView != null ) {
			modelAndView.addObject("date",new Date());
			modelAndView.setViewName("dealexceptionresult2");
		}
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("22222-afterCompletion÷¥––");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
