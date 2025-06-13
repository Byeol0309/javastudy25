package memberTest.dto;

import java.io.Reader;
import java.sql.Date;

public class MemberDTO {
	// 필드
	
	private String mname ;
	private String id ;
	private String pw ;
	private String memail ;
	private Date regidate ;
	private String use_yn ;
	private String admin ;
	
	// 생성자
	
	// 메서드
	private int mno ;
	public int getMno() {
		return mno;
	}
	public String getMname() {
		return mname;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getMemail() {
		return memail;
	}
	public Date getRegidate() {
		return regidate;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public String getAdmin() {
		return admin;
	}
	
	public void setMno(int mno) {
		this.mno = mno;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
}
