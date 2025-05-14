package ch02;

public class SwitchStringExam {

	public static void main(String[] args) {
				// string 타입의 switch문
		String position = "과장";
		switch (position) {
		case "부장" :
		System.out.println(position + "성과급 1000만원");
		break;
		case "과장" : 
		System.out.println(position + "성과급 2000만원");
		break;
		case "대리" :
		System.out.println(position + "성과급 3000만원");
		break;
		default :
			System.out.println("성과급 없음");
			break;
		} // switch문 종료

	} // main 매서드 종료

} // class 종료
