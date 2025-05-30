package ch05.extended.overrade.airplane;

public class SuperSonicExam {
	// 2025.05.29(목)
	// super로 오버라이딩된 메서드를 활용해본다.
	// 자식 클래스에서 오버라이딩된 부모 클래스는 숨겨지지만  
	// super키워드를 붙이면 부모 메서드를 호출할 수 있다.

	public static void main(String[] args) {
		SuperSonicAirplane sa = new SuperSonicAirplane ();
		sa.takeOff(); // 부모 메서드
		sa.fly(); // 부모 메서드 (super로 호출)
		sa.flyMode = SuperSonicAirplane.SUPERSONIC ;
		// supersonic모드로 변경
		sa.fly(); // 오버라이딩된 자식
		sa.flyMode = SuperSonicAirplane.NORMAL ;
		sa.fly(); // 부모 (super로 호출)
		sa.land(); // 부모 메서드
		
		
		
	} // main메서드종료

	
} // class종료
