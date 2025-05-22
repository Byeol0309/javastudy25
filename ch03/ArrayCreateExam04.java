package ch03;

import java.util.Scanner;

import javax.security.sasl.SaslClient;

public class ArrayCreateExam04 {
	static Scanner inputInt = new Scanner(System.in); // int입력용 scanner 객체 생성
	static Scanner inputStr = new Scanner(System.in); // Str입력용 scanner 객체 생성

	public static void main(String[] args) {
		// ArrayCreateExam03 수정

		// 실습(자판기 프로그램을 구현해보기)
		int point = 0; // 포인트 초기값
		String[] mainMenus = { "라면", "짜파게티", "불닭볶음면" };
		String[] newMainMenus = new String[5];    // 새로운 메뉴 생성시 추가 메뉴값 복사용 변수
		int[] newMainMenuPrices = new int[5];     // 새로운 메뉴 생성시  복사용 변수
		int[] mainMenuPrices = { 3000, 3500, 3700 };
		int[] mainMenuCounts = { 10, 10, 10 };
		int[] addMenuCounts = { 10, 10, 10 };
		String[] addMenus = { "계란", "파", "고춧가루" };
		int[] addMenuPrices = { 500, 300, 100 };
		int [] totalPoints = new int[3] ;
		String [] totalMenuNames = new String[6];
		int totalPoint = 0 ;
 		

		boolean run = true;
		// 메인메뉴 while문 실행용 ;

		// 관리자모드 입장 : case 77
		String adminID = "안녕"; // 관리자 page id
		String adminPW = "하세요"; // 관리자 page pw

		while (run) {
			System.out.println("======== 라면 자판기 ========");
			System.out.println(" 자판기를 이용하시려면 포인트를 충전해주세요");
			System.out.println("==========================");
			System.out.println("1. 포인트 충전하기");
			System.out.println("2. 메뉴 보기");
			System.out.println("3. 주문 하기");
			System.out.println("4. 주문 확인");
			System.out.println("9. 나가기");
			System.out.print(">>>");
			int num = inputInt.nextInt();

			//switch문으로 메인 메뉴를 만들어보자.
			switch (num) {
			case 1:
				// 메서드를 생성할때는 입력값과 출력값을 생각해야한다.
				point = fillUp(point); 
				System.out.println("잔여 포인트 " + point + "point");
				break;

			case 2:
				System.out.println("2. 메뉴 보기");
				menuCheck(mainMenus, addMenus, mainMenuPrices, addMenuPrices, mainMenuCounts, addMenuCounts);
				break;

			case 3:
				System.out.println("3. 주문 결제 하기");
				point = menuOrder(point, mainMenus, addMenus, mainMenuPrices, addMenuPrices, mainMenuCounts,
						addMenuCounts, totalPoints, totalMenuNames, totalPoint );
				break;

			case 4:
				System.out.println("4. 주문 금액 확인");
				break;

			case 9:
				System.out.println("0. 나가기");
				break;

			case 77: // 관리자모드
				adminPage(mainMenus, addMenus, mainMenuPrices, addMenuPrices, adminID, adminPW, newMainMenus,
						newMainMenuPrices, mainMenuCounts, addMenuCounts); // 관리자 메인
				adminMenu(mainMenus); // 관리자 메뉴 수정
				adminPrice(mainMenuPrices, mainMenus, addMenus, addMenuPrices);// 관리자 가격 수정
				adminItem(mainMenus, addMenus, newMainMenus, adminID, adminPW, mainMenuCounts, addMenuCounts); // 관리자 재고																					// 관리
				break;

			default:
				System.out.println("다시 입력해주세요.");
				break;
			} // switch문 종료

		} // while문 종료

	}// main메서드종료

	
	
	// 관리자 메인 메서드 생성
	static void adminPage(String[] mainMenus, String[] addMenus, int[] mainMenuPrices, int[] addMenuPrices,
			String adminID, String adminPW, String[] newMainMenus, int[] newMainMenuPrices, int[] mainMenuCounts,
			int[] addMenuCounts) {
		// 관리자 페이지
		boolean run = true; // 관리자모드 실행용

		while (run) { // while문 시작
			System.out.println("관리자 모드에 진입하셨습니다.");
			System.out.println("관리자 모드 ID와 PW를 입력해주세요");
			System.out.print("ID :");
			String id = inputStr.next();
			System.out.print("PW :");
			String pw = inputStr.next();
			if (run = false) {
			} // case 9 : 메인으로 이동하기 위한 if문

			if (id.equals(adminID) && pw.equals(adminPW)) {
				System.out.println("관리자 모드 로그인 완료.");
				System.out.println("1. 메뉴 수정");
				System.out.println("2. 가격 수정");
				System.out.println("3. 재고 관리");
				System.out.println("9. 나가기");
				System.out.print(">>>");
				int select = inputInt.nextInt();

				switch (select) {
				case 1:
					adminMenu(mainMenus); // 1. 메뉴 수정
					break;
				case 2:
					adminPrice(mainMenuPrices, mainMenus, addMenus, addMenuPrices); // 2. 가격 수정
					break;

				case 3:
					adminItem(mainMenus, addMenus, newMainMenus, adminID, adminPW, mainMenuCounts, addMenuCounts);// 재고관리

					break;

				case 9: // 나가기
					System.out.println("********************");
					System.out.println("  메인 화면으로 이동합니다.");
					System.out.println("********************");
					run = false;
					break;

				default:
					break;

				} // switch문
			} if (!run) {
				System.out.println("ID와 PW가 일치하지 않습니다.");
			}break;

		} // if문 종료
	} // adminPage메서드 종료

	static void adminItem(String[] mainMenus, String[] addMenus, String[] newMainMenus,
			String adminID, String adminPW, int[] mainMenuCounts, int[] addMenuCounts) {
		// 재고관리
		boolean run = true;
		
		int count = 1 ;
		while(run) { // 재고관리 while문 실행, while문을 넣지 않으니, 메서드가 종료되지 않고 반복적으로 실행됨.
		System.out.println("********************");
		System.out.println(" 재고 관리 페이지입니다. ");
		System.out.println("관리하실 상품의 번호를 눌러주세요.");
		
		for (int i = 0; i < mainMenus.length; i++) {
			System.out.println((count++) + ". " + mainMenus[i]);
		} // 메인메뉴 출력용
		for (int i = 0; i < addMenus.length; i++) {
			System.out.println((count++) + ". " + addMenus[i]);
		}
		System.out.print(">>>");
		int select = inputInt.nextInt();
		System.out.println("********************");
		System.out.println("수정하실 상품을 선택하셨습니다");
		switch (select) {
		
		case 1 :
			System.out.println(mainMenus[0]+ " 의 현재 수량 :" + mainMenuCounts[0]);
			System.out.println(mainMenus[0]+"의 변경을 수량 입력하세요");
			System.out.print(">>>");
			int changeCounts1 = inputInt.nextInt();
			mainMenuCounts[0] = changeCounts1 ;
		break;
		
		case 2 :
			System.out.println(mainMenus[1]+ " 의 현재 수량 :" + mainMenuCounts[1]);
			System.out.println("의 변경을 수량 입력하세요");
			System.out.print(">>>");
			int changeCounts2 = inputInt.nextInt();
			mainMenuCounts[1] = changeCounts2 ;
		break;
		
		case 3 :
			System.out.println(mainMenus[2]+ " 의 현재 수량 :" + mainMenuCounts[2]);
			System.out.println("의 변경을 수량 입력하세요");
			System.out.print(">>>");
			int changeCounts3 = inputInt.nextInt();
			mainMenuCounts[2] = changeCounts3 ;

		break;
		
		case 4 :
			System.out.println(addMenus[0]+ " 의 현재 수량 :" + addMenuCounts[0]);
			System.out.println("의 변경을 수량 입력하세요");
			System.out.print(">>>");
			int changeCounts4 = inputInt.nextInt();
			addMenuCounts[0] = changeCounts4 ;

		break;
		
		case 5 :
			System.out.println(addMenus[1]+ " 의 현재 수량 :" + addMenuCounts[1]);
			System.out.println("의 변경을 수량 입력하세요");
			System.out.print(">>>");
			int changeCount5 = inputInt.nextInt();
			addMenuCounts[1] = changeCount5 ;
		break;
		
		case 6 :

			System.out.println(addMenus[2]+ " 의 현재 수량 :" + addMenuCounts[2]);
			System.out.println("의 변경을 수량 입력하세요");
			System.out.print(">>>");
			int changeCount6 = inputInt.nextInt();

		break;

		} //while문 종료
		run = false ;
		}
		System.out.println("********************");
	} // adminItem 메서드 종료

	static String[] adminMenu(String[] mainMenus) {
		// 관리자용 메뉴 수정 메서드 생성
		
		boolean found = true ;
		
		while (found) {
			System.out.println("********************");
			System.out.println(" 메뉴 이름 수정");
			System.out.println("********************");
			System.out.println("수정하실 메뉴의 이름 입력하세요.");
			for (int i = 0; i < mainMenus.length; i++) { 
				System.out.println(mainMenus[i]+ " "); 
			}// 메뉴의 이름을 출력한다.
			System.out.print("입력 :"); //수정할 기존 메뉴이름을 키보드로 입력받는다.
			String changeMenuName = inputStr.next();
			// changeMenuName에 변경하고싶은 입력값을 넣는ㄷ
			while (found) {
			for (int i = 0; i < mainMenus.length; i++) {
				if (changeMenuName.equals(mainMenus[i])) { //키보드로 입력한 값과 mainMenus에 들어있는 값을 비교한다.
					System.out.println((i+1)+". " + mainMenus[i] + " 의 이름을 변경합니다.");
					System.out.println("변경 내용을 입력해주세요.");
					System.out.print("입력 :");
					 String menuName = inputStr.next();
					mainMenus[i] = menuName;
					System.out.println((i+1)+". " + mainMenus[i] + "으로 변경되었습니다.");
				} 
				   
				    {
					//System.out.println("********************");
					//System.out.println("1. 다른 메뉴 수정하기");
					//System.out.println("2. 메인으로 이동하기");
					//System.out.print(">>>");
					//int select = inputInt.nextInt();
					//switch (select) {
					//case 1:
						//found = false ;
						//System.out.println("********************");
						//break;
					//case 2:
						//run = false;
						//found = false ;
						//break;

				// 메뉴이름변경 if문 종료
				
				
				
			} //found while문
			}// 메뉴이름변경 for문 종료

			
			} // 메인으로 이동 select switch문

		} // switch문 종료
		return mainMenus;

	} // adminMenu메서드 종료

	static void adminPrice(int[] mainMenuPrices, String[] mainMenus, String[] addMenus, int[] addMenuPrices) {
		// 관리자용 가격 수정 메서드 생성
		System.out.println("********************");
		System.out.println("  가격 수정 페이지입니다. ");
		System.out.println(" 수정하실 메뉴의 번호를 입력하세요.");
		for (int i = 0; i < mainMenuPrices.length; i++) {
			System.out.println((i+1) + ". " + mainMenus[i] + " :" + mainMenuPrices[i]);
		}
		System.out.println();

	} // adminPrice메서드 종료

	// 토핑추가메서드
	static int addTopping(int point, String[] mainMenus, String[] addMenus, int[] mainMenuPrices, int[] addMenuPrices,
			int[] mainMenuCounts, int[] addMenuCounts, int [] totalPoints,String [] totalMenuNames) {
		//
		System.out.println("==========================");
		System.out.println(" 토핑 추가 메뉴입니다.");
		System.out.println("==========================");
		System.out.println("원하시는 토핑의 번호를 눌러주세요.");
		for (int i = 0; i < addMenus.length; i++) {
			System.out.println((i + 1) + addMenus[i] + " " + addMenuPrices[i] + "point");
		} // 토핑메뉴보여주기 for문
		System.out.print(">>>");
		int addSelect = inputInt.nextInt();

		if (point > addMenuPrices[addSelect - 1]) {
			switch (addSelect) {
			case 1:
				System.out.println("==========================");
				System.out.println(addMenus[0] + "추가");
				System.out.println("==========================");
				point = (point - (addMenuPrices[0]));
				addMenuCounts[0] = addMenuCounts[0] - 1;
				System.out.println("확인용입니다." + addMenuCounts[0]); // 재고 반영 되었는지 확인용.
				System.out.println("잔여포인트" + point);
				break;

			case 2:
				System.out.println("==========================");
				System.out.println(addMenus[1] + "추가");
				System.out.println("==========================");
				point = (point - (addMenuPrices[1]));
				addMenuCounts[0] = addMenuCounts[1] - 1;
				System.out.println("확인용입니다." + addMenuCounts[1]); // 재고 반영 되었는지 확인용.
				System.out.println("잔여포인트" + point);
				break;

			case 3:
				System.out.println("==========================");
				System.out.println(addMenus[2] + "추가");
				System.out.println("==========================");
				point = (point - (addMenuPrices[2]));
				addMenuCounts[0] = addMenuCounts[2] - 1;
				System.out.println("확인용입니다." + addMenuCounts[2]); // 재고 반영 되었는지 확인용.
				System.out.println("잔여포인트" + point);
				point = point - addMenuPrices[2];
				break;

			} // switch문 종료

		} // 토핑추가 보유 포인트 확인 if문

		return point;

	} // addTopping 메서드 생성

	static int menuOrder(int point, String[] mainMenus, String[] addMenus, int[] mainMenuPrices, int[] addMenuPrices,
			int[] mainMenuCounts, int[] addMenuCounts, int [] totalPoints,String [] totalMenuNames , int totalPoint) {
		// 메인메뉴 주문하기 메서드 생성
		String orderMenu = "";
		String addMenu = "";
		//totalPoint = 0 ;
		//int totalPoint2 = 0 ;
		/// 주문 저장용 인덱스 생성하기
		
	
		System.out.println("==========================");
		System.out.println("주문하실 메뉴의 번호를 눌러주세요.");
		System.out.println("==========================");
		for (int i = 0; i < mainMenus.length; i++) {
			System.out.println((i + 1) + ". " + mainMenus[i]);
		} // for문종료
		System.out.print(">>>");
		int select = inputInt.nextInt(); // 입력 번호에 해당하는 메뉴를 주문받는다.

		if (point > mainMenuPrices[select - 1]) { // 주문하는 금액보다 보유 포인트가 많을때 실행되는 if문
			switch (select) {
			case 1:
				System.out.println(mainMenus[0] + " 메뉴를 주문합니다.");
				System.out.println(mainMenus[0] + "가격은 " + mainMenuPrices[0] + "point");
				point = point - mainMenuPrices[0];
				// System.out.println("사용 후 잔여 포인트 :" + point);
				orderMenu = mainMenus[0];
				totalMenuNames[0] = mainMenus[0] ; 
				totalPoints[0] = mainMenuPrices[0] ;
				mainMenuCounts[0] = mainMenuCounts[0] - 1;
				
				//System.out.println("**확인용입니다." + mainMenuCounts[0]);// 반영되었는지 확인용.
				//System.out.println("**totalMenuNames[0] : " + totalMenuNames[0]);// 반영되었는지 확인용.
				//totalPoint = (totalPoint2 + mainMenuPrices[0]) ;
				//System.out.println("**totalPoint : " + totalPoint);// 반영되었는지 확인용.

				break;

			case 2:
				System.out.println(mainMenus[1] + " 메뉴를 주문합니다.");
				System.out.println(mainMenus[1] + "가격은 " + mainMenuPrices[1] + "point");
				point = point - mainMenuPrices[1];
				// System.out.println("사용 후 잔여 포인트 :" + point);
				orderMenu = mainMenus[1];
				mainMenuCounts[1] = mainMenuCounts[1] - 1;
				System.out.println("확인용입니다." + mainMenuCounts[1]); // 반영되었는지 확인용.

				break;

			case 3:
				System.out.println(mainMenus[2] + " 메뉴를 주문합니다.");
				System.out.println(mainMenus[2] + "가격은 " + mainMenuPrices[2] + "point");
				point = point - mainMenuPrices[2];
				// System.out.println("사용 후 잔여 포인트 :" + point);
				orderMenu = mainMenus[2];
				mainMenuCounts[2] = mainMenuCounts[2] - 1;
				System.out.println("확인용입니다." + mainMenuCounts[2]);
				break;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			} // select switch문 종료

			System.out.println("==================");
			System.out.println("토핑을 추가하시겠습니까?");
			System.out.println("1. 예 ");
			System.out.println("2. 아니요");
			System.out.print(">>>");
			int subSelect = inputInt.nextInt();
			switch (subSelect) {
			case 1:
				addTopping(point, mainMenus, addMenus, mainMenuPrices, 
						addMenuPrices, mainMenuCounts, addMenuCounts, totalPoints, totalMenuNames);
				System.out.println(orderMenu + "주문이 완료되었습니다.");
				break;

			case 2:
				System.out.println("");
				break;
			} // 토핑추가 switch문

			// 주문 후 포인트 결제 안쪽if문 종료
			if (point > 0) {
				System.out.println("==========================");
				System.out.println("잔여 포인트를 돌려받으시겠습니까?");
				System.out.println("1. 예");
				System.out.println("2. 추가주문하기");
				System.out.print(">>>");
				int select1 = inputInt.nextInt();
				switch (select1) {
				case 1:
					System.out.println("반환 포인트 : " + point);
					System.out.println("==========================");
					break;
				case 2:
				} // switch문

			} // 잔여포인트 if문
		} else {
			System.out.println("==========================");
			System.out.println("결제 포인트가 부족합니다.");
			System.out.println("잔여 포인트를 확인해주세요.");
			System.out.println("잔여 포인트 " + point + "point");
			System.out.println("==========================");

		} // 결제 포인트 확인 바깥쪽 if문 종료
		System.out.println("==========================");
		System.out.println("    이전 화면으로 되돌아갑니다.");
		System.out.println("==========================");

		return point;

	} // menuOrder메서드 종료

	static void menuCheck(String[] mainMenus, String[] addMenus, int[] mainMenuPrices, int[] addMenuPrices,
			int[] mainMenuCounts, int[] addMenuCounts) {
		// 메뉴 보기 메서드 생성
		System.out.println("==========================");
		System.out.println("메뉴를 확인해주세요.");
		for (int i = 0; i < mainMenus.length; i++) {
			System.out.println(i + 1 + ". " + mainMenus[i] + " " + mainMenuPrices[i] + " 원");
		} // for문 종료
		System.out.println("==========================");
		System.out.println("    이전 화면으로 되돌아갑니다. ");
		System.out.println("==========================");

	}// menuCheck메서드 종료

	static int fillUp(int point) {
		// 포인트 충전 메서드 생성
		System.out.println("======== 포인트 충전 ========");
		System.out.println("1. 포인트 충전하기");
		System.out.println("9. 이전 화면으로");
		System.out.print(">>>");
		int select = inputInt.nextInt();

		switch (select) {
		case 1:
			System.out.println("포인트를 충전합니다.");
			System.out.println("충전하실 포인트를 입력해주세요.");
			System.out.print(">>>");
			int point1 = inputInt.nextInt();
			point = point1 + point;
			System.out.println("충전하신 포인트 :" + point + "point");
			break;

		default:
			System.out.println("==========================");
			System.out.println("    이전 화면으로 되돌아갑니다.");
			System.out.println("==========================");

			break;

		} // switch문 종료
		return point;
	} // fillUp 메서드 종료

}// class 종료

