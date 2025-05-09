package ch01;

public class CastingExam {

	public static void main(String[] args) {
		// 강제타입변환 (Casting)
		// 큰 크기의 타입은 작은 크기의 타입으로 자동 변환 할 수 없다.
		// int (21억) -> byte 타입으로 담으면 누수가 발생한다.
		// 이것을 누수가 발생 하더라도 강제로 적용하는 법을 강제 타입 변환이라고 함.
		
		int intValue = 123456789 ;
		byte byteValue = (byte)intValue ; // 강제로 byte 타입으로 변환.
		
		System.out.println("int 타입 값 출력 " + intValue);
		System.out.println("byte 타입 값 출력 " + byteValue);
		//byte 타입의 8bit를 만들고 앞에 값을 날려버린다.
		//10진수 123456789 값을 byte값(2진수)로 변환
		//111010110111100110100010101
		//                   00010101 -> 21
		//                   BIN 2진수 -> 10진수 DEC
		
		int kor = 85 ;
		int eng = 99 ;
		int mat = 97 ;
		
		int total = kor + eng + mat ; 
		System.out.println("성적표");
		System.out.println("국어 + 영어 + 수학 = 총점 : " + total );
		
		double avg = total / 3 ; // 자동타입 변환 됨.
		System.out.println("평균 점수(자동타입변환) : " + avg);
		// 문제 발생 : 어떤 값을 계산 해도 소수점이 0으로 나온다.
		// 이유 : int 타입 total이 3으로 나누어짐.
		// 문제해결 : double 타입으로 강제 타입 변환 후에 3으로 나누어야함.
		
		avg = (double)total / 3 ; // 강제타입 변환 됨.
		System.out.println("평균점수(강제타입변환) : " + avg);

		
		
	} // 메인메소드 종료

} // 클래스 종료
