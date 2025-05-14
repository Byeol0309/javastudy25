package ch02;

import java.util.Scanner;

public class WhileIfExam {

	public static void main(String[] args) {
		// while문, switch문, if문을 활용하여 성적 처리 시스템 만들기.
		Scanner inputInt = new Scanner(System.in); // 정수용
		Scanner inputIn = new Scanner(System.in);  // 문자용
		boolean run = true ;
		int kor = 0 ;
		int mat = 0 ;
		int eng = 0 ;
		int sci = 0 ;
		int avg = kor + mat + eng + sci ; 
		String korGrade = "" ;
		
		while (run) {
			System.out.println("===성적 확인 시스템===");
			System.out.println("1. 성적 입력 ");
			System.out.println("2. 성적 확인 ");
			System.out.println("3. 등급 확인 ");
			System.out.println("4. 나가기");
			System.out.print("(1~4)>>>");
			int selectInt = inputInt.nextInt(); // 숫자입력
			
			switch (selectInt) {
			case 1 : // 성적입력
				System.out.println("==성적 입력==");
				System.out.print("1. 국어 점수 입력 :");
				kor = inputInt.nextInt();
				
				System.out.print("2. 수학 점수 입력 :");
				mat = inputInt.nextInt();

				System.out.print("3. 영어 점수 입력 :");
				eng = inputInt.nextInt();

				System.out.print("4. 과학 점수 입력 :");
				sci = inputInt.nextInt();
				
				System.out.println("총점 :"+ avg);
				break;
				
			case 2 : // 성적확인
			System.out.println("==성적 확인==");
			System.out.println("국어 점수: "+ kor);
			
			System.out.println("수학 점수: " + mat);

			System.out.println("영어 점수: "+ eng );

			System.out.println("과학 점수: "+ sci);
			 run = false ;
			 System.out.println("======");
			System.out.println("나가기 (0)");
			System.out.println(">>>>");
			int i = inputInt.nextInt();
			if (i == 0) {
				run = true ;
			} else {
				System.out.println("잘못입력하셨습니다.");
			}
			break;
				
			case 3 : // 등급 확인
				System.out.println("==등급 확인==");
				// System.out.println("등급을 확인합니다.");
				if ( kor >= 90 ) {
					
				}
					
				break;
				
			case 4 : // 나가기
				break;
				
			default :
				break;
			} // switch문 종료
			
		} // while문 종료

	}//main 메소드 종료

}//class 종료
