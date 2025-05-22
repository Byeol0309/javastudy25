package ch02;

import java.util.Scanner;

public class ExSwitchExam {

	public static void main(String[] args) {
		// 새로운 메서드를 생성하여 성적처리프로그램을 개선해보기.
		// 메인 메서드에는 주메뉴를 구현
		// 사용자 지정 메서드는 부메뉴 구현
		
		Scanner inputInt = new Scanner(System.in);
		boolean run = true ;
		String id = "hello";
		String pw = "1234" ;
		boolean session = false ; // 로그인 상태 저장용
		
		while (run) {
			System.out.println("===========================");
			System.out.println("    1. 로그인 ");
			System.out.println("    2. 성적 관리 ");
			System.out.println("    3. 학생 관리");
			System.out.println("    4. 근태 관리");
			System.out.println("    0. 프로그램종료");
			System.out.print(">>>");
			int select = inputInt.nextInt();
			System.out.println("===========================");
			
			switch(select) {
			case 1:
				System.out.println("로그인 메뉴로 이동합니다.");
				session = loginOk(id, pw, session); // loginOK 메서드에 id, pw, session변수를 넘길것임.
				
				if (session = true) {
					System.out.println("==========로그인 완료=========");
					System.out.println("아이디" + id + "로그인 되셨습니다.");
					System.out.println("===========================");
				}
				break;
			case 2:
				System.out.println("     성적 관리");
				System.out.println("1. 성적 입력");
				System.out.println("2. 성적 확인");
				System.out.println("3. 나가기");
				break;
				
			case 3:
				System.out.println("     학생 관리");
				break;
				
			case 4:
				System.out.println("     근태 관리");
				break;
				
			case 0:
				System.out.println("     프로그램종료");
				break;
			
			} //switch문 종료
		}
		

	}//main메소드 종료

	static boolean loginOk(String id, String pw, boolean session) {
		// 로그인 여부를 결정하는 메서드
		// 키보드로 id, pw 받아서 검증.
		Scanner inputLogin = new Scanner(System.in);
		System.out.println("===================");
		System.out.print("   id :");
		String inputId = inputLogin.next(); // 키보드로 id 입력
		System.out.println("===================");
		System.out.print("   pw :");
		String inputPw = inputLogin.next(); // 키보드로 pw 입력
		System.out.println("===================");
		
		if(id.equals(inputId) && pw.equals(inputPw)) {
			System.out.println("********"+ id +" 님********");
			session = true ; 
		} else {
			System.out.println("id와 pw를 확인해주세요.");
			System.out.println("******로그인 실패******");
			session = false ; 
		}// id.pw 판단 if-else문종료
		return session; //로그인 성공과 실패 결과를 리턴함.
		
	} //login메서드종료

}//class 종료
