package mbcboard;

import java.sql.SQLException;
import java.util.Scanner;

import mbcboard.service.BoardService;
import mbcmember.dto.MemberDTO;
import mbcmember.service.MemberService;

public class BoardExam {
	// 2025.06.10
	// java, Oracle JDBC를 활용하여 게시판을 구현해보자.
	// 2025.06.12 
	// memberDTO, memberDAO와 연동하여 회원용 게시판으로 구현해보자.
	//필드
	public static Scanner inputStr = new Scanner(System.in);
	public static MemberDTO loginSession = null;
	//public static MemberDTO session = new MemberDTO();
	//생성자 -> static블럭
	
	

	//메서드
	public static void main(String[] args) throws SQLException {
		// mbc게시판용 jdbc테스트
		// dto : 객체를 담당한다.
		// dao : 데이터베이스에서 연동을 담당한다.
		// service : 부메뉴와 서비스를 담당한다.
		
		boolean run = true;
		
		while (run) {
			System.out.println("MBC 자유 게시판입니다.");
			System.out.println("1. 회원");
			System.out.println("2. 게시판");
			System.out.println("3. 종료");
			System.out.print(">>>");
			String select = inputStr.next();
			
			switch(select) {
			case "1" :
				System.out.println("회원용 서비스로 진입합니다.");
				MemberService memberService = new MemberService();
				MemberDTO session = new MemberDTO();
				loginSession = memberService.subMenu(loginSession,inputStr); // MemberService객체(부메뉴용)의 subMenu메서드 호출
				break;
			
			case "2" :
				System.out.println("게시판 서비스로 진입합니다.");
				BoardService boardService = new BoardService();
				//BoardService타입의 boardService 객체를 생성하였다.
				
				loginSession= boardService.subMenu(loginSession, inputStr); // boardService객체(부메뉴용)의 subMenu메서드 호출
				break;
				
			case "3" :
				System.out.println("자유게시판 프로그램 종료합니다.");
				break;
				
			default :
				System.out.println("1~3까지만 입력 바랍니다.");
				break;
			
			} //switch문 종료
			
			
		}
		
		
		

	}

}
