package mbcmember.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import mbcmember.dao.MemberDAO;
import mbcmember.dto.MemberDTO;

public class MemberService {
	// 2025.06.11
	// dao와 dto를 사용하여 member의 memberService 부메뉴와 CRUD를 처리한다.
	// 2025.06.12 
	// 탈퇴메서드를 제외한 CRU 완료. (D 추가해야함.)
	
	// 필드
	public MemberDAO memberDAO = new MemberDAO(); // MemberDAO의 기본생성자에서 JDBC의 1단계, 2단계를 수행한다.
	public MemberDTO memberDTO = new MemberDTO();
	
	// 메서드 (CRUD 부메뉴)
	public MemberDTO subMenu(MemberDTO loginSession, Scanner inputStr) throws SQLException {
		// C : 회원가입
		// R : 내정보보기
		//	 : 내가 쓴 게시글 보기
		// U : 정보수정하기
		// D : 정보삭제하기 
		
		boolean subRun = true;
		while (subRun) {
			System.out.println("MBC아카데미 회원 서비스 입니다.");
			System.out.println("1. 회원가입 ");
			System.out.println("2. 로그인 ");
			System.out.println("3. 로그아웃 ");
			System.out.println("4. 내정보보기 ");
			System.out.println("5. 내정보수정");
			System.out.println("6. 회원탈퇴");
			System.out.println("7. 나가기");
			System.out.print(">>>");
			String subSelect = inputStr.next();
			
			switch(subSelect) {
			case "1" :
				System.out.println("======================\n\t회원\n\t가입\n======================");
				// MemberDAO.호출
				// insert into member (mno, bwriter, id, pw, regidate) values(board_seq.nextvla, '','',)
				memberAdd(memberDAO,inputStr);
				break ;
			case "2" :
				System.out.println("======================\n\t로그인\n\t페이지\n======================");
				// select id, pw from member where id = '' And pw = '' ;
				loginSession = memberLogin(loginSession,memberDAO,inputStr);
				
				break ;
				
			case "3" :
				System.out.println("======================\n\t로그아웃\n\t페이지\n======================");
				loginSession = logout(loginSession,memberDAO);
				break ;
				
			case "4" :
				System.out.println("======================\n\t내정보\n\t페이지\n======================");
				loginPage(loginSession,memberDAO);
				break ;
			case "5" :
				System.out.println("======================\n\t정보수정\n\t페이지\n======================");
				loginSession = remove(loginSession,memberDAO,inputStr);
				break ;
			case "6" :
				System.out.println("======================\n\t회원탈퇴\n\t페이지\n======================");
				loginSession = deleteAccount(loginSession,memberDAO);
				break ;
			case "7" :
				System.out.println("======================\n\t회원페이지를\n\t종료합니다\n======================");
				subRun = false;
				break ;
				
			} // switch문 종료
			
		} // while문종료
		
		return loginSession;
		
		
	} // member subMenu()종료



	private MemberDTO logout(MemberDTO loginSession, MemberDAO memberDAO) {
		boolean run = false ;
		 run = session(loginSession);
		while (run) {
			System.out.println("로그아웃되었습니다.");
			loginSession = null;
			run = false;
		}
		
		return loginSession;
	} // logout()메서드종료



	private MemberDTO deleteAccount(MemberDTO loginSession, MemberDAO memberDAO) {
		boolean run = false ;
		 run = session(loginSession);
		while (run) {
			System.out.println("회원탈퇴 페이지입니다.");
		}
		return loginSession;
		
		
	} // deleteAccount () 회원탈퇴 메서드



	private MemberDTO remove(MemberDTO loginSession, MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		boolean run = false ;
		String input = null;
		String reBwriter = null ;
		String rePw = null;
		
		 run = session(loginSession);
		while (run) {
			System.out.println(loginSession.getId() + "님 정보수정 페이지입니다.");
		System.out.println("1. 이름변경\n 2. PW변경");
		System.out.print(">>>");
		String select = inputStr.next();
		System.out.println("======================");
		switch (select) {
		case "1" :
			input = "bwriter";
			System.out.print("변경 내용을 입력해주세요 \n :");
			reBwriter = inputStr.next();
			loginSession = memberDAO.remove(loginSession, memberDAO, input, reBwriter);
			System.out.println("======================");
			run = false ;
			break ;
		
		case "2" :
			input = "pw";
			System.out.print("변경 내용을 입력해주세요 \n :");
			rePw = inputStr.next();
			loginSession = memberDAO.remove(loginSession, memberDAO, input, rePw);
			System.out.println("======================");
			run = false ;
			break ; 
		
		default :
			System.out.println("이름과 PW만 변경이 가능합니다.");
			break;
		}
			
		}
		
		
		return loginSession;
		// 정보수정메서드
		
	} //remove() 메서드



	private void loginPage(MemberDTO loginSession, MemberDAO memberDAO) throws SQLException {
		// 내정보페이지 readOne
		boolean run = true ;
		while (run) {
			if(loginSession == null) {
				System.out.println("\t로그인 후\n\t이용해주세요\n======================"); // boolean 타입을 리턴하는 session() 생성하여 재활용하겠다.
				run= false ; 
			}else{
				memberDAO.readOne(loginSession, memberDAO);
				run = false ;
			}
		}
	} //loginPage () 메서드 종료



	private MemberDTO memberLogin(MemberDTO loginSession, MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		// 로그인메서드
		// id 검증 메서드에서 일치하는 id가 있을시(T반환), -> T : pw입력 pw검증메서드에서 일치한s pw가 있을 시 T반환 
		// loginSession에 값넣기.
		boolean proveId = true ;
		boolean provePw = false ;
		MemberDTO memberDTO = new MemberDTO();
		if(loginSession != null ) {
			System.out.println("현재 로그인 상태입니다");
			System.out.println("======================");
			proveId = false;
		}
		
		while (proveId) {
			System.out.print("ID : ");
			String inputId = inputStr.next();
			proveId = memberDAO.verificationId(inputId);
			
			memberDTO.setId(inputId);
			
			while(proveId) {
				// id 일치시 true -> while문 실행
			System.out.println("확인용 : "+memberDTO.getId());
			System.out.println("PW : ");
			String inputPw = inputStr.next();
			String loginId = memberDTO.getId();
			
			provePw =memberDAO.verificationPw(loginId, inputPw);
			proveId = false ; // while문종료
			
			if (provePw != false) {
				// proveId T, provePw
				memberDTO.setId(inputId);
				memberDTO.setPw(inputPw);
				//System.out.println("확인용 : "+memberDTO.getId());
				//System.out.println("확인용 : "+memberDTO.getPw());
				
				loginSession = memberDAO.memberLogin(memberDTO); //DAO 로그인메서드호출
				System.out.println("======================");
				System.out.println(loginSession.getBwriter() + "님 환영합니다.");
				System.out.println("로그인 성공!");
			}
				} // while
			}// while
		
		return loginSession;
			
	} // memberLogin ()



	private void memberAdd(MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		// 1. MemberDTO 객체생성
		// 2. MemberDTO에 입력값넣기
		// 3. MemberDTO 객체를 MemberDAO.memberAdd 매개변수로 반환하기
		MemberDTO memberDTO = new MemberDTO();
		boolean prove = false ;
		boolean run = true ;
		
		while(run) {
			
		System.out.println("가입하실 회원님의 \n 정보를 입력해주세요");
		System.out.print("ID : ");
		String inputId = inputStr.next();
		prove = memberDAO.verificationId(inputId);
		// DB에 입력한 ID와 일치하는 값이 존재하면 T를 반환한다. / 존재하지 않으면 F를 반환한다.
		
		if (prove != true) {
			System.out.println("======================");
			System.out.print("ID : ");
			memberDTO.setId(inputStr.next());
			System.out.print("PW : ");
			memberDTO.setPw(inputStr.next());
			System.out.print("이름 : ");
			memberDTO.setBwriter(inputStr.next());
			
			memberDAO.memberAdd(memberDTO);
			run = false ;
		} else if(prove = true ) {
			run = false;
			System.out.println("중복되는 아이디가 있습니다.");
		}
		}
	} // memberAdd() 회원가입메서드 종료
	
	private boolean session(MemberDTO loginSession)  {
			if(loginSession == null) {
				System.out.println("\t로그인 후\n\t이용해주세요\n======================");
				return false ;
			} 	
		return true;
	} //loginPage () 메서드 종료
	
		
		
	
} // memberService 부메뉴 class종료