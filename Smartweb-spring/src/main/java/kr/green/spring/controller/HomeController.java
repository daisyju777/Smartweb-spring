package kr.green.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;


@Controller
public class HomeController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model) {
		/* 컨트롤러에서 jsp로 데이터를 전달하기 위해서
		 * 1. 매개변수에 Model1 객체를 추가 : Model model
		 * 2. model.addAttribute()를 통해 데이터 전달
		 *    model.addAttribute("jsp에서받는이름", 전달할데이터);
		 */
		//model.addAttribute("serverTime", "서버시간" );  //서버시간이라는 문자열을 전달함
		//System.out.println(accountService.getAccount("stajun"));
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(String name) {
		/* jsp에서 넘겨준 데이터를 받기 위해서는 태그의 속성 name과 일치하는 이름을 매개변수의 이름으로 설정한다.*/
		System.out.println("jsp에서 넘어온 값: " +name);
		return "redirect:/"; //jsp파일을 직접 부르는게 아니고 내가부르고자하는 URI를 호출하는 값을 다시 호출
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Boolean fail, Model model) {          //컨트롤러에 있는 jsp를 보내기 위해 model 매개변수 필요
		if (fail == null) {           //주소뒤에 아무것도 안붇고 그냥 들어왔을때  http://localhost:8080/spring/signup?fail=false 에서 ?fail=false가 없음
			fail = false;
		}
		model.addAttribute("fail", fail);
		return "account/signup";
	}
	
	//int -> Integer, double -> Double, boolean -> Boolean  일반 자료형을 클래스의 객체로 만듬. 이러한 클래스를 rapper class라 한다. null값을 허용할수 있도록 하기 위해서
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPOST(AccountVo accountVo, Model model) {           //전달받은 내용을 accountVo에 저장. 업무를 마치고 서비스가 나한테 데이터를 전달할때까지 기다림
		if(accountService.signup(accountVo))
			return "redirect:/";
		else {
			model.addAttribute("fail",true);
			return "redirect:/signup";
		}
	}
}
