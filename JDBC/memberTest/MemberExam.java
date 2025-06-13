package memberTest;

import java.sql.SQLException;
import java.util.Scanner;

import memberTest.dto.MemberDTO;
import memberTest.service.MemberService;

public class MemberExam {
	// 2025.06.13 JDBC memberTest
	// 필드
	public static Scanner inputStr = new Scanner(System.in);
	public static MemberDTO loginSession = null;

	// 생성자
	
	// 메서드
	public static void main(String[] args) throws SQLException{
		boolean run = true ; 
		
		while (run) {
			System.out.println("===================");
			System.out.println(" MBC 회원용 자유 게시판 ");
			System.out.println("===================");
			System.out.println(" 1 : 회원 \n 2 : 게시판");
			System.out.print("   : ");
			String select = inputStr.next();
			
			switch(select) {
			case "1" :
				System.out.println("===================");
				System.out.println("회원용 서비스로 진입합니다");
				MemberService memberService = new MemberService();
				loginSession = memberService.subMenu(loginSession, inputStr);
				break ;
			case "2" :
				System.out.println("===================");
				System.out.println("게시판 서비스로 진입합니다");
				break ;
			default :
				System.out.println("1또는 2버튼을 눌러주세요");
				break ;
			}
			
		} // while문종료
		
		

	} // main메서드 종료

} // class 종료
