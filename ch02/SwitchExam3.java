package ch02;

import java.util.Scanner;

public class SwitchExam3 {

	public static void main(String[] args) {
		// switch문을 활용한 영화요금
		int day =(int)(Math.random()*6)+1 ;
		System.out.println("영화 관람표 금액 확인을 위하여");
		System.out.print("나이를 입력해주세요>>>");
		Scanner in = new Scanner(System.in);
		int age = in.nextInt();
		
		String ageGroup = "" ;
		
		if ( age > 60 ) {
			ageGroup = "시니어" ;
			System.out.println(ageGroup + "입니다");
		} else if ( age >= 20 && age <= 60) {
			ageGroup = "성인" ;
			System.out.println(ageGroup + "입니다");
		} else if ( age >= 8 && age <= 19 ) {
			ageGroup = "청소년" ;
		} else if ( age > 0 && age < 8 ) {
			ageGroup = "어린이" ;
		} // ageGroup if문 종료
		
		switch (ageGroup) {
		case "시니어" :
			System.out.println(ageGroup + "금액은 7000원 입니다.");
		break;
		case "성인" :
			System.out.println(ageGroup + "금액은 15000원 입니다.");
		break;
		case "청소년" :
			System.out.println(ageGroup + "금액은 12000원 입니다.");
		break;
		case "어린이" :
			System.out.println(ageGroup + "금액은 7000원 입니다.");
		break ;
		default :
			System.out.println("다시 입력해주세요.");
		break ;
		} // switch문 종료
		
		switch (day) {
		case 1 :
			System.out.println("====할인쿠폰====");
			System.out.println("월요일 1000원 할인");
			System.out.println("===============");
		break;
		case 6 : case 7 :
			System.out.println("==스페셜 할인 쿠폰==");
			System.out.println(" 주말 관람 1 + 1 ");
			System.out.println("===============");
		break;
		}

	} // main 매서드 종료

} // class 종료
