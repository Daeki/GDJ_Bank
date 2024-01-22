package com.winter.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TestInterceptor extends HandlerInterceptorAdapter {
	
	//DS -> Controller 진입 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// return이 true면 Controller로 계속 진행
		// return이 false면 Controller로 진입 불가
		System.out.println("preHandle Contrller 진입 전");
		
		return true;
	}
	
	//Controller에서 나갈 때
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("PostHandler Controller에서 나갈 때");
	}
	
	//JSP를 렌더링 후(HTML작성 후 응답 나가기전)
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("JSP렌더링 후");
	}

}
