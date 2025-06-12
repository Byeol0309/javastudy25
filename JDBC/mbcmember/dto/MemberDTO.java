package mbcmember.dto;

import java.sql.Date;

public class MemberDTO {
	// 2025.06.11
	// Member의 객체를 담당하는 DTO객체, getter와 setter활용
	// 필드
	private int mno ;
	private String bwriter;
	private String id ;
	private String pw ;
	private Date regidate ; //import java.sql.Date;
	
	 
	// 기본 생성자
	
	
	//메서드
	public int getMno() {
		return mno;
	}
	public String getBwriter() {
		return bwriter;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public Date getRegidate() {
		return regidate;
	}
	
	
	public void setMno(int mno) {
		this.mno = mno;
	}
	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}
	public void setId(String id) {
		//memberDAO.vlidation(memberDAO, id);
		this.id = id;
	}
	
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}

} // MemberDTO class종료
