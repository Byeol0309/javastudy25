package ch05.marioKart_v2.sericve;

import java.util.Scanner;

import ch05.marioKart_v2.dto.MemberDTO;

public class MemberSerivceV2 {
		// 2025.05.26 (월)
		// DTO에 getter_setter를 적용해보자.
	    // 회원관리용 클래스로 CRUD@까지 제공
		// 부메뉴용
		
		// 필드
		private int temLoginNum = 0 ; // 로그인되어있는 memberDTOs배열의 index 번호를 담기 위한 변수
		private int modifyCount = 0 ; // 입력한 정보값이 틀렸을경우 count하는 변수
		private String inputId = "" ;
		private int temCreateNum = 0 ; // 회원가입된 index번호를 담기 위한 변수
		// 생성자
		
		
		
		// 메서드
		// 부메뉴용 메서드 -> 필요한 파라미터 (입력객체, 회원배열, 로그인 상태)
		public MemberDTO menu(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
			System.out.println("     ◎M◎A◎R◎I◎O◎\n ○*K*A*R*T*○");
			boolean subrun = true ; 
			while (subrun) {
				System.out.println(" -----------");
				System.out.println("| 1. 가입    \n| 2. 로그인   \n| 3. 정보수정 \n| 4. 탈퇴    \n| 5. 메인  ");
				System.out.println(" -----------");
				System.out.print(">>>");
				String select = input.next();
				switch(select) {
				case "1" :
					create(input, memberDTOs);
				break ;
				case "2" :
					loginState = login(input, memberDTOs, loginState);
					return loginState ;
				case "3" :
					if (loginState == null) {
						System.out.println("로그인 후 이용이 가능합니다");
					} else {
					System.out.println("계정을 수정합니다.");
					loginState = modify(input, memberDTOs, loginState);
					return loginState ;
					}
					break;
				case "4" :
					if (loginState == null) {
						System.out.println("로그인 후 이용이 가능합니다");
					} else {
					System.out.println("계정을 삭제하시면 복구가 불가합니다.");
					loginState = delete(input, memberDTOs, loginState);
					return loginState ;
					}
					break ;
				case "5" :
					System.out.println(" ◎ ◎ M A I N  \n  P A G E ◎ ◎");
					subrun = false ;
					return loginState;
				case "99" :
					System.out.println("히든 메뉴를 진입하였습니다.");
					System.out.println("캐릭터 해킹을 진행합니다.");
					break ;
				default :
					System.out.println("1~5사이 값만 허용합니다.");
					break ;
				
				} // switch문 종료
			} // while문 종료
			loginState = delete(input, memberDTOs, loginState); 
			// delete에서 수정된 loginState변수값을 main으로 return하기위해 넣음.
			// loginState가 null일때 오류 (if문을 사용하여 다른값도 넘겨주어야함.)
			
			loginState = modify (input, memberDTOs, loginState);
			return loginState; 
			
		} // menu 메서드 종료

		public MemberDTO delete(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
			// 계정 탈퇴 메서드 생성
			
			return loginState;
			
		} // delete 계정삭제메서드 종료

		public MemberDTO modify(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
			// 계정 수정 메서드
			
			return loginState;
			
		}//modify 계정삭제메서드 종료

			
		
		public MemberDTO[] create(Scanner input, MemberDTO[] memberDTOs) {
			//회원가입용 메서드
		
			return memberDTOs ;
		} //create 메서드 종료
		

		public MemberDTO login(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
			// 로그인용 메서드
			
			return loginState; // 로그인 성공 객체를 리턴함
			
		}
		
		
	} // class종료

