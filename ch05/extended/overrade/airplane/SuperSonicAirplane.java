package ch05.extended.overrade.airplane;

public class SuperSonicAirplane extends Airplane { // 자식클래스
	// 필드
	public static final int NORMAL = 1 ; // 일반비행
	public static final int SUPERSONIC = 2 ; // 초음속 비행
	// 상수 선언 (변하지 않는 값)
	
	public int flyMode = NORMAL ; // 기본비행모드는 일반비행 = 1

	
	// 생성자 (기본 생성자)
	
	
	
	// 메서드
	@Override // 부모 클래스에 있는 fly()를 재정의한다.
	public void fly() {
		if (flyMode == SUPERSONIC ) {
			System.out.println("초음속 비행합니다.");
		}else {
			super.fly(); // 부모에서 제공하는 fly()호출
			// super.메서드() 
	}	
	} // 재정의한 fly메서드 종료

} // class종료
