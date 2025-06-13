package memberTest.service;

import java.sql.SQLException;
import java.util.Scanner;

import memberTest.dao.MemberDAO;
import memberTest.dto.MemberDTO;

public class MemberService {
	// 필드
	MemberDTO memberDTO = new MemberDTO();
	MemberDAO memberDAO = new MemberDAO();

	public MemberDTO subMenu(MemberDTO loginSession, Scanner inputStr) throws SQLException {
		boolean subRun = true;
		while (subRun) {
			System.out.println("회원용 서비스 입니다");
			System.out.println("==================");
			System.out.println("1 : 회원가입");
			System.out.println("2 : 로그인");
			System.out.println("3 : 정보조회");
			System.out.println("4 : 정보수정");
			System.out.println("5 : 회원탈퇴");
			System.out.println("6 : 로그아웃");
			System.out.println("7 : 나가기");
			System.out.print(">>>");
			String subSelect = inputStr.next();
			switch (subSelect) {
			case "1":
				System.out.println("==================\n\t회원\n\t가입\n==================");
				memberAdd(loginSession,memberDAO, inputStr);
				break;
			case "2":
				System.out.println("==================\n\t로그인\n\t페이지\n==================");
				loginSession = memberLogin(loginSession,memberDAO,inputStr);
				break;
			case "3":
				System.out.println("==================\n\t정보조회\n\t페이지\n==================");
				readAll(loginSession,memberDAO,inputStr);
				break;
			case "4":
				System.out.println("==================\n\t정보수정\n\t페이지\n==================");
				loginSession = update(loginSession,memberDAO,inputStr);
				break;
				
			case "5":
				System.out.println("==================\n\t회원탈퇴\n\t페이지\n==================");
				loginSession = softDelete(loginSession, memberDAO);
				break;
			case "6":
				System.out.println("==================\n\t로그\n\t아웃\n==================");
				loginSession = logout(loginSession);
				break;
			case "7":
				System.out.println("==================\n\t이전\n\t페이지\n==================");
				subRun = false;
				break;
			case "7777":
				System.out.println("==================\n\t관리자\n\t페이지\n==================");
				loginSession = adminPage(loginSession, memberDAO, inputStr);

				break;
			default:
				System.out.println("잘못입력하셨습니다");
				break;

			}

		}

		return loginSession;
	} // subMenu()메서드 종료

	private MemberDTO adminPage(MemberDTO loginSession, MemberDAO memberDAO, Scanner inputStr ) throws SQLException {
		// 관리자용 메서드
		boolean proveAdmin = false ;
		boolean prove = false;
		proveAdmin = proveAdmin(loginSession);
		while (proveAdmin) {
			System.out.println("1. 회원정보");
			System.out.println("2. 회원정보수정"); // 관리자용 정보수정
			System.out.println("3. 회원삭제");
			System.out.println("4. 나가기");
			System.out.print(" : ");
			String select = inputStr.next();
			System.out.println("===================");
			switch (select) {
			case "1" :
				System.out.println("");
				memberDAO.readAll();
				break; 
				
			case "2" :
				memberDAO.updateAll(inputStr);
				break; 
				
			case "3" :
				MemberDTO memberDTO = new MemberDTO();
				System.out.println("삭제하실 회원님의 \n  ID를 입력해주세요");
				System.out.print("ID : ");
				String inputId = inputStr.next();
						prove = memberDAO.verificationId(inputId);
				if (prove != false) {
					memberDTO.setId(inputId);
					memberDAO.delete(memberDTO);
				}
				proveAdmin = false;
				break; 
			case "4" :
				proveAdmin = false; 
				break; 
			default :
				
				break; 
			}
		}
		return loginSession;
		
	} //adminPage
	
		
	private MemberDTO softDelete(MemberDTO loginSession, MemberDAO memberDAO) throws SQLException {
		// 회원용 탈퇴메서드
		boolean session = false;
		session = session(loginSession);
		while (session) {
			System.out.println("회원탈퇴메서드");
			memberDTO = memberDAO.softDelete(loginSession);
			
			//loginSession = memberDAO.delete(loginSession); -- 진짜로 데이터 삭제 관리자용에 넣어보기
			session = false;
		}
		
		return loginSession;
	} //softDelete()메서드종료

	

	private MemberDTO update(MemberDTO loginSession, MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		// 회원정보수정메서드
		boolean session = false; 
		session = session(loginSession);
		String values = null ;
		String modifyStr = null ;
		
		while (session) {
			System.out.println(loginSession.getId() + "님 정보수정 페이지입니다.");
			System.out.println(" 1. 이름변경\n 2. PW변경 \n 3. Email변경");
			System.out.print(">>>");
			String select = inputStr.next();
			
			switch(select) {
			case "1" :
				values = "mname" ;
				System.out.print("변경 내용을 입력해주세요 \n :");
				modifyStr = inputStr.next();
				loginSession = memberDAO.updateOne(loginSession, values, modifyStr);
				session = false;
				break ;
				
			case "2" :
				values = "pw" ;
				System.out.print("변경 내용을 입력해주세요 \n :");
				modifyStr = inputStr.next();
				loginSession = memberDAO.updateOne(loginSession, values, modifyStr);
				session = false;
				break ;
				
			case "3" :
				values = "memail" ;
				System.out.print("변경 내용을 입력해주세요 \n :");
				modifyStr = inputStr.next();
				loginSession = memberDAO.updateOne(loginSession, values, modifyStr);
				session = false;
				break ;
				
			case "77":
				System.out.println("관리자용 페이지입니다");
				session = false;
				break ;
				
			default :
				System.out.println("잘못입력하셨습니다 \n 이름, PW, Email만 변경하실 수 있습니다");
				session = false;
				break ;
			
			}
		}
		
		return loginSession;
		
	} //update()메서드종료

	

	

	private void readAll(MemberDTO loginSession, MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		// 정보조회 메서드
		boolean session = false ;
	
		session = session(loginSession); // 로그인상태확인용메서드
		while (session) { 
			System.out.println(" 정보를 조회합니다");
			System.out.println("===================");
			System.out.println(" 회원 \t 정보");
			memberDAO.selectAll(loginSession);
			session = false ;
		} //while문종료
		
	} // readAll()메서드종료

	

	private MemberDTO memberLogin(MemberDTO loginSession, MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		// 로그인메서드
		// id 검증 메서드에서 일치하는 id가 있을시(T반환), -> pw입력 pw검증메서드에서 일치하는 pw가 있을 시 T반환 
		// loginSession에 값넣기.
		boolean proveId = true ; 
		boolean provePw = false ;
		MemberDTO memberDTO = new MemberDTO();
		if ( loginSession != null ) {
			System.out.println("현재 로그인 상태입니다");
			System.out.println("===================");
			proveId = false ;
		}
		while (proveId) {
			// id일치시 proveId에 True반환 실행 
			System.out.println("ID : ");
			String inputId = inputStr.next();
			proveId = memberDAO.verificationId(inputId);
			if (proveId != false) { memberDTO.setId(inputId); }
			
			while (proveId) {
				// id 일치시 proveId에 True반환 실행
				// id 불일치시 proveId False반환 중지
				System.out.println("PW : ");
				String inputPw = inputStr.next();
				String loginId = memberDTO.getId();
				provePw = memberDAO.verificationPw(loginId, inputPw);
				proveId = false ; // id입력 while문 종료
				
				if (provePw != false) {
					
					memberDTO.setId(loginId);
					memberDTO.setPw(inputPw);
					//id,pw 일치시 loginSession에 데이터 반환받는다.
					loginSession = memberDAO.memberLogin(memberDTO);
					if (loginSession != null) {
						System.out.println( loginSession.getId()+" 님 로그인 되셨습니다.");
						
					}
				}
				
			} // proveId while문
			
		}
		
		
		return loginSession;
	}

	private void memberAdd(MemberDTO loginSession, MemberDAO memberDAO, Scanner inputStr) throws SQLException {
		// 회원가입용메서드
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
				//중복id가 없을때 실행
				System.out.println("==================\n\t가입정보를\n\t입력해주세요\n==================");
				System.out.print("ID : ");
				memberDTO.setId(inputStr.next());
				System.out.print("PW : ");
				memberDTO.setPw(inputStr.next());
				System.out.print("이름 : ");
				memberDTO.setMname(inputStr.next());
				System.out.print("Email : ");
				memberDTO.setMemail(inputStr.next());
				memberDTO.setUse_yn("Y");
				memberDTO.setAdmin("N");
				memberDAO.memberAdd(memberDTO);
				run= false ;
				
			} else if (prove = true) {
				run = false ;
				System.out.println("중복되는 아이디가 있습니다");
			}
		} // while문 종료
		
	} // memberAdd()메서드종료
	
	
	private boolean session(MemberDTO loginSession) {
		if(loginSession == null) {
			System.out.println("\t로그인 후\n\t이용해주세요\n===================");
			return false ;
		}
		
		return true ;
	} // session메서드종료
	
	private boolean proveAdmin(MemberDTO loginSession) {
		boolean session = false ; 
		session = session(loginSession) ;
		while (session) {
		String ad = "Y" ;
		if(loginSession.getAdmin() == ad) {
			System.out.println("관리자 모드");
			System.out.println("==================");
			return true ;
		}
		} // while문종료
		return false ;
	} // session메서드종료
	
	
	
	private MemberDTO logout(MemberDTO loginSession) {
		// 로그아웃 메서드
		boolean session = false ; 
		session = session(loginSession);
		while (session) {
			System.out.println("로그아웃되었습니다");
			loginSession = null;
			session = false;
		}
		
		
		return loginSession;
	} // logout()메서드종료
	
	

} // class종료
