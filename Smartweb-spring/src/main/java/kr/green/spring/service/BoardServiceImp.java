package kr.green.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.BoardDao;
import kr.green.spring.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	BoardDao boardDao;
	
	@Override
	public void register(BoardVo board) {
		boardDao.setBoard(board);
	}
//
//	public List<BoardVo> list(BoardVo board) {
//		return boardDao.getBoards(board);
//	}

	@Override
	public List<BoardVo> getBoards() {
		return boardDao.getBoards();
	}

}
