package kr.green.spring.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired        //AccountServiceImp에 @service를 추가해주면 자동으로 연결되어 AccountServiceImp의 객체가 생성됨. 
	AccountService accountService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, Boolean signup) {
		model.addAttribute("signup", signup);
		return "home";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)      
	//method를 지정해 주지 않으면 get, post방식 둘다 받을 수 있음. 그런데 두 방식을 하나로 받아 메소드를 실행하면 충돌이 날수 있기 때문에 밑에 post방식일때 따로 해줘야함
	public String signupGet(Model model, Boolean signup) {
		model.addAttribute("signup",signup);
		return "signup";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(AccountVo accountVo,Model model) {    //jsp에서 보낸 name값을 매개변수로 받음. 속성값을 String으로 일일히 써주지 않고 accountVo로 써줄수 있음
		//System.out.println("id : " + id);
		//System.out.println("pw : " + pw);
		//System.out.println("email : " + email);
		//System.out.println("gender : " + gender);

		if (accountService.signup(accountVo)) {
			System.out.println("회원가입 성공");
			model.addAttribute("signup",true);  //signup변수를 던져주고  값은 true를 던져줌
			return "redirect:/";
		} else {
			System.out.println("회원가입 실패");
			model.addAttribute("signup",false);
			return "redirect:/signup";  
		}
		
		//일반적인 링크는 주소뒤에 붙는 겟방식을 이용함. form태그 안에서만 post방식임. post방식으로 받은 데이터를 받아 처리한후 redirect에서 지정해준 주소로 넘어감(이때 요청메소드는 get방식임)
	}
}
