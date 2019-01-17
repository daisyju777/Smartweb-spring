package kr.green.spring.vo;

import java.sql.Date;

public class AccountVo {
	//AccountVo의 멤버변수 이름과 DB의 속성들 이름을 일치시키면 추가적인 작업없이 자동으로 연결됨. 멤버변수 이름을 쓸때는 소문자로 써주는것이 좋음. 대문자로하면 멥퍼에서 인식을 못함
	private String id;
	private String pw;
	private String email;
	private String gender;
	private String authority;
	private Date registered_date;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Date getRegistered_date() {
		return registered_date;
	}
	public void setRegistered_date(Date registered_date) {
		this.registered_date = registered_date;
	}
	@Override
	public String toString() {
		return "AccountVo [id=" + id + ", pw=" + pw + ", email=" + email + ", gender=" + gender + ", authority="
				+ authority + ", registered_date=" + registered_date + "]";
	}
	/*
	객체를 문자열로 변환할 필요가 있을때 toString()메소드를 사용함. System.out.print("문자열") 쓸때도 자동으로 toString()메소드가 호출되어 처리된 결과를 보여주는 것임
	이 toString()메소드는 가장 상위 객체인 Object에 포함된 객체이므로 오버라이딩해서 사용할 수 있음
	*/
	
}
