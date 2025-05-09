package ch01;

public class IntToDouble {

	public static void main(String[] args) {
		// int타입과 float타입은 같은 32bit를 사용하지만
		// float이 소수점을 사용하기 때문에 값에 변조가 일어난다.
		
		// float보다 큰 double을 사용하여 해결해보자.
		
		int num1 = 123456780 ;
		int num2 = 123456780 ;
		
		double num3 = num2 ; // int값을 double에 넣음.
		num2 = (int) num3 ; // 위에 선언한 변수에 값을 다시 넣음.
		
		System.out.println("num1 : " + num1);
		System.out.println("num2 : " + num2);
		System.out.println("num3 : " + num3);
		
		int result = num1 - num2 ;
		System.out.println("double로 다녀온 후에 num 값 변경 안됨.");
		System.out.println("num1 - num2 : " + result);
		
	
		
		
		
		
	} // 메인메소드 종료

} // 클래스 종료
