package ch02;

import java.util.Scanner;

public class IfExam {

	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		
		System.out.println("성적 확인 시스템입니다.");
		System.out.println("성함을 입력해주세요.");
		System.out.print(">>>");
		String name = input.next(); // 입력값을 변수 name에 넣는다.
		
		System.out.println("국어성적을 입력해주세요.");
		System.out.print(">>>");
		int kor = input.nextInt();
		
		System.out.println("수학성적을 입력해주세요.");
		System.out.print(">>>");
		int math = input.nextInt();
		
		System.out.println("영어성적을 입력해주세요.");
		System.out.print(">>>");
		int eng = input.nextInt();
		
		System.out.println("성적을 확인하시려면" + " YES");
		System.out.println("평점을 원하시면" + " NO");
		System.out.println("입력해주세요>>>");
		String agreed = input.next();
		
		if (agreed.equalsIgnoreCase("yes")) {
			System.out.println(name + "의 성적의 총합은 " + (kor + math + eng)+"입니다." );
		} else if (agreed.equalsIgnoreCase("no")) {
			System.out.println(name + "의 성적 평균은 " + ((kor + math + eng)/3) + "입니다.");
		} else {
			System.out.println("잘못입력하셨습니다.");
		} // else문 종료
		

	} // main매서드 종료

} // class종료
