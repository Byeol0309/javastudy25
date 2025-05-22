package ch03;

public class StringNullExam01 {

	public static void main(String[] args) {
		// String값 비교 실습
		// String은 문자열이기때문에 > = 와 같은 비교 연산자는 사용할 수 없고
		// == , != 과 같은 동등 비교 연산자를 사용해야한다.
		// String객체의 문자열 값을 비교하려면
		// 변수.equals(비교대상변수값)를 사용하여 비교해야한다.
		String StrVar1 = "안녕" ; // string객체생성
		String StrVar2 = "안녕" ; // 같은 객체가 있어서 생성은 하지 않고
		String StrVar3 = new String("안녕"); // 새로운 객체 생성
		
		if (StrVar1 == StrVar2) {
			System.out.println("StrVar1과 StrVar2는 참조가 같습니다.");
		}else {
			System.out.println("StrVar1과 StrVar2는 참조가 다릅니다.");
		}
		if (StrVar1.equals(StrVar2)) {
			System.out.println("StrVar1과 StrVar2는 문자열이 같습니다.");
		} else {
			System.out.println("StrVar1과 StrVar2는 문자열이 다릅니다.");
		}
		
		if (StrVar3.equals(StrVar1)) {
			System.out.println("StrVar3과 StrVar1는 문자열이 같습니다.");
		}else {
			System.out.println("StrVar3과 StrVar1는 문자열이 다릅니다.");
		}
		
		if(StrVar3 == StrVar1) {
			System.out.println("StrVar3과 StrVar1는 참조값이 같습니다.");
		}else {
			System.out.println("StrVar3과 StrVar1는 참조값이 다릅니다.");

		} // if-else문 종료

	} //main메서드종료

}//class종료
