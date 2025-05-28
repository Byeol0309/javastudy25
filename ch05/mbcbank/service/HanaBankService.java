package ch05.mbcbank.service;

import java.util.Scanner;

import ch05.mbcbank.dto.AccountDTO;

public class HanaBankService {

	public void menu(Scanner inputInt, Scanner inputStr, AccountDTO[] hanaBank, 
			AccountDTO[] woriBank, AccountDTO[] nhBank) {
		// 부메뉴 crud
		boolean subRun = true; // 부메뉴 while문용 변수
		while (subRun) {
			System.out.println("----------------------------");
			System.out.println("하나은행 계좌관리 메서드입니다.");
			System.out.println("1. 계좌생성");
			System.out.println("2. 계좌목록");
			System.out.println("3. 예금");
			System.out.println("4. 출금");
			System.out.println("5. 이체");
			System.out.println("6. 종료");
			System.out.print(">>>");
			String select = inputStr.next();
			switch (select) {
			case "1":
				System.out.println("==계좌생성 메서드로진입합니다==");
				createAccount(inputStr, inputInt, hanaBank);
				break;
			case "2":
				System.out.println("==계좌목록 메서드로진입합니다==");
				accountLists(inputStr, inputInt, hanaBank);
				break;
			case "3":
				System.out.println("==계좌입금 메서드로진입합니다==");
				// 계좌번호를 먼저 찾아야함.
				// 계좌번호ano 값에 금액Balance을 조절해야함.
				deposit(inputStr, inputInt, hanaBank);

				break;
			case "4":
				System.out.println("==계좌출금 메서드로진입합니다==");
				withdrawal(inputStr, inputInt, hanaBank) ;
				break;
			case "5":
				System.out.println("==계좌이체 메서드로진입합니다==");
				Transfer(inputStr, inputInt, hanaBank);
				
				break;
			case "6":
				System.out.println("==하나은행을 종료합니다==");
				System.out.println("==메인메뉴로 복귀합니다==");
				subRun = false;
				break;
			default:
				System.out.println("== 1~6 까지만 입력해주세요. ==");
				break;

			} // switch문 종료
		} // 부메뉴 while문 종료

	} // 부메뉴 menu메서드종료

	private void Transfer(Scanner inputStr, Scanner inputInt, AccountDTO[] hanaBank) {
		// 계좌이체메서드
		System.out.println("-----------계좌이체-----------");
		System.out.println("1. 계좌이체");
		System.out.println("2. 타행이체");
		System.out.println("0. 나가기");
		System.out.print(">>>");
		String select = inputStr.next();
		switch (select) {
		case "1" :
			System.out.print("보내시는 계좌 :");
			String ano = inputStr.next();
			AccountDTO myAccount = findAccount(ano, hanaBank);
			if (myAccount == null) {
				System.out.print("찾으시는 계좌의 정보가 없습니다.");
			}else {
				System.out.print("비밀번호 : ");
				String pw = inputStr.next();
				if(myAccount.getPw().equals(pw)) {
					System.out.print("받으실 계좌 :");
					String withdtawalAno = inputStr.next();
					
					AccountDTO UserAccount = findAccount(withdtawalAno, hanaBank); // 받는 계좌 검증 메서드
					if (UserAccount == null) {
						System.out.print("찾으시는 계좌의 정보가 없습니다.");
					} else {
						System.out.println(UserAccount.getBankname()+""+UserAccount.getOwner()+"님께");
						System.out.print("보내실 금액 :");
						int inputMoney = inputInt.nextInt();
						
						myAccount.setBalance(myAccount.getBalance()-inputMoney); 
						// 보낸계좌 (myAccount) money만큼 -
						
						UserAccount.setBalance(UserAccount.getBalance()+inputMoney);
						// 받은계좌 money만큼+
						System.out.println(UserAccount.getOwner()+"님께 "+inputMoney+"원 이체가 완료되었습니다.");
						
					} // 보내는 계좌 pw검증, 받을계좌검증 else문종료
				} else {
					System.out.println("계좌의 정보가 틀립니다.");
				}//받을 계좌 검증 if문종료 . 
				System.out.println("내 계좌 잔고 :" + myAccount.getBalance());
			}
			
			break ;
			
		case "2" :
			System.out.println("2. 타행이체");

			break ;
			
		default :
			break ;
		} // switch문 종료
	} // 계좌 송금 메서드 종료

	private void withdrawal(Scanner inputStr, Scanner inputInt, AccountDTO[] hanaBank) {
		// 계좌번호 입력 후 일치하는 계좌번호를 찾아 입력된 금액을 계좌 잔액에서 감소시킨다.
		// 잔고보다 출금액이 많을경우 출금 불가 코드 넣어보기
		
		System.out.println("----------- 출금 -----------");
		System.out.print("계좌번호 : ");
		String ano = inputStr.next();
		AccountDTO myAccount = findAccount(ano,hanaBank);
		if(myAccount == null) {
			System.out.print("찾으시는 계좌의 정보가 없습니다.");
		} else {
			System.out.print("비밀번호 : ");
			String pw = inputStr.next();

			boolean prove = findPw(myAccount, pw) ;
			if (prove != false) { //비밀번호 검증 if문
			System.out.print("출금액 : ");
			int money = inputInt.nextInt();
			myAccount.setBalance(myAccount.getBalance() - money);
			System.out.println("잔액 :" + myAccount.getBalance() +"원");
			}
		}// 계좌번호 검증 if문
		
	} // withdrwal 출금 메서드 생성

	private void deposit(Scanner inputStr, Scanner inputInt, AccountDTO[] hanaBank) {
		// 계좌번호 입력 후 일치하는 계좌번호를 찾아 입력된 입금액을 계좌 잔액에서 증가시킨다.
		System.out.println("----------- 예금 -----------");
		System.out.print("계좌번호 : ");
		String ano = inputStr.next();
		

		System.out.print("예금액 : ");
		int money = inputInt.nextInt();

		AccountDTO inputAccount = findAccount(ano, hanaBank);
		// findAccount 메서드는 배열에서 객체를 찾아주고 객체를 리턴해준다. (반복코드 배제용)
		if (inputAccount == null) {
			System.out.println("찾으시는 계좌의 정보가 없습니다.");
			return;
		} // if문 종료
		inputAccount.setBalance(inputAccount.getBalance() + money);
		System.out.println("입금테스트 결과 : " + inputAccount);
		// toString으로 결과보기
		System.out.println(inputAccount.getOwner() + "님 입금이 성공되었습니다.");
		System.out.println("잔액 :" + inputAccount.getBalance());
		System.out.println("----------------------------");
	} // 계좌입금 deposit 메서드 종료

	
	
	 private boolean findPw(AccountDTO myAccount, String pw) {
		// pw 검증용 메서드
		// myAccount에 들어있는 pw값과 
		// 키보드로 입력한 pw값이 일치하는지 검증한다.
		 if (myAccount.getPw().equals(pw)) {
			 System.out.println("비밀번호가 일치합니다.");
			 return true ;
		 }else {
			 System.out.println("잘못입력하셨습니다.");
		 }
		 
		return false;
	} //pw 검증용 findPw메서드종료

	 
	 

	private AccountDTO findAccount(String ano, AccountDTO[] hanaBank) {
		// 입금, 출금, 이체에서 계좌번호를 이용해 객체를 찾는 반복 코드 메서드
		AccountDTO account = null; // 빈객체
		for (int i = 0; i < hanaBank.length; i++) {
			if (hanaBank[i] != null) {
				// hanaBank[]가 null이 아닐때

				String dbAno = hanaBank[i].getAno();
				// hanaBank[i]배열에 있는 계좌번호를 가져와 dbAno에 넣음.

				if (dbAno.equals(ano)) {
					// 키보드로 입력된 ano와 dbAno의 값이 같으면
					account = hanaBank[i]; // 빈객체에 찾은 객체를 넣는다.
					break;
				} // hanaBank[i]배열.ano(키보드로입력) equals판단 안쪽 if문 종료
			} // 바깥쪽 if문 종료

		} // for문 종료

		return account;
		// 계좌찾기메서드

	} // find Account메서드종료

	private void accountLists(Scanner inputStr, Scanner inputInt, AccountDTO[] hanaBank) {
		// 계좌보기메서드 하나은행의 계정을 모두볼수있음 (은행원용)
		// 은행원만 볼수있도록 검증 코드 넣어보기.
		System.out.println("--------하나은행계좌 리스트--------");
		for (int i = 0; i < hanaBank.length; i++) {
			AccountDTO accountList = hanaBank[i];
			if (accountList != null) {
				// 배열이 null값이 아닐때만 출력한다.
				System.out.print(accountList.getAno());
				System.out.print("\t");
				System.out.print(accountList.getOwner());
				System.out.print("\t");
				System.out.print(accountList.getBalance());
				System.out.print("\t\n");
				System.out.println("----------------------------");
			} // if문 종료
		} // for문 종료

	}// 계좌보기 accountLists 메서드종료

	private void createAccount(Scanner inputStr, Scanner inputInt, AccountDTO[] hanaBank) {
		// 계좌생성메서드
		// hanaBank[]배열에 새로운 객체를 넣는다.
		boolean prove = true ; // 계좌번호 앞자리 검증용 boolean코드
		System.out.println("-----------계좌생성-----------");
		AccountDTO myAccount = new AccountDTO(); // 빈객체 생성
													// 키보드로 입력받은 값을 넣을 객체
		System.out.print("계좌번호 : 12"); //입력값에 은행 코드 12더해서 입력받음.
		String ano = inputStr.next();
		ano = "12"+ano ; //키보드로 입력받은 ano앞에 "12"를 더한다.
		if(ano.startsWith("12")) { //str.starWith("") : 문자열 앞자리를 비교함.
									// 다음에는 숫자 자리수도 검증해보기.
			prove = true ; 
		} else {
			System.out.println("계좌번호 앞자리는 12로 시작해야합니다.");
			prove = false ;
			return ;
		}//if문 종료
		AccountDTO inputAccount = findAccount(ano, hanaBank);
		if (inputAccount == null && prove != false ) {
			System.out.println("계좌번호 생성을 위해 다른 정보를 입력해주세요.");
			myAccount.setAno(ano);
		} else {
			System.out.println("중복되는 계좌번호가 존재합니다.");
			System.out.println("다른 계좌번호를 입력해주세요.");
			return;
		}

		System.out.print("계좌주 :");
		myAccount.setOwner(inputStr.next());// 키보드로 입력한 문자열이 myAccount.setOwner에 들어감.
		
		System.out.print("비밀번호(4자리) :");
		String pw = inputStr.next();
		if(4 == pw.length()) {
			System.out.println("비밀번호가 입력되었습니다.");
			myAccount.setPw(pw);
			System.out.println("입력받은 비밀번호 :" +pw);
		} else {
			System.out.println("네자리 숫자를 입력해주세요.");
			System.out.println("처음 화면으로 돌아갑니다.");
			return;
		}

		System.out.print("초기입금액 :");
		myAccount.setBalance(inputInt.nextInt());
		myAccount.setBankname("하나"); // 빈객체(myAccount)에 Bankname 데이터 입력
										// setter를 사용하기때문에 myAccount.setBankname();
		System.out.print("계좌생성이 정상적으로 처리되었습니다.");

		// hanaBank[]의 null값을 확인하고, null값에 객체를 삽입한다.
		for (int i = 0; i < hanaBank.length; i++) {
			if (hanaBank[i] == null) {
				// hanaBank[]이 null이면 실행된다.
				hanaBank[i] = myAccount; // 키보드로 입력한 값이 들어있는 myAccount객체를
											// hanaBank[] null인 index자리에 넣는다.
				System.out.println("계좌입력완료테스트 : " + hanaBank[i]); // toString으로 테스트 결과가 보임
				break; // null값에 1번만 입력하기 위해 break를 넣는다.
			} else { // null 없을경우 출력
				System.out.println("현재 이용자가 많아 계좌생성이 불가합니다.");
			} // if-else문 종료
			System.out.println("계좌입력완료테스트 : " + hanaBank[i]); // toString으로 테스트 결과가 보임
		} // hanaBank[] for문종료

	} // 계좌생성 createAcceount메서드종료

} // class종료
