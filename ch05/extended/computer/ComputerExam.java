package ch05.extended.computer;

public class ComputerExam {
	// 2025.05.29 상속과 메서드 재정의(Override)
	// 오버라이딩.재정의
	// 부모 클래스에서 상속 받은 메서드를, 자식 클래스에서 수정하여 사용할 수 있다.
	// 메서드가 오버라이딩 될 경우  
	// 부모 객체의 메서드는 숨겨지므로 자식객체에서 메서드를 호출하면 -> 오버라이딩된 자식 메서드가 호출된다.
	
	// 오버라이딩 규칙 
	// 부모 메서드와 동일한 시그니처
	// 접근 제한을 더 강하게 할 수 없음.
	// 새로운 예외(Exception)을 throws할 수 없음.
	
	// 부모와 자식 클래스의 PI값을 다르게 입력하고 Override를 해보자.
	// 부모 클래스의 PI값 : 사람이 입력
	// 자식 클래스의 PI값 : 컴퓨터가 알고 있는 값
	// @Override -> 오버레이드가 잘 되었는지 확인하는 어노테이션.
	
	public static void main(String[] args) {
		int r = 10 ; 
		Calculator cal = new Calculator () ; // 
		//부모클래스 타입의 객체를 생성하여 cal 객체에 넣었다.
		System.out.println("원 면적 :" + cal.areaCircle(r));
		System.out.println(); // 부모 객체에 대한 원면적 계산값.
		
		Computer com = new Computer(); 
		// 자식 클래스 타입의 객체를 생성하여 com 객체에 넣었다.
		System.out.println("원 면적 :"+ com.areaCircle(r));
		System.out.println(); // 자식 객체에 대한 원면적 계산값.
		
	} // main메서드 종료

}
