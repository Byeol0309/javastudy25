package ch02;

import java.util.Scanner;

public class SwitchExam5 {

	public static void main(String[] args) {
		// 사용자 지정 메서드를 void말고 리턴받아 처리하는 코드.
		
		Scanner inputStr = new Scanner(System.in);
		System.out.println("동물의 이름을 입력하세요.");
		System.out.print(">>>");
		String monster = inputStr.next(); // String타입 변수monster에 키보드로 입력된 String(문자열)값을 넣는다.
		String kind = whoIsIt(monster); // String타입의 변수 kind에 whoIsIt메서드의 monster변수의 값을 넣는다.
		System.out.println(monster +"는" + kind +" 로 판단됩니다.");

	}//main메서드종료

	static String whoIsIt(String monster) {
		String kind = null ;
		switch(monster) {
		case "호랑이", "사자", "강아지", "고양이"  -> kind = "포유류" ;
		case "독수리", "참새", "까마귀", "비둘기"  -> kind = "조류" ;
		case "고등어", "연어", "참치", "갈치"     -> kind = "어류" ;
		default -> kind = "알수없는 개체입니다." ;
		}
		return kind;
		
	} //whoIsIt메서드종료

}//class종료
