package kr.green.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVo;

@Controller
@RequestMapping(value="/bbs")  //URI 가 bbs로 들어오는 애들은 이 컨트롤러로 넘어오게 함. 
//이 코드를 주석처리하고 클래스안에서 @RequestMapping(value="bbs/list") 라고 써줘도 같은 기능을 함
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/list") 
	public String list(BoardVo board, Model model) {
		List<BoardVo> boardList = boardService.getBoards();
		model.addAttribute("list",boardList);
//		for(BoardVo tmp : boardList) {
//			System.out.println(tmp);
//		}
		//System.out.println(boardList);
		return "bbs/list";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGet(BoardVo board) {
		return "bbs/register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPost(BoardVo board) {
		System.out.println(board);
		boardService.register(board);
		//게시판은 중복체크 안하고 넣기만 하면됨.(중복된 게시물이 존재할수 있음)
		//System.out.println(boardService.list(board));
		return "redirect:/bbs/list"; //redirect는 URI를 새로 입력한것과 같음. redirect를 안쓰면 직접 jsp를 불러옴
		
	
		
		
	}
}
