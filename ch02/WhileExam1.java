package ch02;

import java.util.Scanner;

public class WhileExam1 {

	public static void main(String[] args) {
		// while문은 조건식이 true 일때만 반복한다.
		// while문을 종료하고싶으면 false 처리를 한다.
		// 무한 반복용 코드를 작성할때 사용한다.
		Scanner inputInt = new Scanner(System.in); // 정수용
		Scanner inputChar = new Scanner(System.in); // 문자용
		boolean run = true ; // 무한반복용 변수
		
		while(run) {
			System.out.println("===엠비씨성적관리===");
			System.out.println(" 1. 교직원 관리 ");
			System.out.println(" 2. 학생  관리 ");
			System.out.println(" 3. 성적  관리 ");
			System.out.println(" 9. 프로그램 종료 ");
			System.out.print("(1~9)>>>");
			int selectInt = inputInt.nextInt(); //숫자입력
			
			switch (selectInt) { //키보드로 입력받은 숫자를 판단하여 분기 결정.
			case 1 : // create생성 read읽기 update수정 delete삭제 기법
				boolean subRun = true ;
				while (subRun) {
					System.out.println("==교직원 관리 메뉴로 진입==");
					System.out.println("a. 교직원 등록"); //c
					System.out.println("b. 교직원 보기"); //r
					System.out.println("c. 교직원 수정"); //u
					System.out.println("d. 교직원 삭제"); //d
					System.out.println("z. 교직원 관리 메뉴 종료");
					char subSelect = inputChar.next().charAt(0);
					//문자열로 입력된 값 중에 맨앞 문자만 subSelect변수에 넣음.
					//위에서 입력받은 알파벳을 처리
					
					switch(subSelect) {
					case 'A' :
					case 'a' :
						System.out.println("교직원 등록 메뉴로 진입하셨습니다.");
						// 교직원 등록 코드 작성
					break;
					
					case 'B' :
					case 'b' :
						System.out.println("교직원 보기 메뉴로 진입하셨습니다.");
						// 교직원 보기 코드 작성
					break;
					
					case 'C' :
					case 'c' :
						System.out.println("교직원 수정 메뉴로 진입하셨습니다.");
						// 교직원 수정 코드 작성
					break;
					
					case 'D' :
					case 'd' :
						System.out.println("교직원 삭제 메뉴로 진입하셨습니다.");
						// 교직원 삭제 코드 작성
					break;
					
					case 'Z' :
					case 'z' :
						System.out.println("교직원 메뉴를 종료합니다..");
						// 교직원 종료 코드 작성
					subRun = false ; // 교직원 메뉴 종료
					break;
					
					default :
						System.out.println("다시 입력해주세요.");
						break;

					}//교직원 관리 switch문 종료
					
				} // 교직원 관리용 코드 입력
			case 2 :
				System.out.println("==학생 관리 메뉴로 진입==");
				break; 
				
			case 3 :
				System.out.println("==성적 관리 메뉴로 진입==");
				break; 
				
			case 9 :
				System.out.println("===프로그램 종료===");
				//프로그램 종료코드입력
				run = false ; 
				break; 
			default : // 위조건에 해당되지 않는 값
				System.out.println("1~3까지 입력바랍니다.");
			} // switch문 종료
			

		} // while문 종료
		

	} // main 매서드 종료

} // class종료
