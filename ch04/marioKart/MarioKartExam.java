package ch04.marioKart;

import java.util.Scanner;

import ch04.marioKart.dto.CartDTO;
import ch04.marioKart.dto.CharacterDTO;
import ch04.marioKart.dto.GliderDTO;
import ch04.marioKart.dto.ItemDTO;
import ch04.marioKart.dto.MemberDTO;
import ch04.marioKart.dto.TireDTO;
import ch04.marioKart.serivce.MemberSerivce;

public class MarioKartExam {
	// 2025.05.23(금)
	// MVC 패턴으로 마리오 카트 프로그램 만들어보기.
	// MarioKart의 CONTROLLER
	
	// MVC : 웹기반으로 프로젝트를 진행 할때 주로 쓰는 기법
	// M : MODEL -> 서비스계층     ( 부메뉴 : CRUD@ -> 객체활용DTO )
	// V : VIEW  -> 프론트        (HTML, CSS, JS, AJAX, JSON, REACT)
	// C : CONTROLLER -> 분기담당  ( 주메뉴 : main() )
	//------------------------------------------------------------------
	// DTO : 객체용 코드 ( 필드, 생성자, 메서드 ) -> 배열, DB연동
	// SERVICE : DTO를 믹스하여 정보를 만들어줌. 부메뉴용 CRUD
	// main() : 컨트롤러용 ( 주메뉴, 분기담당 )
	//------------------------------------------------------------------
	// 								static (고정, 정적 메서드)
	// 필드 -> main()메서드가 있는 필드는 static용으로 만듦
	public static Scanner input = new Scanner(System.in);
	public static MemberDTO[] memberDTOs = new MemberDTO[10] ; // 10명의 회원 값이 들어갈 memberDTOs배열 생성
	public static CharacterDTO[] characterDTOs = new CharacterDTO[15] ; // 캐릭터 10개 값이 들어갈 characterDTOs배열 생성
	public static CartDTO[] cartDTOs = new CartDTO[8] ; // 카트 8개의 값이 들어갈 cartDTOs배열 생성
	public static GliderDTO[] gliderDTOs = new GliderDTO[10] ; // 글라이더 10개 값이 들어갈 gliderDTOs배열 생성
	public static TireDTO[] tireDTOs = new TireDTO[10] ; // 타이어 10개 값이 들어갈 tireDTOs배열 생성
	public static ItemDTO[] itemDTOs = new ItemDTO[10] ; // 아이템 10개 값이 들어갈 itemDTOs배열 생성
	public static MemberDTO loginState ; // 로그인 성공시 객체를 가지고 있는 용도 , 세션과 같은 기능
	//public static MemberDTO loginComplete ; // 로그인 성공시 세션과 같은 기능 on일경우 로그인.
 
	
	
	// 생성자 -> new MarioKartExam()로 객체를 생성하지 않는다.
	// static {     } 스테틱블록을 사용한다. 초기화용.
	
	static {
		CharacterDTO characterDTO0 = new CharacterDTO ("마리오", 3.0, 4.5, 3.7, 4.1, 3.8) ;
		CharacterDTO characterDTO1 = new CharacterDTO ("루이지", 3.2, 4.4, 3.1, 4.4, 3.2) ;
		CharacterDTO characterDTO2 = new CharacterDTO ("와리오", 3.4, 4.2, 3.2, 4.2, 3.4) ;
		CharacterDTO characterDTO3 = new CharacterDTO ("피치", 3.1, 4.8, 3.4, 4.5, 3.5) ;
		// 객체생성완료
		
		// 객체를 배열에 넣어서 관리한다.
		// characterDTOs[] 객체를 배열에 넣어서 관리
		characterDTOs[0] = characterDTO0 ;
		characterDTOs[1] = characterDTO1 ;
		characterDTOs[2] = characterDTO2 ;
		characterDTOs[3] = characterDTO3 ;
				
	} // static 블록 종료 (main메서드 실행시 초기화값)
	
	
	// 정적 메서드
	public static void main(String[] args) {
		System.out.println("◎M◎A◎R◎I◎O◎\n  ○*K*A*R*T*○");
		boolean run = true ;
		
		while (run) {
			System.out.println(" -----------");
			System.out.println("| 1. 회원관리  |\n| 2. 카트관리  |\n| 3. 게임실행  |\n| 4. 게임종료  |");
			System.out.println(" -----------");
			System.out.print(">>>");
			String select = input.next();
			
			switch (select) {
			case "1" :
				System.out.println(" ◎ ◎ M Y P A G E ◎ ◎");
				MemberSerivce memberSerivce = new MemberSerivce();
				loginState = memberSerivce.menu(input, memberDTOs, loginState);
				if (loginState != null ) {
					System.out.println(loginState.nickName + "님 환영합니다!");
				}
				
			break ;
			case "2" :
				System.out.println("카트관리 클래스로 진입합니다.");
				System.out.println("**탈퇴확인용 출력**");
				System.out.println("memberDTOs[loginState.loginNum]"+memberDTOs[loginState.loginNum]);
				System.out.println("확인용 id:" + loginState.id );
				System.out.println("확인용 pw:" + loginState.pw );
				System.out.println("확인용 index:" + loginState.loginNum );
				System.out.println("**확인용 변경된 pw:" + memberDTOs[loginState.loginNum].pw );
				System.out.println("**확인용 변경된닉네임:" + memberDTOs[loginState.loginNum].nickName );
				break ;
			case "3" :
				System.out.println("게임실행 클래스로 진입합니다.");
				break ;
			case "4" :
				System.out.println("게임을 종료합니다.");
				break ;
			default :
				System.out.println("1~4번 숫자만 입력하세요.");
				break ;
			
			}//switch문 종료
		} //while문 종료

	} //main 메서드 종료

} // class 종료
