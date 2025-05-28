package ch05.getter_setter;

public class MemberDTO {
	 // 2025.05.26
	 // Getter와 Setter메서드
	 // 클래스를 선언할때 필드를 private로 선언하고 
	 // 필드에 대한 Getter와 Setter 메서드를 작성하여 필드값을 안전하게 변경, 사용하는 것이 좋다.

	 // 필드 타입이 boolean일 경우 Getter와 get으로 시작하지 않고 is로 시작하는것이 관례이다.
	 // public boolean isAdmin() {}
	
	 // 필드
	private String name ; 
	private int age ;
	private boolean admin ;
	
	// 생성자
	
	
	
	
	// 메서드  -> 공용 메서드를 통해서 값을 주고 받는다.
	// Source 메뉴에 Generate Getter and Setters를 이용해서 생성함.
	public String getName() { // Getter : 
		return name + "님"; //return 값을 가공하여 내보낼수있음.
	}
	public int getAge() {
		return age;
	}
	public String isAdmin() {
		String adminString = "" ;
		if (admin == true) {
			adminString = "관리자" ;
		}
		return adminString ;
	}
	public void setName(String name) { 	// Setter : 필드 private 선언 후 생성자를 이용해 검증 후 매개값을 전달하는 역할 
		this.name = name;
	}
	public void setAge(int age) { 		// Setter : 세터로 들어온 입력값을 검증할수있음.
		this.age = age;
	}
	public void setAdmin(boolean admin) { // Setter
		this.admin = admin;
	}
	 
	

}
