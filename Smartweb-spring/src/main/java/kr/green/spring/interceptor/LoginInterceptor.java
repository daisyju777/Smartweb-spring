package kr.green.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.green.spring.vo.AccountVo;

public class LoginInterceptor
	extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(
	    HttpServletRequest request,       //메소드를 쓰기위한 고정된 매개변수들
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
	    ModelMap modelMap = modelAndView.getModelMap();  
	    //컨트롤러에서 사용하는 model과 비슷한 역할을함.근데 얘는 View도 포함함.때문에 어떠한 jsp파일을 열건지 같이 지정하는 경우가 많음
	    AccountVo user = (AccountVo)modelMap.get("user");
	    
	    //위의 2줄 코드를 한줄로 쓸수도 있음.
	    //AccountVo user = (AccountVo)mldelAndView.getModelMap().get("user");
	    
	    if(user != null) {
	        //HttpSession session = request.getSession();
	        //session.setAttribute("user", user);
	        //위의 두줄 코드를 한줄로 쓰면
	    	request.getSession().setAttribute("user", user);
	    }
	}

}
