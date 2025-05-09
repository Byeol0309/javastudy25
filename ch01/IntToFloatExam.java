package ch01;

public class IntToFloatExam {

	public static void main(String[] args) {
		// float은 32bit로 되어있는 부동 소수점 연산에 사용됨.
		// 정수타입을 실수 타입으로 변환 할 때 손실이 발생한다.
		// int(32bit) = float(32bit)
		
		int num1 = 123456780 ;
		int num2 = 123456780 ;
		
		float num3 = num2 ; // int타입 값을 float에 넣음.
		num2 = (int) num3 ; // 위에서 선언한 변수에 값을 다시 넣음
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		// num1 : 123456780
		// num2 : 123456780
		// num3 : 1.23456784E8 -> 지수 형식으로 E위에 숫자를 부동 소수점 처리
		//        12.3456784E7
		//        1234567.84E2 -> 소수점의 위치
		
		int result = num1 - num2 ;
		System.out.println("float으로 다녀온 후에 num2 값 변경됨.");
		System.out.println("num1 - num2 : " + result);
		
		
	} // 메인 메소드 종료

} // 클래스 종료
