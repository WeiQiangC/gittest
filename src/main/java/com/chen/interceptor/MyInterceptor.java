package com.chen.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

//拦截器
public class MyInterceptor implements HandlerInterceptor {
	/*
	 * preHandle方法为预处理方法，在控制器方法执行之前先执行，用户的请求首先到达此方法
	 *	作用：可以获取请求的信息，进行验证请求
	 *		  可以验证用户是否登录，验证用户是否有权限访问某个连接地址（url）
	 *		  验证失败的话则进行截断请求
	 *通过返回值进行验证,返回值为true则通过请求，且afterCompletion总会执行
	 * Object handler：被拦截的控制器对象
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("1111-preHandle执行");
		//request.getRequestDispatcher("/tips.jsp").forward(request, response);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	
	/*
	 * postHandle:后处理方法
	 *  Object handler为处理器对象，ModelAndView modelAndView为处理器方法的返回值
	 *  在处理器方法之后执行，能够获取到处理器方法的返回值并进行修改，主要对原理的执行结果进行二次修正
	 *  
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("1111-postHandle执行");
		if(modelAndView != null ) {
			modelAndView.addObject("date",new Date());
			modelAndView.setViewName("dealexceptionresult2");
		}
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	/*
	 * afterCompletion：最后执行的方法
	 * Object handler：被拦截的处理器对象，Exception ex方法中抛出的异常
	 *在请求处理完成后执行，即当视图处理完成，对视图进行了forward就认为请求处理完成
	 *一般做资源回收
	 */
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("1111-afterCompletion执行");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
