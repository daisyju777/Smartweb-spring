package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.BoardVo;

public interface BoardDao {

	void setBoard(@Param("board")BoardVo board);
	
	List<BoardVo> getBoards();

	
}
