package kr.green.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(value="/bbs")  //URI 가 bbs로 들어오는 애들은 이 컨트롤러로 넘어오게 함. 
//이 코드를 써주면 클래스안에서는 @RequestMapping(value="/list") 라고 써주면 됨
public class BoardController {
	@RequestMapping(value="bbs/list")  //  "/list" 이렇게 써도 됨
	public String list() {
		return "bbs/list";
	}
}
