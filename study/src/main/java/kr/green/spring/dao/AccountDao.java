package kr.green.spring.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.AccountVo;

public interface AccountDao {
	public AccountVo getAccount(String id); //AccountDao를 구현하는것은 mapper가 할 것임.

	public void setAccount(@Param("accountVo")AccountVo accountVo); //객체에 @Param을 지정해줄때는 Mapper에서 수정이 필요함

}
