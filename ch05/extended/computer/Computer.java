package ch05.extended.computer;

public class Computer extends Calculator {// 자식클래스 
							//Calculator의 자식 클래스이다.
	@Override // 어노테이션 : 코딩시 작성법을 케어해주는 설명서 역할
	double areaCircle(double r) {
		// Calculator(부모클래스)의 areaCircle()메서드를 재정의해본다.
		System.out.println("Calculator 객체의 areaCircle() 실행");
		
		return Math.PI * r * r ;
	} // 메서드 오버라이딩 진행.
							
	
	
	
	
	} // Computer (자식) class 종료


