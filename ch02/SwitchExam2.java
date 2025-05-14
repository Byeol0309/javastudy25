package ch02;

import java.util.Scanner;

public class SwitchExam2 {

	public static void main(String[] args) {
		
		System.out.println("당신의 주민등록번호를 입력하세요(1제외)");
		System.out.print(">>>");
		Scanner in = new Scanner(System.in);
		String regNo = in.nextLine();
		char gender = regNo.charAt(6); // 7번째 글자 추출
		//System.out.println(gender);
		
		switch (gender) {
		case '1' : case '3' : case '5' : case '7' :
			System.out.println("당신은 남자입니다.");
			break;
		case '2' : case '4' : case '6' : case '8' :
			System.out.println("당신은 여자입니다");
			break;
		default :
			System.out.println("당신은 외계인입니다.");
		}
	
	} // main 매서드 종료

} // class 종료
