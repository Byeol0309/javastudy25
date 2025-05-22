package ch02;

import java.util.Scanner;

public class CalcuratorExam {
	// 간단한 계산기 프로그램 만들기
	// 입력받기 : 숫자 > 연산자 > 숫자
	// 연산자별로 메서드에 숫자를 넣기. (입력받는 순서에 맞춰서 메서드에서 잘 해결하기.
	// 결과값 : main메서드에서 출력하기 (return받아서)
	// 완료 : 반복재생 가능하게 while문 사용하기 (다시사용하시겠습니까? or 이어서 계산하시겠습니까?)
	// x1 (처음 입력값), x3(나중 입력값), x4(계산 결과값) , x2(연산자값)

	static int puls(int x1, int x3) { // puls메서드에서 int타입의 변수x1, x3을 전달할것임.
		int x4 = 0;
		return x4 = x1 + x3; // 리턴
	}// plus M end

	static int minus(int x1, int x3) {
		int x4 = 0;
		x4 = x1 - x3;
		return x4;
	} // minus M end

	static int times(int x1, int x3) {
		int x4 = 0;
		x4 = x1 * x3;
		return x4;
	} // times M end

	static int divide(int x1, int x3) {
		int x4 = 0;
		x4 = x1 / x3;
		return x4;
	} // divide M end

	static int apply(int x6) {
		return x6 ;
	}

	public static void main(String[] args) {

		int x1 = 0, x2 = 0, x3 = 0, x4 = 0, x5 = 0, x6 = 0 ; // 변수 4개
		boolean run = true, run2 = true; // while문용 boolean값
		String y1 = "연산기호"; // 정답 표시용
		Scanner scInt = new Scanner(System.in); // 스캐너 생성

		while (run) {
			if (x1 == 0) {
				System.out.println("**정수계산기**숫자를 입력해주세요(int 범위 내에서만)>>>");
				x1 = scInt.nextInt(); // 키보드로 입력받은 값을 x1에 넣는다.

				System.out.print("부호를 선택해주세요 1.+(더하기) 2.-(빼기) 3.(곱하기) 4.(나누기)>>>");
				x2 = scInt.nextInt(); // 키보드로 입력받은 값을 x2에 넣는다.

				System.out.println("숫자를 입력해주세요(int 범위 내에서만)>>>");
				x3 = scInt.nextInt(); // 키보드로 입력받은 값을 x3에 넣는다.
				run2 = true;
				
			} else if (x6 != 0) {
				apply(x6) ;
				
				System.out.print("부호를 선택해주세요 1.+(더하기) 2.-(빼기) 3.(곱하기) 4.(나누기)>>>");
				x2 = scInt.nextInt(); // 키보드로 입력받은 값을 x2에 넣는다.

				System.out.println("숫자를 입력해주세요(int 범위 내에서만)>>>");
				x3 = scInt.nextInt(); // 키보드로 입력받은 값을 x3에 넣는다.
				run2 = true;

			} // else 종료

			switch (x2) {
			case 1:
				x4 = puls(x1, x3);
				y1 = "+";
				break;

			case 2:
				x4 = minus(x1, x3);
				y1 = "-";
				break;

			case 3:
				x4 = times(x1, x3);
				y1 = "x";
				break;

			case 4:
				x4 = divide(x1, x3);
				y1 = "÷";
				break;
			// default 생략
			} // switch(x2)문 종료

			System.out.println("계산결과 :" + x1 + y1 + x3 + " = " + x4);
			while (run2) { // while(run2)
				if (x4 != 0) {
					System.out.println("1.종료하기  2.다시하기  3.이어서계산하기>>>");
				} else {
					System.out.println("1.종료하기  2.다시하기 >>>");
				}
				x5 = scInt.nextInt();
				switch (x5) {
				case 2:
					x1 = 0;
					x2 = 0;
					x3 = 0;
					run2 = false;
					break;
				case 3:
					x1 = x4 ;
					x2 = 0;
					x3 = 0;
					x6 = x4 ; // x6에 x4 값을 넣는다.
					run2 = false;
					break;
				case 1:
					x1 = 0;
					x2 = 0;
					x3 = 0;
					run = false;
					run2 = false;
					break; // case 1 : 제일마지막
				} // switch문 종료
			} // while(run2)종료

		} // while문(run1) 종료

	} // main메서드종료

}// class종료
