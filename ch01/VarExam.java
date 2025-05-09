package ch01;

public class VarExam {

	public static void main(String[] args) {
		// 변수 선언 테스트
		
		int x = 1 ; // 정수타입 x변수의 1값을 넣는다.
		char y = 65 ; // char 문자타입, 숫자로 변환 되기도 함.
					  // 컴퓨터는 문자를 유니코드로 변환해서 처리함.
					  // 유니코드 표에 65는 A를 의미한다.
		char z = 'A' ; // char 타입의 z변수에 문자 A를 넣는다.
		
		System.out.println("int x = " + x);
		System.out.println("char y = " + y);
		System.out.println("char z = " + z);
		
		char z1 = 'a' ;
		char z2 = '가' ;
		System.out.println(z1);
		System.out.println(z2);
		
		int x1 ; // 초기화 안된 변수
		x1 = 10 ; // 변수의 초기값을 10으로 넣음.
		System.out.println(x1);
		
		// 다중 변수 선언
		
		int kor, mat, eng, total, avg ; 
		
		kor = 91 ;
		mat = 80 ;
		eng = 70 ;
		
		total = kor + mat + eng ; // 총점
		avg = total /3 ; //평균
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
		// 코드상에 문제는 아니지만 평균 값에 소수점이 사라짐
		
		// 변수 작성 규칙
		// 변수는 첫글자가 영문이어야 되며 $,_을 사용할 수 있다
		// 관례로 첫글자 영문은 소문자로, 두번째 단어부터는 대문자로 시작한다.
		
		int price, $price, _price ; // 가급적이면 특수문자 사용 제외
		
		//int 1v ;
		//int @speed ;
		//int $#value ; 
		
		char firstname = '김' ;
		char firstName = '이' ;
		
		System.out.println("성 : " + firstname);
		System.out.println("성 : " + firstName);
		
		// 변수명이 대소문자는 다른 변수로 인식한다.
		// 변수명에 예약어는 사용할 수 없다.
		// 예약어는 자바에서 이미 사용중인 영문 (변수, 클래스)
		
		// int char ; 
		
		// 리터럴 : 직접 입력된 값
		
		int literal1 = 75 ; // 10진수
		int literal2 = 075 ; // 8진수
		int literal3 = 0b0011 ; // 2진수
		int literal4 = 0xA ;  // 16진수
		
		System.out.println("10진수 75 : " + literal1);
		System.out.println("8진수 75 : " + literal2);
		System.out.println("2진수 0011 : " + literal3 );
		System.out.println("16진수 A : " + literal4);
		
		
		
		

	}  // 메인메소드 종료

}  // VarExam 클래스 종료
