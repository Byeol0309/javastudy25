package ch04.marioKart.serivce;

import java.util.Calendar;
import java.util.Scanner;

import ch04.marioKart.dto.MemberDTO;

public class MemberSerivce {
	// 회원관리용 클래스로 CRUD@까지 제공
	// 부메뉴용
	
	// 필드
	public int temLoginNum = 0 ; // 로그인되어있는 memberDTOs배열의 index 번호를 담기 위한 변수
	public int modifyCount = 0 ; // 입력한 정보값이 틀렸을경우 count하는 변수
	public String inputId = "" ;
	public int temCreateNum = 0 ; // 회원가입된 index번호를 담기 위한 변수
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
		// return을 마지막에 한번만 해도 되지만, 그전에 어떤 값을 리턴할지 정확히 구성해놔야한다.
		
	} // menu 메서드 종료

	public MemberDTO delete(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		// 계정 탈퇴 메서드 생성
		//System.out.println(loginState.nickName + "님. 정말 마리오 카트를 떠나실건가요?");
		// 아래에서 loginState를 null 처리하면, 
		// return값이 위로 올라오면서 오류가남.
		// null 값을 return할때는, 메서드에서 삭제된 변수값을 사용하지 말아야겠음.
		
		
		System.out.println("정말 마리오를 떠나실건가요 ?");
		System.out.println("1. 회원 탈퇴");
		System.out.println("");
		System.out.println("0. 마리오 카트와 함께하기");
		System.out.print(">>>");
		String select = input.next();
		switch (select) {
		case "1" :
			System.out.println("*************************");
			System.out.println("         T____T ");
			System.out.println("*************************");
			System.out.println(loginState.id + "의 정보가 삭제됩니다.");
			System.out.println(loginState.nickName+"님과의 추억을 잊지 않을게요!");
			 temLoginNum = loginState.loginNum ;
			memberDTOs[temLoginNum] = null; 
			loginState = null ; 
			return loginState ;
		
		case "0" :
			System.out.println("*************************");
			System.out.println( "오늘도 마리오와 함께 달려보아요 !");
			System.out.println("*************************");
		break ; 
		
		default :
			System.out.println("1번 또는 0번을 눌러주세요.");
		break ;
		} //switch문 종료
		
		return loginState;
		
	} // delete 계정삭제메서드 종료

	public MemberDTO modify(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		// 계정 수정 메서드
		boolean run = true ; 

		if (loginState.loginComplete >= 3 ) {
			run = false ;
			System.out.println("비밀번호를 3회 이상 틀리셨습니다.");
			System.out.println(loginState.email+"로 인증코드를 전송합니다.");
			System.out.println("전송 완료 ! 확인 후 재시도 해주세요.");
			System.out.println("이전 화면으로 돌아갑니다.");
			} else {
				System.out.println("회원 수정용 메서드로 진입합니다.");
			} //modifyCount if-else문 종료
		
		while(run) { 
		System.out.println("수정하실 정보의 항목을 입력해주세요.");
		System.out.println("1. PW");
		System.out.println("2. NICKNAME");
		System.out.println("3. EMAIL");
		System.out.println("0. 나가기");
		System.out.print(">>>");
		String select = input.next();
		switch(select) {
		case "1" :
			System.out.println("회원님의 PW를 변경합니다.");
			System.out.println("변경을 위해 기존 pw를 입력해주세요.");
			System.out.print(">>>");
			String inputPw = input.next();
			if (inputPw.equals(loginState.pw)) {
				System.out.println("변경하실 pw를 입력해주세요.");
				System.out.print(">>>");
				String modifyPw = input.next();
				memberDTOs[temLoginNum].pw = modifyPw ;
				loginState.pw = modifyPw ;
				
			} else {
				loginState.loginComplete++ ;
				System.out.println("비밀번호를" + loginState.loginComplete +"/3회 틀리셨습니다.");
				System.out.println("이전 화면으로 돌아갑니다.");
				
				return loginState ;
			}//비밀번호 변경 if else문 종료
			break ;
		case "2" :
			System.out.println("회원님의 NICKNAME을 변경합니다.");
			System.out.println("변경하실 NICKNAME을 입력해주세요.");
			System.out.print(">>>");
			String modifyNickName = input.next();
			loginState.nickName = modifyNickName ;
			memberDTOs[temLoginNum].nickName = modifyNickName;
			return loginState ;

		case "3" :
			System.out.println("회원님의 EAMIL을 변경합니다.");
			System.out.println("변경하실 EAMIL을 입력해주세요.");
			System.out.print(">>>>");
			String modifyEmail = input.next();
			loginState.email = modifyEmail;
			memberDTOs[temLoginNum].email = modifyEmail;
			return loginState ;
		
		case "0" :
			System.out.println("이전 화면으로 이동합니다");
			return loginState ;
		
		default :
			System.out.println("1~3까지의 숫자를 눌러주세요");
		break ;
		} //switch문 종료
		
	
		} //modifyCount if-else문 종료
		
		return loginState;
		
	}//modify 계정삭제메서드 종료

		
	
	public MemberDTO[] create(Scanner input, MemberDTO[] memberDTOs) {
		//회원가입용 메서드
		boolean run = true ;
		boolean run2 = true ;
		System.out.println("*************************");
		System.out.println("◎     마리오와 함께 달려요    ◎");
		System.out.println("*************************");
		MemberDTO memberDTO = new MemberDTO(); // 빈객체 생성
		
		while (run) {
			System.out.println("사용하실 ID를 입력하세요.");
			System.out.print(">>>");
			inputId = input.next();
			
			for (int i = 0 ; i < memberDTOs.length ; i ++) {
				if(memberDTOs[i] != null && memberDTOs[i].id.equals(inputId)) {
					System.out.println("사용중인 ID입니다.");
					System.out.println("다른 ID를 입력해주세요.");
					run = false ;
					run2 = false ;
					break ;
				}
		while(run2) {
		memberDTO.id = inputId ;
		System.out.println("사용하실 PW를 입력하세요.");
		System.out.print(">>>");
		memberDTO.pw = input.next();
		System.out.println("사용하실 닉네임을 입력하세요.");
		System.out.print(">>>");
		memberDTO.nickName = input.next();
		System.out.println("email 주소를 입력하세요.");
		System.out.print(">>>");
		memberDTO.email = input.next();
		// 빈 memberDTO 객체에 필드값 입력 완료
		
		
		for (int j = 0 ; j < memberDTOs.length ; j++) {
			if(memberDTOs[j] == null ) { //null이면 값이 없음
				memberDTOs[j] = memberDTO ;
				inputId = ""; //inputId값 초기화
				temCreateNum = j ;
				break ;
			} // 안쪽 if문 종료 // memberDTOs[10]배열에 0~null 값이면 삽입 (exam)
		} // memberDTOs[]null배열 검증용 for문 종료
		System.out.println(memberDTOs[temCreateNum].nickName + "님! 회원 가입이 완료되었습니다.");
		System.out.println("로그인을 완료해주세요.");
		 run = false ;
		 run2 = false ;
		 break;
	
		} //while문 종료
		} //for문 종료
		}
		return memberDTOs ;
	} //create 메서드 종료
	

	public MemberDTO login(Scanner input, MemberDTO[] memberDTOs, MemberDTO loginState) {
		// 로그인용 메서드
		if (loginState == null ) { // loginState값이 null일때 id와 pw를 입력할 수 있다.
		System.out.println("id를 입력하세요");
		System.out.print(">>>");
		String id = input.next();
		System.out.println("pw를 입력하세요");
		System.out.print(">>>");
		String pw = input.next();
		// 키보드로 입력 완료 -> 빈객체 생성 -> 삽입 
		
		MemberDTO loginMember = new MemberDTO ();
		loginMember.id = id ;
		loginMember.pw = pw ;
		
		for (int i = 0 ; i < memberDTOs.length ; i++) {
			if(memberDTOs[i] != null && memberDTOs[i].id.equals(loginMember.id) 
					&& memberDTOs[i].pw.equals(loginMember.pw)) {
				System.out.println("로그인 성공!");
				loginState = memberDTOs[i] ; // 배열에 있는 정보가 login 상태 객체에 삽입
				loginState.loginNum = i ; 
				temLoginNum =loginState.loginNum ;
				System.out.println("**확인용 memberDTOs[i] i값출력 확인용 :" +i);
				System.out.println("**확인용 loginNum :" + loginState.loginNum);
				System.out.println("**확인용 temLoginNum :" + temLoginNum);
				
			}else {
				System.out.println("일치하는 회원이 없습니다.");
				return loginState ;
			} //로그인 if-else문 종료
		} //for문종료
		System.out.println("*" + loginState.nickName + "* 님 로그인 성공!");
		return loginState; // 로그인성공객체를 리턴함
		} else {
			System.out.println("*" + loginState.nickName +"* 님 ! 현재 로그인 상태입니다.");
			System.out.println("이전 화면으로 이동합니다.");
		} // loginState에 값이 있을때(로그인 상태일때) 출력문
		return loginState; // 로그인 성공 객체를 리턴함
		
	}
	
	
} // class종료
