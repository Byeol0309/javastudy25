package mbcboard.dto;

import java.sql.Date;

public class BoardDTO {
	// 2025.06.10 
	// Board의 객체를 담당하는 DTO객체, 게터와 세터를 활용한다.
	// 필드 (테이블에 있는 모든 자료를 입력)
	private String bno;
	private String btitle ;
	private String bcontent;
	private String bwiter ;
	private Date bdate ; //import java.sql.Date;
	
	// 기본 생성자
	
	
	
	// 메서드

	public String getBno() {
		return bno;
	}
	public String getBtitle() {
		return btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public String getBwiter() {
		return bwiter;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public void setBwiter(String bwiter) {
		this.bwiter = bwiter;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

}
