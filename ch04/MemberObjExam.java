package ch04;

import java.util.Scanner;

public class MemberObjExam {

	public static void main(String[] args) {
		// 2025.05.21
		// Member클래스를 호출하여 회원관리프로그램을 처리해보기 
		//
		// 
		Scanner input = new Scanner(System.in);
		Member[] members = null ; 
	//  Member타입의 members 배열 
		
		System.out.println("가입할 회원수를 입력하세요.");
		System.out.println(">>>");
		int count = input.nextInt();
		members = new Member[count] ; // 키보드로 입력받은 숫자(count)만큼 배열을 생성한다. 
		
		System.out.println("회원가입 프로그램을 시작합니다.");
		boolean run = true ; 
		while(run) {
			System.out.println("1. 회원가입");
			System.out.println("2. 회원전체보기");
			System.out.println("3. 로그인");
			System.out.println("4. 회원수정");
			System.out.println("5. 회원탈퇴");
			System.out.println("1~5 까지만 입력하세요 (다른키가 눌리면 꺼집니다)");
			System.out.print(">>>");
			int select = input.nextInt();
			switch(select) {
			case 1: 
				Member member1 = new Member();  //  member1 객체 생성
				for (int i = 0 ; i < members.length ; i++) {
					member1 = member1.memberAdd(input);  //  member1.memberAdd 
					members[i] = member1 ;               //		 	 메서드 호출 및 실행.
				} //for문 종료
				break;
				
			case 2:
				Member member2 = new Member(); // member2 객체 생성
				member2.memberAllList(members); // memberAllList(전체보기) 메서드 호출 및 실행
				break;
				
			case 3:
				Member member3 = new Member(); //member3 객체 생성
				member3.memberLogin(members); // memberLogin(로그인) 메서드 호출 및 실행
				break;
				
			case 4:
				Member member4 = new Member(); //member4 객체 생성
				member4.memberUpdate(members); // memberUpdate(회원수정) 메서드 호출 및 실행
				break;
				
			case 5:
				Member member5 = new Member(); //member5 객체 생성
				member5.memberDelete(); // memberDelete(회원삭제) 메서드 호출 및 실행
				break;
				
			default :
				System.out.println("프로그램을 종료합니다.");
				run = false; 
			
			} //switch문 종료

		} //while문 종료

	} // main메서드 종료

} // class종료
