package ch05.mbcbank;

import java.util.Scanner;

import ch05.mbcbank.dto.AccountDTO;
import ch05.mbcbank.service.HanaBankService;

public class BankExam {
			//2025.05.27 (화)
			// Getter와 Setter를 사용하여
			// 키보드로 계좌 정보를 입력받아서 계좌를 관리하는 프로그램을 작성해본다.
			// 계좌관리 프로그램을 만들어보자.
	// 필드
	public static Scanner inputInt = new Scanner(System.in) ;
	public static Scanner inputStr = new Scanner(System.in) ;
	public static AccountDTO[] hanaBank = new AccountDTO[10] ;
	public static AccountDTO[] woriBank = new AccountDTO[10] ;
	public static AccountDTO[] nhBank = new AccountDTO[10] ;
	public static AccountDTO session = null ;
	
	
	
	
	// 생산자
	// static{} static블록 : 정적블록 , main메서드의 초기화값.
	static {
		// 하나은행배열, 우리은행배열, 농협은행배열[0] 에 넣을 초기화값 생성하기.
		// AccountDTO accountDTO = new AccountDTO("계좌번호","계좌주", i(잔고) , "은행명")
		AccountDTO accountDTO0 = new AccountDTO("121234","포도", "1004", 1000 , "하나");
		// 새롭게 생성한 accountDTO0 객체에 초기화값을 넣었음.	
		hanaBank[0] = accountDTO0 ; // 초기화값을 넣은 accountDTO0객체를 hanaBank[0]에 넣었음.
		
		AccountDTO accountDTO1 = new AccountDTO("345678", "딸기", "1005", 10000 , "우리");
		woriBank[0] = accountDTO1 ;
		
		AccountDTO accountDTO2 = new AccountDTO("561526", "초코", "1006",100000, "농협");
		nhBank[0] = accountDTO2 ;
	}
	
	
	
	
	
	
	// 메서드
	public static void main(String[] args) {
		boolean run = true ; 
		while(run) {
			System.out.println("==========================");
			System.out.println("MBC코인시스템에 오신것을 환영합니다.");
			System.out.println("==========================");
			System.out.println("1. 하나은행");
			System.out.println("2. 우리은행");
			System.out.println("3. 농협은행");
			System.out.println("4. 프로그램종료");
			System.out.print(">>>");
			String select = inputStr.next();
			switch(select) {
			case "1" : 
				System.out.println("하나은행으로 진입합니다.");
				HanaBankService hanaBankService = new HanaBankService();
				hanaBankService.menu(inputInt, inputStr, hanaBank, woriBank, nhBank);
				break ;
			case "2" : 
				System.out.println("우리은행으로 진입합니다.");
				break ;
			case "3" : 
				System.out.println("농협은행으로 진입합니다.");
				break ;
			case "4" : 
				System.out.println("프로그램을 종료합니다");
				run = false ;
				break ;
			default : 
				System.out.println("1~4값만 입력하세요");
				break ;
			} //메뉴 선택 switch문 종료 
		
			
		} //주메뉴 while문 종료
		
		
		
		
		
		
		
		
		
	} // 주메뉴 main메서드 종료

} // BankExam class 종료
