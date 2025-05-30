package ch05.extended.computer;

public class Calculator { // 부모클래스
	   double areaCircle(double r) {
		System.out.println("Calculator 객체의 areaCircle()실행");
		
		return 3.14159 * r * r ;
		// 사람이 입력한 3.14159 에 r(입력값)으로 연산하여 리턴함. 
	   }
	
} //Calculator (부모)class 종료
