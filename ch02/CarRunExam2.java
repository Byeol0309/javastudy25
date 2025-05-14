package ch02;

public class CarRunExam2 {

	public static void main(String[] args) throws Exception{ 
		// 키보드의 입력을 받아 제어하는 실행문
		// 숫자1을 입력하면 속도를 증가
		// 숫자2를 입력하면 속도를 감소
		// 숫자3을 입력하면 종료
		// 키보드로 입력받는 키코드 리턴 -> int keyCode = System.in.read();
		
		boolean run = true ; // 실행여부를 판단
		int speed = 100 ; // 현재 속도는 100km/h
		int keyCode = 0 ; // 키보드로 입력되는 값
		
		while (run) {// run에 초기값이 true이기 때문에 주행중이라는 뜻
			if (keyCode !=13 && keyCode != 10) { // 엔터가 아니면
				System.out.println("-----------------------------");
				System.out.println(" 1.엑셀  | 2. 브레이크  | 3. 중지 ");
				System.out.println("-----------------------------");
				System.out.println("선택 : ");
			}//if문 종료
			keyCode = System.in.read();
			//System.out.println(keyCode);
			
			if (keyCode == 49) {
				speed += 5 ;
				System.out.println("현재 속도 : " + speed);
			} else if (keyCode == 50) {
				speed -= 5 ;
				System.out.println("현재 속도 : " + speed);
			} else if (keyCode == 51) {
				run = false ;
				System.out.println("크루즈 기능이 종료됩니다.");
				System.out.println("현재 속도 : " + speed);
				System.out.println("안전운전 하세요.!");
			}
		} //while문 종료
		System.out.println("프로그램 종료");
	}//main메소드종료

}//class종료
