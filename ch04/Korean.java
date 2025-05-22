package ch04;

public class Korean {
	// 2025.05.22(목)
	// 필드와 생성자 활용해보기.
	
	// 필드
	String nation = "대한민국" ;
	String name ; // 이름
	String ssn ;  //주민번호
	
	//생성자
	public Korean(String name, String ssn ) {
		// name = name;       생성자 매개변수로 필드명을 사용하면 
		// ssn = ssn;		   name이 중복배정돼서 원하는 값이 나오지 않는다.
		// this.
		// this는 객체 자신의 참조
		this.name = name ; 
		this.ssn  = ssn ;
		
	}
	
}
