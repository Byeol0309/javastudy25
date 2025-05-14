package ch02;

import java.util.Scanner;

public class IfExam3 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("이름을 입력해주세요");
		System.out.print(">>>");
		String name = input.nextLine();
		System.out.println("국어점수를 입력해주세요");
		System.out.print("국어 :");
		int kor = input.nextInt(); // kor변수에 입력받은 값을 넣는다.
		if(kor < 0 || kor > 100) {
			System.out.println("잘못입력하셨습니다."); 
		} // 입력값 검증
		
		System.out.print("수학 :");
		int mat = input.nextInt(); 
		if (mat < 0 || mat > 100) {
			System.out.println("잘못입력하셨습니다.");
		} // 입력값 검증
		
		System.out.println("영어 :");
		int eng = input.nextInt(); // ���� ���� �Է�
		if (eng < 0 || eng > 100) {
			System.out.println("잘못입력하셨습니다.");
		} // 입력값 검증
		
		int total = kor + mat + eng ; // 점수의 합계를 total에 넣는다.
		double avg = (double)total /3 ; // 점수의 평군을 avg에 넣는다.
		System.out.println("점수의 평균값을 확인하려면");
		System.out.print("yes를 입력해주세요 :");
		String answer = input.next();
		if (answer.equalsIgnoreCase("yes")) {
			System.out.println("====확인중====");
			System.out.println("평균점수: "+avg);
		}else {
			System.out.println("다시입력해주세요.");
		}

	} // main 메소드 종료

} // class 종료
