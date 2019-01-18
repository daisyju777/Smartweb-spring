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
		model.addAttribute("login", false);
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(String id, String pw, Model model) {
//		if(!accountService.signup(accountVo)) {
//			return "redirect:/list";
//		} else {
//			model.addAttribute("login", false);
//			return "redirect:/"; 
//		}
		AccountVo user = accountService.signin(id,pw);
		if(user != null) {
			model.addAttribute("user",user);
			return "redirect:/bbs/list"; // redirect:/list 이렇게 쓰고 BoardController에서 value 값을 "/list"라고 정해줘도 됨
		} else {
			return "redirect:/"; 
		}
			
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Boolean fail, Model model) {          //컨트롤러에서 jsp쪽에  보내기 위해 model 매개변수 필요
		model.addAttribute("fail", fail);
		return "account/signup";
	}
	
	//int -> Integer, double -> Double, boolean -> Boolean  일반 자료형을 클래스의 객체로 만듬. 이러한 클래스를 Wrapper class라 한다. null값을 허용할수 있도록 하기 위해서
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(AccountVo accountVo, Model model) {           //전달받은 내용을 accountVo에 저장. 업무를 마치고 서비스가 나한테 데이터를 전달할때까지 기다림
		if(accountService.signup(accountVo))
			return "redirect:/";
		else {
			model.addAttribute("fail",true);
			return "redirect:/signup";
		}
	}
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
//	public String listGet() {
//		return "bbs/list";
//	}
//	
//	@RequestMapping(value = "/list", method = RequestMethod.POST)
//	public String listPost() {
//		return "redirect:/";
//	}
	
	
}
