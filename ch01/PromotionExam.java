package ch01;

public class PromotionExam {

	public static void main(String[] args) {
		// 자동 타입 변환 연습
		// byte(1byte : 8bit)
		// shot(2byte : 16bit) & char(유니코드용 : 문자표현)
		// int (4byte : 32bit)
		// long(8byte : 64bit)  접미사 L
		// float(4byte : 32bit) 실수형 접미사 F
		// double(8byte : 64bit)
		
		byte byteValue = 10 ; // 바이트 타입의 변수에 10값을 넣음.
		int intValue = byteValue ; // 자동타입변환됨.
		
		System.out.println("자동타입 된 int : " + intValue);
		// 자동타입 된 int : 10
		
		
		char charValue = '가' ;
		intValue = charValue ;
		System.out.println("자동타입 된 int : " + intValue);
		// 자동타입 된 int : 44032
		
		
		intValue = 500 ;
		long longValue = intValue ; 
		System.out.println("자동타입 된 long : " + longValue);
		// 자동타입 된 long : 500
		
		double doubleValue = intValue ; 
		System.out.println("자동타입 된 double : " + doubleValue);
		// 자동타입 된 double : 500.0

		
		
	} // 메인메소드 종료

} // 클래스 종료
