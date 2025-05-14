package ch02;

public class IfExam5 {

	public static void main(String[] args) {
		// if문으로 주사위게임 만들기
		int num = (int) (Math.random( )* 6) + 1;
		// 1~6까지의 난수 발생시킨다.

		System.out.println("주사위의 값" + num);
		
		if (num == 1) {
			System.out.println("1번이 나왔습니다.");
		} else if (num == 2 ) {
			System.out.println("2번이 나왔습니다.");
		} else if (num == 3 ) {
			System.out.println("3번이 나왔습니다.");
		} else if (num == 4 ) {
			System.out.println("4번이 나왔습니다.");
		} else if (num == 5 ) {
			System.out.println("5번이 나왔습니다.");
		} else if (num == 6 ) {
			System.out.println("6번이 나왔습니다.");
		} else {
			System.out.println("프로그램 오류로 점검이 필요합니다.");
		}
		
		int num1 = (int)(Math.random()*45) + 1 ; 
		// num1에 난수 1~45까지의 난수를 발생시킨다.
		// 0부터 생성하기때문에 1을 더해줌.
		int num2 = (int)(Math.random()*45) + 1 ; 
		int num3 = (int)(Math.random()*45) + 1 ; 
		int num4 = (int)(Math.random()*45) + 1 ; 
		int num5 = (int)(Math.random()*45) + 1 ; 
		int num6 = (int)(Math.random()*45) + 1 ; 
		// 6개의 난수 생성
		System.out.println("이번주 당첨 번호");
		System.out.print(num1 + " " + num2 + " " + num3 + " " + num4 + " " + num5 + " " +num6 + " " );

		
	} // main 메소드 종료

} // class 클래스 종료
