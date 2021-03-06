package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService{

	/* Autowired는 객체 생성을 자동으로 해준다. */
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public AccountVo getAccount(String id) {
		return accountDao.getAccount(id);   //id와 일치하는 객체정보 반환
	}

	@Override
	public boolean signup(AccountVo accountVo) {
		/*아이디 중복 확인
		1. accountDao를 이용하여 id정보가 주어지면 해당 id와 일치하는 객체 정보를 가져온다.
		2. 가져온 객체정보가 null이면 accountDao.insertAccount(accountVo)를 실행하고 아니면 아무것도 처리하지 않음.
		*/
		String id = accountVo.getId();
		AccountVo tmp = accountDao.getAccount(id);
	
		if(tmp == null) {
			String encPw = passwordEncoder.encode(accountVo.getPw());
			accountVo.setPw(encPw);
			accountVo.setAuthority("user");
			accountDao.insertAccount(accountVo);
			return true;
		} else 
			return false;
			
	}
	

	@Override
	public AccountVo signin(String id, String pw) {
		AccountVo user = accountDao.getAccount(id);
		if(user != null && passwordEncoder.matches(pw, user.getPw())) // 첫번째는 원래 비밀번호, 두번째는 DB에 저장되어있는 암호화된 비밀번호
			return user;
		return null;
	}

}
