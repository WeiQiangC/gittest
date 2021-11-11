package com.chen.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

//������
public class MyInterceptor implements HandlerInterceptor {
	/*
	 * preHandle����ΪԤ���������ڿ���������ִ��֮ǰ��ִ�У��û����������ȵ���˷���
	 *	���ã����Ի�ȡ�������Ϣ��������֤����
	 *		  ������֤�û��Ƿ��¼����֤�û��Ƿ���Ȩ�޷���ĳ�����ӵ�ַ��url��
	 *		  ��֤ʧ�ܵĻ�����нض�����
	 *ͨ������ֵ������֤,����ֵΪtrue��ͨ��������afterCompletion�ܻ�ִ��
	 * Object handler�������صĿ���������
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("1111-preHandleִ��");
		//request.getRequestDispatcher("/tips.jsp").forward(request, response);
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	
	/*
	 * postHandle:������
	 *  Object handlerΪ����������ModelAndView modelAndViewΪ�����������ķ���ֵ
	 *  �ڴ���������֮��ִ�У��ܹ���ȡ�������������ķ���ֵ�������޸ģ���Ҫ��ԭ���ִ�н�����ж�������
	 *  
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("1111-postHandleִ��");
		if(modelAndView != null ) {
			modelAndView.addObject("date",new Date());
			modelAndView.setViewName("dealexceptionresult2");
		}
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	/*
	 * afterCompletion�����ִ�еķ���
	 * Object handler�������صĴ���������Exception ex�������׳����쳣
	 *����������ɺ�ִ�У�������ͼ������ɣ�����ͼ������forward����Ϊ���������
	 *һ������Դ����
	 */
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("1111-afterCompletionִ��");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
