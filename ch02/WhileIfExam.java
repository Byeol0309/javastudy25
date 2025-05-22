package ch02;

import java.util.Scanner;

public class WhileIfExam {

	public static void main(String[] args) {
		// while문, switch문, if문을 활용하여 성적 처리 시스템 만들기.
		Scanner inputInt = new Scanner(System.in); // 정수용
		Scanner inputIn = new Scanner(System.in); // 문자용
		boolean run = true;
		int kor = 0;
		int mat = 0;
		int eng = 0;
		int sci = 0;
		int avg = 0;
		String korGrade = "";
		String matGrade = "";
		String engGrade = "";
		String sciGrade = "";

		while (run) {
			System.out.println("===성적 확인 시스템===");
			System.out.println("성적을 먼저 입력해주세요");
			System.out.println("=================");
			System.out.println("1. 성적 입력 ");
			System.out.println("2. 성적 확인 ");
			System.out.println("3. 등급 확인 ");
			System.out.println("4. 프로그램종료 ");
			System.out.print("(1~4)>>>");
			int selectInt = inputInt.nextInt(); // 숫자입력

			switch (selectInt) {
			case 1: // 성적입력
				System.out.println("==성적 입력==");
				System.out.print("1. 국어 점수 입력 :");
				kor = inputInt.nextInt();
				if (kor < 0 || 100 < kor ) {
					System.out.println("잘못 입력하셨습니다.");
				} // 입력값 검증

				System.out.print("2. 수학 점수 입력 :");
				mat = inputInt.nextInt();
				if (mat < 0 || 100 < mat ) {
					System.out.println("잘못 입력하셨습니다.");
				} // 입력값 검증

				System.out.print("3. 영어 점수 입력 :");
				eng = inputInt.nextInt();
				if (eng < 0 || 100 < eng ) {
					System.out.println("잘못 입력하셨습니다.");
				} // 입력값 검증

				System.out.print("4. 과학 점수 입력 :");
				sci = inputInt.nextInt();
				if (sci < 0 || 100 < sci ) {
					System.out.println("잘못 입력하셨습니다.");
				} // 입력값 검증
				avg = kor + mat + eng + sci;
				System.out.println("총점 :" + avg);
				break;

			case 2: // 성적확인
				System.out.println("==성적 확인==");
				System.out.println("국어 점수: " + kor);
				System.out.println("수학 점수: " + mat);
				System.out.println("영어 점수: " + eng);
				System.out.println("과학 점수: " + sci);
				run = false;
				System.out.println("=========");
				System.out.println("나가기 (0)");
				System.out.println(">>>>");
				int i = inputInt.nextInt();
				if (i == 0) {
					run = true;
				} else {
					System.out.println("잘못입력하셨습니다.");
				}
				break;

			case 3: // 등급 확인
				System.out.println("===등급 확인===");
				if (kor >= 90) {
					korGrade = "A";
				} else if (kor == 100) {
					korGrade = "A+";
				} else if (kor >= 80) {
					korGrade = "B";
				} else if (kor >= 70) {
					korGrade = "C";
				} else {
					korGrade = "D";
				} // 국어등급 if문 종료

				if (mat >= 90) {
					matGrade = "A";
				} else if (mat == 100) {
					matGrade = "A+";
				} else if (mat >= 80) {
					matGrade = "B";
				} else if (mat >= 70) {
					matGrade = "C";
				} else {
					matGrade = "D";
				} // 수학등급 if문 종료

				if (eng >= 90) {
					engGrade = "A";
				} else if (eng == 100) {
					engGrade = "A+";
				} else if (eng >= 80) {
					engGrade = "B";
				} else if (eng >= 70) {
					engGrade = "C";
				} else {
					engGrade = "D";
				} //영어등급 if문 종료

				if (sci >= 90) {
					sciGrade = "A";
				} else if (sci == 100) {
					sciGrade = "A+";
				} else if (sci >= 80) {
					sciGrade = "B";
				} else if (sci >= 70) {
					sciGrade = "C";
				} else {
					sciGrade = "D";
				} // 과학등급 if문 종료

				System.out.println("국어" + korGrade + "등급");
				System.out.println("수학" + matGrade + "등급");
				System.out.println("영어" + engGrade + "등급");
				System.out.println("과학" + sciGrade + "등급");
				run = false;
				System.out.println("=========");
				System.out.println("나가기 (0)");
				System.out.println(">>>>");
				i = inputInt.nextInt();
				if (i == 0) {
					run = true;
				} else {
					System.out.println("잘못입력하셨습니다.");
				}
				break;

			case 4: 
				System.out.println("=============");
				System.out.println("  프로그램 종료  ");
				System.out.println("=============");
				run = false;
				break;

			default :
				System.out.println("다시 입력해주세요.");
				break;
			} // switch문 종료

		} // while문 종료

	}// main 메소드 종료

}// class 종료
