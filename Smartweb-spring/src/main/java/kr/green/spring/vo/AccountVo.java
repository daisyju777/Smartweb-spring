package kr.green.spring.vo;

public class AccountVo {
	//멤버변수의 이름은 테이블 속성의 이름과 일치시켜주는것이 좋다.
	//단 필수는 아니지만 일치하지 않으면 Mapper에서 추가 작업을 해야한다.
	//카멜 표기법을 꼭 지켜서 이름을 정해줘야함
	private String id;
	private String pw;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "AccountVo [id=" + id + ", pw=" + pw + ", email=" + email + "]";
	}
	
	
}
