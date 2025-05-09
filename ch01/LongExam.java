package ch01;

public class LongExam {

	public static void main(String[] args) {
		long var1 = 10 ;
		long var2 = 20L ;
		long var3 = 1000000000000L ; 
		System.out.println(var1);
		System.out.println(var3);
		
		int intValue = 100 ;
		byte byteValue = (byte)intValue ;
				System.out.println(intValue);
				System.out.println(byteValue);
				// int(4byte) -> byte(1byte) 강제타입변환
				
		intValue = 44032 ;
		char charValue = (char) intValue ; 
		System.out.println(charValue);
		// int(4byte) -> char(2byte) 강제타입변환
		
		double doubleValue = 3.14 ;
		intValue = (int)doubleValue ;
		System.out.println(intValue); 
		//double(8byte) -> int(4byte) 강제타입변환
		// 실수 -> 정수 강제타입변환 , 소수점 이하 부분은 버려지고 정수 부분만 남는다.

		
	} // 메인메서드 종료

} // 클래스 종료
