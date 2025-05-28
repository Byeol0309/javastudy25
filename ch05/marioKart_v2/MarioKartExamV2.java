package ch05.marioKart_v2;

import java.util.Scanner;

import ch05.marioKart_v2.dto.CartDTO;
import ch05.marioKart_v2.dto.CharacterDTO;
import ch05.marioKart_v2.dto.GliderDTO;
import ch05.marioKart_v2.dto.ItemDTO;
import ch05.marioKart_v2.dto.MemberDTO;
import ch05.marioKart_v2.dto.TireDTO;
import ch05.marioKart_v2.sericve.MemberSerivceV2;

public class MarioKartExamV2 {
	// 2025.05.26(월)
	// DTO에 getter와 setter를 적용하여, MarioKartExamV2 만들어보자.
	
	public static Scanner input = new Scanner(System.in);
	public static MemberDTO[] memberDTOs = new MemberDTO[10] ; // 10명의 회원 값이 들어갈 memberDTOs배열 생성
	public static CharacterDTO[] characterDTOs = new CharacterDTO[15] ; // 캐릭터 10개 값이 들어갈 characterDTOs배열 생성
	public static CartDTO[] cartDTOs = new CartDTO[8] ; // 카트 8개의 값이 들어갈 cartDTOs배열 생성
	public static GliderDTO[] gliderDTOs = new GliderDTO[10] ; // 글라이더 10개 값이 들어갈 gliderDTOs배열 생성
	public static TireDTO[] tireDTOs = new TireDTO[10] ; // 타이어 10개 값이 들어갈 tireDTOs배열 생성
	public static ItemDTO[] itemDTOs = new ItemDTO[10] ; // 아이템 10개 값이 들어갈 itemDTOs배열 생성
	public static MemberDTO loginState ; // 로그인 성공시 객체를 가지고 있는 용도 , 세션과 같은 기능
	//public static MemberDTO loginComplete ; // 로그인 성공시 세션과 같은 기능 on일경우 로그인.
    
	// 다른 패키지에있는 DTO도 참조할수있으니 패키지를 잘 확인해야함.
	
	
	// 생성자 -> new MarioKartExam()로 객체를 생성하지 않는다.
	// static {     } 스테틱블록을 사용한다. 초기화용.
	
	static {
		//CharacterDTO characterDTO0 = new CharacterDTO ("마리오", 3.0, 4.5, 3.7, 4.1, 3.8) ;
		//CharacterDTO characterDTO1 = new CharacterDTO ("루이지", 3.2, 4.4, 3.1, 4.4, 3.2) ;
		//CharacterDTO characterDTO2 = new CharacterDTO ("와리오", 3.4, 4.2, 3.2, 4.2, 3.4) ;
		//CharacterDTO characterDTO3 = new CharacterDTO ("피치", 3.1, 4.8, 3.4, 4.5, 3.5) ;
		// 객체생성완료 private으로 바꿔야함.
		
		// 객체를 배열에 넣어서 관리한다.
		// characterDTOs[] 객체를 배열에 넣어서 관리
		//characterDTOs[0] = characterDTO0 ;
		//characterDTOs[1] = characterDTO1 ;
		//characterDTOs[2] = characterDTO2 ;
		//characterDTOs[3] = characterDTO3 ;
				
	} // static 블록 종료 (main메서드 실행시 초기화값)
	
	
	// 정적 메서드
	public static void main(String[] args) {
		System.out.println("마리오카트에 오신것을 환영합니다.");
		boolean run = true ;
		
		while (run) {
			System.out.println(" -----------");
			System.out.println("| 1. 회원관리  |\n| 2. 카트관리  |\n| 3. 게임실행  |\n| 4. 게임종료  |");
			System.out.println(" -----------");
			System.out.print(">>>");
			String select = input.next();
			
			switch (select) {
			case "1" :
				System.out.println("회원관리페이지입니다.");
				MemberSerivceV2 memberSerivce = new MemberSerivceV2();
				loginState = memberSerivce.menu(input, memberDTOs, loginState);
			break ;
			case "2" :
				System.out.println("카트관리 클래스로 진입합니다.");
				
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



