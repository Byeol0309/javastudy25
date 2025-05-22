package ch03;

import java.util.Scanner;

import javax.security.sasl.SaslClient;

public class ArrayCreateExam03 {

	public static void main(String[] args) {
		// 실습(자판기 프로그램을 구현)
		int point = 0;
		Scanner inputInt = new Scanner(System.in);
		Scanner inputStr = new Scanner(System.in);
		String[] mainMenus = { "라면", "짜파게티", "불닭볶음면" };
		String[] newMainMenus = new String[5]; // 메뉴를 추가할때 사용할 변수
		String[] addMenus = { "계란", "파", "고춧가루" };
		int[] mainMenuPrices = { 3000, 3500, 3700 };
		int[] newMainMenuPrices = new int[5]; // 메뉴를 추가할때 사용할 변수
		int[] addMenuPrices = { 500, 300, 100 };
		boolean run = true;
		// boolean adminPage = true;

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
			System.out.println("4. 잔여 포인트 확인");
			System.out.println("9. 나가기");
			System.out.print(">>>");
			int num = inputInt.nextInt();

			switch (num) {
			case 1:
				// 메서드를 생성할때는 입력값과 출력값을 생각해야한다.
				point = fillUp(point);
				System.out.println("잔여 포인트 " + point + "point");
				break;

			case 2:
				System.out.println("2. 메뉴 보기");
				menuCheck(mainMenus, addMenus, mainMenuPrices);
				break;

			case 3:
				System.out.println("3. 주문 결제 하기");
				point = menuOrder(point, mainMenus, addMenus, mainMenuPrices);
				break;

			case 4:
				System.out.println("4. 잔여 포인트 확인");
				break;

			case 9:
				System.out.println("0. 나가기");
				break;

			case 77: // 관리자모드
				adminPage(mainMenus, addMenus, mainMenuPrices, adminID, adminPW, newMainMenus, newMainMenuPrices);
				break;

			default:
				System.out.println("다시 입력해주세요.");
				break;
			} // switch문 종료

		} // while문 종료

	}// main메서드종료

	static void adminPage(String[] mainMenus, String[] addMenus, int[] mainMenuPrices, String adminID, String adminPW,
			String[] newMainMenus, int[] newMainMenuPrices) {
		// adminPage 관리자용 메뉴 메서드 생성
		boolean run2 = true; // 관리자모드 실행용
		boolean run3 = true;
		Scanner inputInt = new Scanner(System.in);
		Scanner inputStr = new Scanner(System.in);

		while (run2) { // while문 시작
			System.out.println("관리자 모드에 진입하셨습니다.");
			System.out.println("관리자 모드 ID와 PW를 입력해주세요");
			System.out.print("ID :");
			String id = inputStr.next();
			System.out.print("PW :");
			String pw = inputStr.next();
			if (run2 = false) {
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
					adminMenu(mainMenus);
					break;

				case 2:
					adminPrice(mainMenuPrices, mainMenus);
					break;

				case 3:
					adminItem(mainMenus, addMenus, mainMenuPrices, newMainMenus, newMainMenuPrices, adminID, adminPW);
					break;

				case 9:
					System.out.println("********************");
					System.out.println("  메인 화면으로 이동합니다.");
					System.out.println("********************");
					run2 = false;
					break;
				} // 관리자용 switch문 종료

			} // else {
				// System.out.println("잘못입력하셨습니다.");
				// } // 관리자 검증용 if-else문 종료
		} // adminPage용 while문 종료
	}// adminPage메서드 종료

	static void adminItem(String[] mainMenus, String[] addMenus, int[] mainMenuPrices, String[] newMainMenus,
			int[] newMainMenuPrices, String adminID, String adminPW) {
		// 재고관리를 위한 관리자용 메서드 생성
		Scanner inputInt = new Scanner(System.in);
		Scanner inputStr = new Scanner(System.in);

		System.out.println("********************");
		System.out.println("  재고 관리 페이지입니다.");
		System.out.println(" 관리할 메뉴를 선택해주세요");
		System.out.println("1. 메인메뉴 ");
		System.out.println("2. 토핑메뉴");
		System.out.println("9. 나가기");
		System.out.print(">>>");
		int select = inputInt.nextInt();
		System.out.println("********************");

		switch (select) {
		case 1: // 메인메뉴 재고 관리
			adminMainMenuItem(mainMenus, mainMenuPrices, newMainMenus, newMainMenuPrices, adminID, adminPW);
			break;

		case 2:
			adminAddMenuItem(addMenus);
			break;

		case 9:
			break;

		} // 재고관리 switch 문 종료

	} // adminItem 메서드 종료

	private static void adminAddMenuItem(String[] addMenus) {
		// TODO Auto-generated method stub
		
	}

	static void adminMainMenuItem(String[] mainMenus, int[] mainMenuPrices, String[] newMainMenus,
			int[] newMainMenuPrices, String adminID, String adminPW) {
		// 관리자용 메인메뉴 재고관리
		Scanner inputInt = new Scanner(System.in);

		System.out.println("********************");
		System.out.println("메인메뉴 재고관리 페이지입니다.");
		System.out.println("1. 메뉴 삭제");
		System.out.println("2. 품절 처리");
		/*
		 * System.out.println("관리하실 상품의 번호를 눌러주세요."); for (int i = 0; i <
		 * mainMenus.length; i++) { System.out.println((i + 1) + ". " + mainMenus[i]); }
		 * // for문 종료 mainMenus, int[] mainMenuPrices, String[] newMainMenus, int[]
		 * newMainMenuPrices
		 */
		System.out.print(">>>");
		int select = inputInt.nextInt();

		switch (select) {
		case 1: // 메뉴 삭제 mainMenus,newMainMenus, mainMenyePrice, newMainMenuPrices null 처리
			mainDel(mainMenus, newMainMenus, mainMenuPrices, newMainMenuPrices, adminID, adminPW);
			break;

		case 2: // 품절처리 mainMenus,newMainMenus 이름 변경 // mainMenyePrice, newMainMenuPrices 가격 변경
			mainSoldOut(mainMenus, newMainMenus, mainMenuPrices, newMainMenuPrices);
			break;

		default:
			System.out.println("다시 입력해주세요.");
			break;

		} // switch문 종료
	} // adminMainMenuItem 메서드 종료

	static void mainSoldOut(String[] mainMenus, String[] newMainMenus, int[] mainMenuPrices,
			int[] newMainMenuPrices) {
		// 품절처리 mainMenus,newMainMenus 이름 변경 // mainMenyePrice, newMainMenuPrices 가격 변경
		
	} //mainSoldOut

	static String[] mainDel(String[] mainMenus, String[] newMainMenus, int[] mainMenuPrices, int[] newMainMenuPrices, String adminID, String adminPW) {
		// 메인 메뉴 삭제 mainMenus,newMainMenus, mainMenyePrice, newMainMenuPrices null 처리
		Scanner inputInt = new Scanner(System.in);
		Scanner inputStr = new Scanner (System.in) ;
		String adminInputCode = "" ;

		System.out.println("********************");
		System.out.println("메인메뉴 삭제 페이지입니다.");
		System.out.println("삭제하실 메뉴를 입력해주세요.");
		System.out.println("관리하실 상품의 번호를 눌러주세요.");
		System.out.println("********************");

		for (int i = 0; i < mainMenus.length; i++) {
			System.out.println((i + 1) + ". " + mainMenus[i]);
		}
		// for문 종료
		System.out.print(">>>");
		int select = inputInt.nextInt();
		System.out.println("********************");

		switch(select) {
		case 1 :
			System.out.println(mainMenus[0]+ "메뉴를 삭제하시겠습니까?");
			System.out.println("삭제를 위해서 'YES'를 입력하세요.");
			System.out.print(">>>");
			String agrred = inputStr.nextLine();
			System.out.println("관리자 코드를 입력하세요");
			System.out.print(">>>");
			adminInputCode = inputStr.nextLine(); // 관리자 코드 검증
			
			if (agrred.equalsIgnoreCase("yes") && adminInputCode.equals(adminID) ) {
				
				System.out.println(mainMenus[0]+ " 메뉴가 삭제됩니다.");
				mainMenus[0] = null ;
				System.out.println(mainMenus[0]+ " 메뉴가 삭제됩니다.");

			} // 입력값이 yes일때 메뉴 삭제를 실행한다.
			break ;
		case 2 :
			break ;
		case 3 :
			break ;
		
		} //switch문 종료
		return mainMenus;
		
	} // mainDel 메서드 생성

	static int[] adminPrice(int[] mainMenuPrices, String[] mainMenus) {
		// 메인메뉴 가격 수정 메서드 생성
		Scanner inputInt = new Scanner(System.in);
		Scanner inputStr = new Scanner(System.in);
		boolean run = true; // while문 실행용

		System.out.println("********************");
		System.out.println(" 가격 수정 페이지입니다.");
		while (run) {
			System.out.println("********************");
			System.out.println(" 가격을 수정합니다.");
			System.out.println("********************");
			System.out.println("수정하실 메뉴의 번호를 입력하세요.");
			for (int i = 0; i < mainMenus.length; i++) {
				System.out.println((i + 1) + ". " + mainMenus[i] + " " + mainMenuPrices[i] + "p");
			} // 메뉴 보여주기용 for문 생성
			System.out.print("입력 :");
			int changeMenuNameNum = inputInt.nextInt();

			switch (changeMenuNameNum) { // 변경할 가격 입력할 switch문 생성
			case 1:
				System.out.println(mainMenus[0] + " 의 가격을 수정합니다.");
				System.out.print("변경하실 가격입력 :");
				int changePrice1 = inputInt.nextInt();

				mainMenuPrices[0] = changePrice1; // 키보드로 입력된 값을 mainMenuPrices 인덱스 0번에 넣는다.
				System.out.println("********************");
				System.out.println(mainMenus[0] + "가격 :" + mainMenuPrices[0] + "p 변경되었습니다.");
				break;

			case 2:
				System.out.println(mainMenus[1] + "의 가격을 수정합니다.");
				System.out.print("변경하실 가격입력 :");
				int changePrice2 = inputInt.nextInt();

				mainMenuPrices[1] = changePrice2; // 키보드로 입력된 값을 mainMenuPrices 인덱스 1번에 넣는다.
				System.out.println("********************");
				System.out.println(mainMenus[1] + "가격 :" + mainMenuPrices[1] + "p 변경되었습니다.");
				break;

			case 3:
				System.out.println(mainMenus[2] + " 의 가격을 수정합니다.");
				System.out.print("변경하실 가격입력 :");
				int changePrice3 = inputInt.nextInt();

				mainMenuPrices[2] = changePrice3; // 키보드로 입력된 값을 mainMenuPrices 인덱스 2번에 넣는다.
				System.out.println("********************");
				System.out.println(mainMenus[2] + "가격 :" + mainMenuPrices[2] + "p 변경되었습니다.");
				break;

			default:
				System.out.println("잘못입력하셨습니다.");
				break;

			} // 가격 수정 switch문 종료

			System.out.println("********************");
			System.out.println("1. 다른 가격 수정하기");
			System.out.println("2. 메인으로 이동하기");
			System.out.print(">>>");
			int select = inputInt.nextInt();
			switch (select) {
			case 1:
				System.out.println("********************");
				break;
			case 2:
				run = false;
				break;
			} // 메인으로 빠져나가기 select switch문
		} // 가격수정 while문 종료

		return mainMenuPrices;

	} // adminPrice메서드 종료

	static String[] adminMenu(String[] mainMenus) {
		// 관리자용 메뉴 수정 메서드 생성
		Scanner inputInt = new Scanner(System.in);
		Scanner inputStr = new Scanner(System.in);
		boolean run = true; // while문 실행용

		System.out.println("********************");
		System.out.println("  메뉴 수정 페이지입니다.");

		while (run) {
			System.out.println("********************");
			System.out.println(" 메뉴 이름을 수정합니다.");
			System.out.println("********************");
			System.out.println("수정하실 메뉴의 이름 입력하세요.");
			System.out.print("입력 :");
			String changeMenuName = inputStr.next();

			for (int i = 0; i < mainMenus.length; i++) {
				if (changeMenuName.equals(mainMenus[i])) {
					System.out.println("1." + mainMenus[i] + " 의 이름을 변경합니다.");
					System.out.println("변경 내용을 입력해주세요.");
					System.out.print("입력 :");
					String menuName = inputStr.next();
					mainMenus[0] = menuName;
					System.out.println("1번 메뉴 이름 --> " + mainMenus[i] + "으로 변경되었습니다.");
				} else if (changeMenuName.equals(mainMenus[i])) {
					System.out.println("잘못입력하셨습니다.");
				} // 메뉴이름변경 if문 종료
			} // 메뉴이름변경 for문 종료

			System.out.println("********************");
			System.out.println("1. 다른 이름 수정하기");
			System.out.println("2. 메인으로 이동하기");
			System.out.print(">>>");
			int select = inputInt.nextInt();
			switch (select) {
			case 1:
				System.out.println("********************");
				break;
			case 2:
				run = false;
				break;
			} // 메인으로 이동 select switch문

			break;

		} // switch문 종료
		return mainMenus;
	} // adminMenu 메서드 종료

	static int menuOrder(int point, String[] mainMenus, String[] addMenus, int[] mainMenuPrices) {
		// 메인 메뉴 주문하기 메서드 생성
		String orderMenu = "";
		Scanner inputInt = new Scanner(System.in);

		System.out.println("==========================");
		System.out.println("주문하실 메뉴의 번호를 눌러주세요.");
		System.out.println("==========================");
		for (int i = 0; i < mainMenus.length; i++) {
			System.out.println((i + 1) + ". " + mainMenus[i]);
		} // for문종료
		System.out.print(">>>");
		int select = inputInt.nextInt();
		if (point > mainMenuPrices[select - 1]) {
			switch (select) {
			case 1:
				// if (point >=mainMenuPrices[0] )
				System.out.println(mainMenus[0] + " 메뉴를 주문합니다.");
				System.out.println(mainMenus[0] + "가격은 " + mainMenuPrices[0] + "point");
				point = point - mainMenuPrices[0];
				// System.out.println("사용 후 잔여 포인트 :" + point);
				orderMenu = mainMenus[0];
				break;

			case 2:
				System.out.println(mainMenus[1] + " 메뉴를 주문합니다.");
				System.out.println(mainMenus[1] + "가격은 " + mainMenuPrices[1] + "point");
				point = point - mainMenuPrices[1];
				// System.out.println("사용 후 잔여 포인트 :" + point);
				orderMenu = mainMenus[1];
				break;

			case 3:
				System.out.println(mainMenus[2] + " 메뉴를 주문합니다.");
				System.out.println(mainMenus[2] + "가격은 " + mainMenuPrices[2] + "point");
				point = point - mainMenuPrices[2];
				// System.out.println("사용 후 잔여 포인트 :" + point);
				orderMenu = mainMenus[2];
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
				addtopping(point, mainMenus, addMenus, mainMenuPrices); // 토핑 추가 메서드로 이동
				break;

			case 2:
				break;
			} // 토핑추가 switch문

			if (subSelect == 1) {

				// System.out.println(i+1 + ". " + addMenus[i]);

			} else {
				System.out.println("주문이 완료되었습니다.");
				System.out.println("사용 후 잔여 포인트 :" + point);
			} // 주문 후 포인트 결제 안쪽if문 종료
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
	} // 메뉴 주문 menuOrder메서드 종료

	static int addtopping(int point, String[] mainMenus, String[] addMenus, int[] mainMenuPrices) {
		// 토핑추가 메서드
		Scanner inputInt = new Scanner(System.in);

		System.out.println("==========================");
		System.out.println(" 토핑 추가 메뉴입니다.");
		System.out.println("==========================");
		System.out.println("원하시는 토핑의 번호를 눌러주세요.");
		System.out.println("1.계란 | 2.파 | 3. 고춧가루 ");
		System.out.print(">>>");
		int addSelect = inputInt.nextInt();

		switch (addSelect) {
		case 1:
			System.out.println("==========================");
			System.out.println(addMenus[0] + "추가");
			System.out.println("==========================");
			break;

		case 2:
			System.out.println(addMenus[1] + "추가");
			System.out.println("==========================");
			break;

		case 3:
			System.out.println(addMenus[2] + "추가");
			System.out.println("==========================");
			break;

		} // 토핑추가 switch문
		return addSelect;

	} // 토핑추가 addtopping 메서드 종료

	static void menuCheck(String[] mainMenus, String[] addMenus, int[] mainMenuPrices) {
		// 메뉴 보기 메서드
		Scanner inputInt = new Scanner(System.in);

		System.out.println("==========================");
		System.out.println("메뉴를 확인해주세요.");
		for (int i = 0; i < mainMenus.length; i++) {
			System.out.println(i + 1 + ". " + mainMenus[i] + " " + mainMenuPrices[i] + " 원");
		} // for문 종료
		System.out.println("==========================");
		System.out.println("    이전 화면으로 되돌아갑니다. ");
		System.out.println("==========================");

	} // menuCheck 메서드 종료

	static int fillUp(int point) {
		// 포인트 충전하기 메서드
		Scanner inputInt = new Scanner(System.in);

		System.out.println("======== 포인트 충전 ========");
		System.out.println("1. 포인트 충전하기");
		System.out.println("0. 이전 화면으로");
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

	} // 포인트 충전하기 fillup 메서드 종료

}// class종료
