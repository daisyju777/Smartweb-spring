package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService{ //AccountService를 구현하는 부분
	@Autowired  //@Autowired를 이용해 AccountDao와 연결해줌. Inject는 자바제공. Autowired는 스프링에서 제공해줌
	AccountDao accountDao;  //DB와 연결해주기 위해 다오를 불러옴
	
	@Override
	public AccountVo getAccount(String id) {
		return accountDao.getAccount(id);
	}

	@Override
	public boolean signup(AccountVo accountVo) {
		//가입 여부 확인하여 회원 정보가 있으면(null이 아니면) 작업 중지
		if(accountDao.getAccount(accountVo.getId()) != null) {
			return false;
		}
		accountVo.setAuthority("user");
		accountDao.setAccount(accountVo);
		return true;
	} 

	
}
