package ch02;

import java.util.Scanner;

public class SwitchExam4 {

	public static void main(String[] args) {
		// 개선된 switch문을 사용해보자 . => 람다식이 적용되어있음.
		// 람다식이라는것은   -> 화살표를 이용하여 값을 전달하는것.
		// (메서드는 동작)에 해당하는 기능을 main메서드 바깥쪽에 만들것이다.
		Scanner inputStr = new Scanner(System.in); // 키보드로 String 입력받을것임 Scanner 생성
		boolean  run = true ; // while문 용 boolean 생성
		String monster ; // 키보드로 입력된 값을 monster에 넣을것임
		while(run) {
			System.out.println("파악하고 싶은 동물 이름을 입력하세요.");
			System.out.print(">>>");
			monster = inputStr.next(); // 위에 키보드로 입력된 값을 변수 monster에 넣는다.
			whoIsIt(monster); //whoIsIt메서드를 호출하여 monster값 전달
								// whoIsIt 메서드를 만들어야함.
		}

		
	}//main메서드종료
		//사용자 정의 메서드 추가
		//whoIsIt라는 메서드 생성   (문자열   monster)가 들어온다.
	private static void whoIsIt(String monster) {
		// void는 리턴값이 없을때 사용한다.
		String kind = null ; // 값이 없는 kind 변수에 문자열 타입 선언.
		switch(monster) {
		case "호랑이", "사자", "강아지", "고양이"  -> kind = "포유류" ;
		case "독수리", "참새", "까마귀", "비둘기"  -> kind = "조류" ;
		case "고등어", "연어", "참치", "갈치"     -> kind = "어류" ;
		default -> kind = "알수없는 개체입니다." ;
		} // switch문 종료
		System.out.println(monster + "는" + kind + "로 판단됩니다.");
	} //whoIsIt메서드 종료

}//class종료
