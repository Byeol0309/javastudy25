package ch02;

import java.util.Scanner;

public class SwitchIfExam1 {

	public static void main(String[] args) {
		// switch���� Ȱ���Ͽ� Ŀ�� �ֹ� �ý��� �����
		System.out.println("메뉴를 주문하시겠습니까?");
		System.out.println("주문을 원하시면 1번");
		System.out.println("원하지 않으시면 2번");
		System.out.print("입력해주세요>>>");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		if (num == 1) {
			System.out.println("원하시는 메뉴를 선택해주세요");
			System.out.println(" 1. 아이스 아메리카노 ");
			System.out.println(" 2. 아이스 라떼 ");
			System.out.println(" 3. 아이스 커피 ");
			System.out.println(" 4. 아이스 밀크");
			System.out.print("입력란 : ");
			int menu = in.nextInt();
			
			switch (menu) {
			case 1 :
				String menuName = "아이스 아메리카노" ;
				int price = 3000 ;
				System.out.println(menuName + price + "원 입니다.");
			break;
			
			case 2 :
				menuName = "아이스 라떼" ;
				price = 3500 ;
				System.out.println(menuName + price + "원 입니다.");
			break;
			
			case 3 :
				menuName = "아이스 커피" ;
				price = 2800 ;
				System.out.println(menuName + price + "원 입니다.");
			break;
			
			case 4 :
				menuName = "아이스 밀크" ;
				price = 2500 ;
				System.out.println(menuName + price + "원 입니다.");
			break;
			default :
				System.out.println("잘못입력하셨습니다.");
			break;
			} // switch문 종료
		} else {
			System.out.println("다시입력해주세요.");
		}//if문 종료
	} // main 문 종료

} // class 종료
