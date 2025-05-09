package ch01;

public class PrintfExam {

	public static void main(String[] args) {
		int i = 97 ;
		String s = "Java" ;
		double f = 3.14 ;
	    // printf("포맷 명시자", 데이터1, 데이터2  ) 
		//   %( )   -> 정해진 포맷에 맞추어 출력됨.
		// 기본값 : 오른쪽 정렬
		//   -  : 왼쪽 정렬
		//   f- : 실수형
		//   e- : 지수형
		//  .1  : .(정수) -> 정수 만큼의 소수점 숫자 표현, .(온점)도 칸을 차지함.
		//  \n  :(줄바꿈)
		// d (10진수)
		// o (8진수)
		// x (16진수)
		// c  a(char)
		
		System.out.printf("%d\n", i); // 10진수
		System.out.printf("%o\n", i); // 8진수
		System.out.printf("%x\n", i); // 16진수
		System.out.printf("%c\n", i); // a(char)
		System.out.printf("%5d\n", i); // (정수)d , (정수)만큼의 칸을 만든다.
		System.out.printf("%05d\n", i); // (정수)d 만큼의 0을 만들어 넣는다.
		System.out.printf("%s\n","java"); // s (string)문자열을 넣는다.
		System.out.printf("%-5s\n", "java"); // 5칸을 만들어, 
		                                    // s(string)을 왼쪽정렬(1)해서 넣는다. 
		System.out.printf("%4.1f\n",f);
		System.out.printf("%3d\n", i);
		System.out.printf("%03d\n", i);
		System.out.printf("%04d\n", i);
		System.out.printf("%05d\n", i);
		
		System.out.printf("%s\n",s);
		System.out.printf("%5s\n", s);
		System.out.printf("%-5s\n", s);
		System.out.printf("%f\n", f);
		System.out.printf("%e\n", f);
		System.out.printf("%4.1f\n", f);
		System.out.printf("%04.1f\n", f);
		System.out.printf("%-4.1f\n", f);
		
		

	} // main 메서드 종료

} // 클래스 종료
