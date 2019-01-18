package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//로그인 안한사람들만 들어갈수 있는 페이지를 만들려고 함
public class UnauthInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user"); //세션에서 사용자 정보를 가져옴
		//Object user = request.getSession().getAttribute("user"); 위의 2줄을 한줄로 쓴것
		if(user != null) {       //로그인이 되어있으면(가져온 사용자정보가 null이 아니면) 게시판 페이지를 보내줘라.
			response.sendRedirect(request.getContextPath() + "/bbs/list");
		}
		return true;
	}
}

