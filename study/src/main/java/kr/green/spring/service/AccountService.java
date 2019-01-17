package kr.green.spring.service;

import kr.green.spring.vo.AccountVo;

//인터페이스를 만들어두면  AccountService가 어떤 기능을 하는지 한눈에 알아볼수 있음
public interface AccountService {
	public AccountVo getAccount(String id);     //id가 주어지면 계정정보를 가져오는 메소드

	public boolean signup(AccountVo accountVo);
}
